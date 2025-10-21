package psp.hilos.actividad21;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos triángulos quieres calcular? ");
        int num=sc.nextInt();
        System.out.print("¿Quiere asignar prioridad al cálculo de los triángulos? (S/N)");
        String opc = sc.nextLine();
        sc.nextLine();
        int contador=0;
        System.out.println();
        while (contador!=num){
            System.out.println("Triángulo "+(contador+1)+":");
            System.out.print("Introduce la base: ");
            float base= sc.nextFloat();
            System.out.print("Introduce la altura: ");
            float altura= sc.nextFloat();
            if (opc.equalsIgnoreCase("s"));{
                System.out.print("Introduce la prioridad del 1 al 10: ");
                try{
                    int pr=sc.nextInt();


                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }

            contador+=1;

        }
    }
}
