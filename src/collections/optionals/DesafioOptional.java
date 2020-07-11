package collections.optionals;

import java.util.Optional;

public class DesafioOptional {
    public static void main(String[] args) {

        String regraNegocio = "";

        Optional<String> optionalEmpty = Optional.empty();
        Optional<String> optionalString = Optional.of("presente value");
        Optional<String> optionalNull = Optional.ofNullable(null);

        // present
        regraNegocio = optionalString.get();

        if (regraNegocio.equals("presente value")) {
            System.out.println("Entrou na regra: " + regraNegocio);
        }

        // empty
        optionalEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("Optional Vazio"));
        optionalEmpty.orElseThrow(IllegalStateException::new);

    }
}
