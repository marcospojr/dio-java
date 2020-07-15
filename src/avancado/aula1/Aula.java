package avancado.aula1;

import java.util.function.UnaryOperator;

public class Aula {

    public static void main(String[] args) {
        UnaryOperator<Integer> calcularValorVezesTres = valor -> valor*3;

        int valor = 10;
        System.out.println("O resultado é: " + calcularValorVezesTres.apply(valor));


        Funcao1 funcao1 = valor1 -> {
            return valor1;
        };
        System.out.println(funcao1.gerar("Joao"));

    }

    interface Funcao1 {
        String gerar(String valor);
    }

}
