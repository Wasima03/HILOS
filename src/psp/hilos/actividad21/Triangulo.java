package psp.hilos.actividad21;

public class Triangulo extends  Thread{

    private float altura;
    private float base;
    float aux=0;

    public Triangulo(float altura,float base) {
        this.altura = altura;
        this.base=base;
    }

    public void run(){

        int baseEntera = (int) base;
        float baseDecimal = base - baseEntera;

        for(int i=0;i<baseEntera;i++){
            aux+=altura;
        }
        aux+=baseDecimal*altura;
        System.out.println("Área del "+ this.getName()+ " con "+altura+" de altura y "+base+" de base : "+aux/2);

    }
}
