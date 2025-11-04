package psp.hilos.prodcons;

public class Productor implements Runnable{

    private BufferedProductos bufferedProductos;
    private final int idProductor;
    private final int numProductos;

    public Productor(int idProductor,int numProductos,BufferedProductos buffer){
        this.bufferedProductos=buffer;
        this.idProductor=idProductor;
        this.numProductos=numProductos;



    }

    @Override
    public void run() {
        for (int i=1;i<=numProductos;i++){
            int producto=idProductor*1000 + 1; //para saber que productor es
            try {
                bufferedProductos.producir(producto);
                System.out.println("Productor"+idProductor+" produjo "+producto);
                Thread.sleep((long)(Math.random()*100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
