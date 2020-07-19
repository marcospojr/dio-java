package avancado.aula6;

import java.util.Collection;
import java.util.Set;

public class CollectionExemplo {

    public static void main(String[] args) {
        Collection<String> nomes = Set.of("Marcos", "Pereira", "de", "Oliveira", "Junior");

        System.out.println(nomes);
    }
}