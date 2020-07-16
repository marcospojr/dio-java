package avancado.aula3.futureexemplo;

import avancado.aula3.futureexemplo.model.Casa;
import avancado.aula3.futureexemplo.model.Quarto;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExemplo {
    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        Casa casa = new Casa(new Quarto());

        //O CopyOnWriteArrayList a torna uma lista segura, possibilitando remover objetos na iteração
        List<Future<String>> futuros =
                new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                        .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
                                    try {
                                        return atividade.realizar();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    return null;
                                })
                        )
                        .collect(Collectors.toList()));

        while (true){
            int numeroDeAtividadesNaoFinalizadas = 0;
            for (Future<?> futuro : futuros) {
                if (futuro.isDone()){
                    try {
                        System.out.println("Parabens voce terminou de "+futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    numeroDeAtividadesNaoFinalizadas++;
                }
            }
            if (futuros.stream().allMatch(Future::isDone)){
                break;
            }
            System.out.println("Numero de atividades nao finalizadas :: "+numeroDeAtividadesNaoFinalizadas);
            Thread.sleep(500);
        }
        pessoasParaExecutarAtividade.shutdown();
    }
}



