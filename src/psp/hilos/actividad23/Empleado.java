package psp.hilos.actividad23;

import java.util.concurrent.Semaphore;

public class Empleado implements Runnable{

    private long TIEMPO_TRABAJO;
    private long tiempo_descanso;
    private Semaphore mesa;
    private Semaphore ordenador;

    public Empleado(Semaphore mesa,Semaphore ordenador){
        this.mesa=mesa;
        this.ordenador=ordenador;
        this.TIEMPO_TRABAJ0=tiempo;
    }



    @Override
    public void run() {

    }
}
