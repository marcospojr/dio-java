package avancado.aula2;

public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calculo soma =  ( a, b) -> a+b;
        Calculo sub =  ( a, b) -> a-b;
        Calculo div =  ( a, b) -> a/b;
        Calculo mult =  ( a, b) -> a*b;

        System.out.println(executarOperacao(soma,1,3));
        System.out.println(executarOperacao(sub,5,3));
        System.out.println(executarOperacao(div,9,3));
        System.out.println(executarOperacao(mult,10,3));

    }


    public static int executarOperacao(Calculo calculo,int a, int b){
        return calculo.calcular(a,b);
    }
}


// @FunctionalInterface declara uma interface funcional, porém é opcional a notação
@FunctionalInterface
interface Calculo {
    public int calcular(int a, int b);
}