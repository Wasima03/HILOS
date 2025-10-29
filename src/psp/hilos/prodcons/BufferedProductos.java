package psp.hilos.prodcons;

import java.nio.Buffer;

public class BufferedProductos {
    public static final int DEFAULT_MAX_CAPACIDAD = 10;
    private int[] buffer;
    private int siguiente;

    private boolean estaVacio;
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

    public int consumir() throws InterruptedException {
        while (estaVacio) {
            wait();
        }
        siguiente--;
        if(siguiente==0){
            estaVacio=true;
        }
        estaLleno=false;
        notifyAll();

        return(buffer[siguiente]);
    }

}
