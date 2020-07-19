package avancado.aula5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class InterferenciaExemplo {

    // SOBRE A INFERENCIA COM "VAR"

    // não pode ser utilizado a nível de classe
    // não pode ser utilizado como parâmetro
    // não pode ser utilizado em variáveis locais não inicializadas

    // pode ser utilizado em variáveis locais inicializadas
    // pode ser utilizado em variável suporte do enhaced for
    // pode ser utilizado em variável suporte do for iterativo




    public static void main(String[] args) throws IOException {
        printarSoma(1,2,3,4,5);
        printarNomeCompleto("Marcos", "Junior");
        connectAndPrintURLJavaOracle();
    }

    private static void connectAndPrintURLJavaOracle() throws IOException {

        try{
            var url = new URL("https://docs.oracle.com/javase/10/language/");
            var urlConnection = url.openConnection();

            try(var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
                System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
            }
        } catch (Exception e) {

        }
    }

    public static void printarNomeCompleto(String nome, String sobrenome) {
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void printarSoma(int... numeros) {
        int soma = 0;
        if (numeros.length > 0) {
            soma = 0;
            for (var numero : numeros) {
                soma += numero;
            }
        }

        System.out.println("A soma é: " + soma);
    }
}
