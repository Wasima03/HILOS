package psp.hilos.ejemplo2;

public class Hilo extends Thread{

    @Override
    public void run(){

        for(int i=0;i>=5;i++){
            System.out.println("Nombre del hilo: "+ this.getName()+" Contador: "+i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
