package psp.hilos.prodcons;

import java.nio.Buffer;

public class BufferedProductos {
    public static final int DEFAULT_MAX_CAPACIDAD = 10;
    private int[] buffer;
    private int siguiente;

    boolean estaVacio;
    private boolean estaLleno;

    public BufferedProductos(int capacidad) {
        buffer = new int[capacidad];
        siguiente = 0;
        estaVacio = true;
        estaLleno = false;
    }

    public BufferedProductos() {
        this(DEFAULT_MAX_CAPACIDAD);
    }

    public synchronized int consumir() throws InterruptedException { //parte de cinsumir, si el bufer esta vacio, no puede consumir, y espera
        while (estaVacio) {
            System.out.println("Buffer vacio");
            wait();
        }
        siguiente--;
        if(siguiente==0){
            estaVacio=true;
        }
        estaLleno=false;
        notifyAll(); //avisamos que hay un hueco para que consuma

        return(buffer[siguiente]);
    }

    public synchronized void producir(int produccto) throws InterruptedException{
        while(estaLleno){
            wait();
        }
        buffer[siguiente]=produccto;
        siguiente++;

        if(siguiente==buffer.length){
            estaLleno=true;
        }
        System.out.println("Se ha producido el producto"+produccto);
        estaVacio=false;
        notifyAll();

    }
    public boolean estaVacio(){
        return estaVacio;
    }

}
