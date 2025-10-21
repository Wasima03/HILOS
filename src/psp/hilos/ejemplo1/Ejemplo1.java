package psp.hilos.ejemplo1;

public class Ejemplo1 {
    public static void main(String[] args) {
        System.out.println("CLASE PRINCIAL CORRIENDO. LANZAMINETO DE HILOS...");
        System.out.println("Hilo de la clase Ejemplo1: "+Thread.currentThread().getName());

        HiloThread ht =new HiloThread();
        ht.start(); //mejor practica llamar al start, que llama al run, que hacer directamente run

        new Thread(new HiloRunnable(),"Hilo Runnable").start(); //para crear un nuevo hilo. Si cremaos objeto y lanzamos run, no se crea un nuevo hilo
        //name para cambiarle el nombre, podemos no poner nada




    }
}