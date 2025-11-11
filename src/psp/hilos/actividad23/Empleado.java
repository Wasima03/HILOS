package psp.hilos.actividad23;
import java.util.concurrent.Semaphore;
public class Empleado implements Runnable{
    private final long MAX_TRABAJO=10;
    private final long MAX_DESCANSO=10;
    private Semaphore puesto;
    private Semaphore ordenador;

    public Empleado(Semaphore puesto, Semaphore ordenador){
        this.puesto=puesto;
        this.ordenador=ordenador;
    }

    @Override
    public void run() {
        int opc=(int)(Math.random()*2);
        if(opc==0){
            try {
                puesto.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(ordenador.tryAcquire()){
                System.out.println(Thread.currentThread().getName()+" trabajando...");
                try {
                    Thread.sleep(MAX_TRABAJO);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ordenador.release();
            }else{
                System.out.println(Thread.currentThread().getName()+" no ha podido coger un ordenador y se levanta de la mesa");
            }
            puesto.release();
            System.out.println(Thread.currentThread().getName()+" descansando");
            try {
                Thread.sleep((long)(Math.random()*MAX_DESCANSO));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                ordenador.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(puesto.tryAcquire()){
                System.out.println(Thread.currentThread().getName()+" trabajando...");
                try {
                    Thread.sleep(MAX_TRABAJO);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ordenador.release();
            }else{
                System.out.println(Thread.currentThread().getName()+" no ha podido coger un puesto y deja el ordenador");
            }
            puesto.release();
            System.out.println(Thread.currentThread().getName()+" esperando");
            try {
                Thread.sleep((long)(Math.random()*MAX_DESCANSO));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
