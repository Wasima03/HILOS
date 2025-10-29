package psp.hilos.ejemplo3;

import static psp.hilos.ejemplo3.ContadorColaborativoSynchro.INCREMENTS_PER_THREAD;
import static psp.hilos.ejemplo3.ContadorColaborativoSynchro.THREADS;

public class ContadorObjectLock {

    private int contador1=0;
    private int contador2=0;

    private final Object lock1=new Object();
    private final Object lock2=new Object();

    public void incrementar1(){
        synchronized (lock1) { //como el synchronized del metodo pero a nivel de un objeto
            contador1++;
        }
    }

    public void incrementar2(){
        synchronized (lock2) {
            contador2++;
        }
    }

    public static void main(String[] args) {
        ContadorObjectLock contador=new ContadorObjectLock();
        Thread[] threads = new Thread[THREADS];
        for (int i=0;i<THREADS;i++){
            threads[i] =new Thread(() -> {
                for (int j=0;j<INCREMENTS_PER_THREAD;j++){
                    contador.incrementar1();
                    contador.incrementar2();
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
        System.out.println("Obtenido contador1: "+contador.contador1);
        System.out.println("Obtenido contador2: "+contador.contador2);

    }
}
