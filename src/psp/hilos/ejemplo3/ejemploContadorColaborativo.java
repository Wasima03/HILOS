package psp.hilos.ejemplo3;

public class ejemploContadorColaborativo {

    private static int valor=0;
    private static final int THREADS=10;
    private static final int INCREMENTS_PER_THREAD=100000;

    synchronized public void incrementa(){ //obliga a los hilos que no pasen or este codigo, mientras que ya hay uno dentro
        int valorPrevio=valor;
        valor=valor+1;

        if (valorPrevio != valor-1){
            System.out.println("Valor previo: "+valorPrevio+" Valor nuevo: "+valor);
        }

    }
    public static void main(String[] args) {

        ejemploContadorColaborativo ecc = new ejemploContadorColaborativo();
        Thread[] threads = new Thread[THREADS];
        for (int i=0;i<THREADS;i++){
            threads[i] =new Thread(() -> {
                for (int j=0;j<INCREMENTS_PER_THREAD;j++){
                    ecc.incrementa();
                }
            });
            threads[i].start();
        }

        for (Thread t:threads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Esperado: "+(THREADS*INCREMENTS_PER_THREAD));
        System.out.println("Obtenido: "+valor);


    }
}
