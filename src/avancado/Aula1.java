package avancado;

import java.util.function.UnaryOperator;

public class Aula1 {

    public static void main(String[] args) {
        UnaryOperator<Integer> calcularValorVezesTres = valor -> valor*3;

        int valor = 10;
        System.out.println("O resultado é: " + calcularValorVezesTres.apply(valor));
    }
}
