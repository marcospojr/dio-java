package collections.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DesafioStreams {
    public static void main(String[] args) {

        //Cria a a coleção de estudantes
        List<Estudante> estudantes = new ArrayList<>();
        List<String> estudantesString = new ArrayList<>();

        estudantes.add(new Estudante("Pedro",22));
        estudantes.add(new Estudante("Thayse",18));
        estudantes.add(new Estudante("Marcelo",15));
        estudantes.add(new Estudante("Carla",20));
        estudantes.add(new Estudante("Juliana",17));
        estudantes.add(new Estudante("Thiago",20));
        estudantes.add(new Estudante("Rafael",18));

        estudantes.stream().forEach(estudante -> estudantesString.add(
                "nome: " + estudante.getNome().concat(", ").
                concat("idade: " + String.valueOf(estudante.getIdade()))));

        System.out.println(estudantesString);

        //Contar quantidade de estudantes
        System.out.println("Quantidade de estudantes: " + estudantes.stream().count());

        //Estudantes 18+
        System.out.println("Estudantes 18+ : " + estudantes.stream().filter(
                estudante -> estudante.getIdade() >= 18).map(Estudante::getNome).collect(Collectors.toList()));

        //Estudantes com a letra B no nome
        System.out.println("Com a letra B no nome: " + estudantes.stream().filter((estudante) ->
                estudante.getNome().toLowerCase().contains("b")).map(Estudante::getNome).collect(Collectors.toList()));

        //Se existe ao menos 1 estudante com a letra D no nome
        System.out.println("Existe ao menos 1 estudante com a letra D no nome? R: " +
                estudantes.stream().anyMatch(estudante -> estudante.getNome().contains("d")));

        //Estudantes mais velho e mais novo
        System.out.println("Estudante mais velho: " +
                estudantes.stream().max(Comparator.comparingInt(estudante -> estudante.getIdade())).map(Estudante::getNome));
        System.out.println("Estudante mais novo: " +
                estudantes.stream().min(Comparator.comparingInt(estudante -> estudante.getIdade())).map(Estudante::getNome));

    }
}
