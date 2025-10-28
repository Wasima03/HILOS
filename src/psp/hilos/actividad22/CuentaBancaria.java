package psp.hilos.actividad22;

public class CuentaBancaria {
    public final int SALDO_INICIAL=1000;
    private int saldoActual;
    public int transacciones;

    public  CuentaBancaria(){
        this.saldoActual=SALDO_INICIAL;

    }
    public int getSaldoActual(){
        return this.saldoActual;
    }

    public int getSaldoInicial(){
        return this.SALDO_INICIAL;
    }

    synchronized public void retirarDinero(int cantidad){
        if (cantidad>saldoActual){
            System.out.println("Saldo insuficiente, sólo se pueden retirar "+saldoActual+"€ de "+cantidad+"€");
            cantidad=saldoActual;
            saldoActual-=cantidad;
        }
        else {
            saldoActual -= cantidad;
        }
    }
    synchronized public void depositarDinero(int dinero){

        this.saldoActual+=dinero;
        this.transacciones+=dinero;
    }

    public int getTransacciones() {
        return transacciones;
    }
}
