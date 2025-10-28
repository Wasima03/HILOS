package psp.hilos.actividad22;

import static java.lang.Math.random;

public class ClienteBanco extends Thread{
    private int operaciones;
    private int maxOperaciones;
    private int maxCantidad;
    private int maxTiempo;
    private int cantidad;
    private int tiempo;
    private int transacciones;

    public ClienteBanco(int maxOperaciones,int maxCantidad,int maxTiempo){
        this.maxOperaciones=maxOperaciones;
        this.maxCantidad=maxCantidad;
        this.maxTiempo=maxTiempo;
    }
    public int getTransacciones(){
        return transacciones;
    }

   synchronized public void run() {
        CuentaBancaria cb = new CuentaBancaria();
        operaciones=(int) random();
        transacciones=0;
        for (int i = 0; i<operaciones;i++){
            cantidad=(int) random()*maxCantidad;
            tiempo=(int)random()*maxTiempo;

            cb.depositarDinero(cantidad);

            System.out.println(this.getName()+"ha depositado"+cantidad);
            transacciones+=cantidad;

        }
    }

}
