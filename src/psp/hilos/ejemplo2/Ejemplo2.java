package psp.hilos.ejemplo2;

public class Ejemplo2 {
    public static void main(String[] args) throws InterruptedException {

        Hilo h1 = new Hilo();
        h1.setName("hilo 1");

        Hilo h2 = new Hilo();
        h2.setName("hilo 2");

        Hilo h3 = new Hilo();
        h3.setName("hilo 3");

        System.out.println("Comienzo de la ejecución");

        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(Thread.MAX_PRIORITY);
        h3.setPriority(Thread.NORM_PRIORITY);

        h1.start();
        h2.start();
        h3.start();

        h1.join();
        h2.join();
        h3.join();

        System.out.println("Fin de la ejecucion de los hilos");



    }



}
