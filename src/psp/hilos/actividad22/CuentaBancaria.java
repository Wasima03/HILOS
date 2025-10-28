package psp.hilos.actividad22;

public class CuentaBancaria {
    final int SALDO_INICIAL=1000;
    private int saldoActual;

    public void CuentaBancaria(){

    }
    public int getSaldoActual(){
        return saldoActual;
    }
    public int getSaldoInicial(){
        return saldoActual;
    }
    public void retirarDinero(int cantidad){
        if (cantidad>saldoActual){
            System.out.println("Saldo insuficiente, sólo se pueden retirar"+saldoActual+"€ de"+cantidad+"€");
            cantidad=saldoActual;
            saldoActual= 0;
        }
        saldoActual-=cantidad;
    }
    public void depositarDinero(int dinero){
        saldoActual+=dinero;
    }


}
