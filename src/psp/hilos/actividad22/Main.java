package psp.hilos.actividad22;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el núemro de clientes: ");
        int numClientes=sc.nextInt();
        CuentaBancaria cb = new CuentaBancaria();
        Thread[] hilos = new Thread[numClientes];
        int total=0;
        for(int i=0;i<numClientes;i++) {
            hilos[i] = new ClienteBanco(cb, 5, 1000, 2);
            hilos[i].setName("Cliente" + (i + 1));
            hilos[i].start();
        }
        for (int i = 0; i < numClientes; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Saldo inicial: "+cb.getSaldoInicial()+"€");
        System.out.println("Saldo actual: "+cb.getSaldoActual()+"€");
        System.out.println("Total transacciones: "+cb.getTransacciones()+"€");
    }
}
