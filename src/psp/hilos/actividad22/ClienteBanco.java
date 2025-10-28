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
    private int tipo;
    private CuentaBancaria cuenta;

    public ClienteBanco(CuentaBancaria cuenta,int maxOperaciones,int maxCantidad,int maxTiempo){
        this.maxOperaciones=maxOperaciones;
        this.maxCantidad=maxCantidad;
        this.maxTiempo=maxTiempo;
        this.cuenta=cuenta;
    }
    public int getTransacciones(){
        return transacciones;
    }

    public void run() {
        operaciones=(int) (random()* maxOperaciones)+1;
        transacciones=0;
        for (int i = 0; i<operaciones;i++){
            cantidad=(int) (random()*maxCantidad)+1;
            tiempo=(int)(random()*maxTiempo)+1000;
            tipo=(int)(Math.random()*2);

            if(tipo==0){
                cuenta.depositarDinero(cantidad);
                System.out.println(this.getName()+" ha depositado "+cantidad+"€");
                transacciones+=cantidad;
            }
            else{
                cuenta.retirarDinero(cantidad);
                System.out.println(this.getName()+" ha retirado "+cantidad+"€");
            }
            try{
                Thread.sleep(tiempo);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

}
