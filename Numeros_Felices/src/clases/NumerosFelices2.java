package clases;
/**
 * Write a description of class Implementacion1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumerosFelices2
{
    public boolean esFeliz(int numero){
        int suma = 0;
        while(numero > 0){
            int aux = numero%10;
            suma += aux*aux;
            numero /= 10;
        }
        if(suma == 1){
            return true;
        }else if ((suma == 4 || suma == 0) || numero < 0){
            return false;
        }else{
            return esFeliz(suma);
        }
    }

    public void sacarTiempo(){
        int min = 1;
        int max = 500000;
        long inicio = System.nanoTime();
        for (int x = min; x <= max; x++) {
            esFeliz(x);
        }
        long fin = System.nanoTime();
        long tiempoTotal = fin - inicio;
        System.out.println(tiempoTotal);
    }
}
