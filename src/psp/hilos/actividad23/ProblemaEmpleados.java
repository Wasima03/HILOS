package psp.hilos.actividad23;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ProblemaEmpleados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int recursos;
        try{
        System.out.print("Introduce el número de empleados: ");
        num=sc.nextInt();
        sc.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Datos introducidos no identificados.");
        }
        while(true){
            System.out.print("Introduce el número de puestos y ordenadores (tienen que ser menores que los empleados) : ");
            recursos=sc.nextInt();
            sc.nextLine();
            if(recursos<num){
                break;
            }
            else{
                System.out.println("Número no válido.");
            }
        }
        Semaphore puestos = new Semaphore(recursos);
        Semaphore ordenadores= new Semaphore(recursos);
        List<Thread> hilos = new ArrayList<>();
        for (int i=0;i<num;i++){
            Thread t = new Thread(new Empleado(puestos,ordenadores),"Empleado"+(i+1));
            t.start();
            hilos.add(t);
        }
        for (Thread t : hilos){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
