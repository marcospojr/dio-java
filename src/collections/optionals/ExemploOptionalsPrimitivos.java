package collections.optionals;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class ExemploOptionalsPrimitivos {

    public static void main(String[] args) {

        System.out.println("Valor inteiro: ");
        OptionalInt.of(12).ifPresent(System.out::println);

        System.out.println("Valor decimal: ");
        OptionalDouble.of(14.22).ifPresent(System.out::println);

        System.out.println("Valor long: ");
        OptionalLong.of(34L).ifPresent(System.out::println);


    }
}
