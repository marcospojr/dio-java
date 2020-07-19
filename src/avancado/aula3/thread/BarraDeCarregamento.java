package avancado.aula3.thread;

public class BarraDeCarregamento extends Thread {

    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf) {
        this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);

                if (!iniciarGeradorPdf.isAlive()){
                    break;
                }
                System.out.println("Loading ... ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}