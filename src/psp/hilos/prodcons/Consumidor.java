package psp.hilos.prodcons;

public class Consumidor implements Runnable{

    private BufferedProductos bufferedProductos;
    private final int idConsumidor;

    public Consumidor(int idConsumidor,BufferedProductos buffer){
        this.idConsumidor=idConsumidor;
        this.bufferedProductos=buffer;
    }

    @Override
    public void run() {
        int producto;
        while(true){
            try{
                producto=bufferedProductos.consumir();
                System.out.println("Consumidor"+idConsumidor+" consumio "+producto);
                Thread.sleep((long)(Math.random()*100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumidor "+idConsumidor+" interrumpido y finalizado");
                return;
            }
        }

    }
}
