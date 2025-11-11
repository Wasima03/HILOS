package psp.hilos.actividad23;
import java.util.concurrent.Semaphore;
public class Empleado implements Runnable{
    private final long TIEMPO_TRABAJO;
    private long tiempo_descanso;
    private Semaphore puesto;
    private Semaphore ordenador;

    public Empleado(Semaphore puesto, Semaphore ordenador){
        TIEMPO_TRABAJO = (long) (Math.random()*100);
        this.puesto=puesto;
        this.ordenador=ordenador;
    }

    @Override
    public void run() {
        tiempo_descanso=(long)(Math.random()*10);
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
                    Thread.sleep(TIEMPO_TRABAJO);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ordenador.release();
            }else{
                System.out.println(Thread.currentThread().getName()+" no ha podido coger un ordenador y se levanta de la mesa");
            }
            puesto.release();
            System.out.println(Thread.currentThread().getName()+" esperando");
            try {
                Thread.sleep(tiempo_descanso);
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
                    Thread.sleep(TIEMPO_TRABAJO);
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
                Thread.sleep(tiempo_descanso);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
