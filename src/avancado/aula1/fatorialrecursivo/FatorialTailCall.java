package avancado.aula1.fatorialrecursivo;

//pode gerar um StackOverFlow na JVM

public class FatorialTailCall {
    public static void main(String[] args) {
        System.out.println(fatorialA(100000));
    }
    public static double fatorialA( double valor ) {
        return fatorialComTailCall(valor,1);
    }
    public static double fatorialComTailCall(double valor, double numero){
        if (valor == 0){
            return numero;
        }
        return fatorialComTailCall(valor-1,numero*valor);
    }

}