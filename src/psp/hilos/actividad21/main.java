package psp.hilos.actividad21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException {
        List<Triangulo> hilos=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int prioridad=0;
        System.out.print("¿Cuántos triángulos quieres calcular? ");
        int num=sc.nextInt();
        sc.nextLine();
        System.out.print("¿Quiere asignar prioridad al cálculo de los triángulos? (S/N)");
        String opc = sc.nextLine();
        int contador=0;
        System.out.println();
        while (contador!=num){
            System.out.println("Triángulo "+(contador+1)+":");
            System.out.print("Introduce la base: ");
            float base= sc.nextFloat();
            System.out.print("Introduce la altura: ");
            float altura= sc.nextFloat();
            if (opc.equalsIgnoreCase("s")){
                System.out.print("Introduce la prioridad del 1 al 10: ");
                try{
                    prioridad=sc.nextInt();
                    hilos.add(new Triangulo(altura,base));

                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }else{
                hilos.add(new Triangulo(altura,base));
            }
            contador+=1;

        }
        int n=1;
        for(Triangulo t : hilos){
            t.setName("Triángulo "+n);
            if (opc.equalsIgnoreCase("s")){
                t.setPriority(prioridad);
            }
            t.start();
            n+=1;
        }
        for(Triangulo t : hilos){
            t.join();
        }
        System.out.println("Fin del programa...");
    }
}
