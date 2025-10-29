package psp.hilos.filosofos;

import java.util.concurrent.Semaphore;

public class ProblemaFilosofos {
    public static void main(String[] args) {

        Semaphore sem12 = new Semaphore(1); //cada semaforo solo tiene un recurso/un cubierto en medio de cada filo
        Semaphore sem23= new Semaphore(1);
        Semaphore sem31 = new Semaphore(1);

        Filosofo f1 = new Filosofo(sem12,sem31); //cada semaforo es un cubierto para cada semaforo, el que esta a su izqda yt a su derecha//etre dos filosofos hay un semaforo
        Filosofo f2 = new Filosofo(sem23,sem12);
        Filosofo f3 = new Filosofo(sem31,sem23);

        Thread h1,h2,h3;
        h1=new Thread(f1,"Filosofo1");
        h2=new Thread(f2,"Filosofo2");
        h3=new Thread(f3,"Filosofo3");

        h1.start();
        h2.start();
        h3.start();

        try{
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
