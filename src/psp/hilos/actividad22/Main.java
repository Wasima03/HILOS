package psp.hilos.actividad22;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el núemro de clientes: ");
        int numClientes=sc.nextInt();

        CuentaBancaria cb = new CuentaBancaria();
        Thread[] hilos = new Thread[numClientes];
        for(int i=0;i<=numClientes;i++){
            hilos[i] = new ClienteBanco(5,100,5);
            hilos[i].start();
        }

        System.out.println("Saldo inicial: "+cb.SALDO_INICIAL);
        System.out.println("Salario actual: "+cb.getSaldoActual());
    }


}
