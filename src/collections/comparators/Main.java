package collections.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Marcos", 22, "marcos@mail.com"));
        pessoas.add(new Pessoa("João", 25, "joao@mail.com"));
        pessoas.add(new Pessoa("Maria", 30, "maria@mail.com"));
        pessoas.add(new Pessoa("José", 21, "jose@mail.com"));
        pessoas.add(new Pessoa("Joana", 22, "joana@mail.com"));

        System.out.println("Ordem inicial: ");
        System.out.println(pessoas);

        // Deprecated
        System.out.println("Comparando os nomes utilizando lambdas (deprecated): ");
        pessoas.sort((first, second) -> first.getNome().compareTo(second.getNome()));
        System.out.println(pessoas);

        pessoas.sort(Comparator.comparing(Pessoa::getNome));
        System.out.println("Comparando os nomes com o Comparator.comparing utilizando referência de método: ");
        System.out.println(pessoas);

        Collections.sort(pessoas, new ComparePessoa().reversed());
        System.out.println("Comparando os nomes com a classe ComparePessoa: ");
        System.out.println(pessoas);

        pessoas.sort(Pessoa::compareTo);
        System.out.println("Comparando os nomes com o Comparable: ");
        System.out.println(pessoas);
    }
}
