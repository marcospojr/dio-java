package avancado.aula3.futureexemplo.model;

import avancado.aula3.futureexemplo.service.Atividade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Casa {
    private List<Comodo> comodos;

    public Casa(Comodo... comodos) {
        this.comodos = Arrays.asList(comodos);
    }

    public List<Atividade> obterAfazeresDaCasa() {
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}
