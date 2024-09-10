package clases;

import java.util.HashSet;
import java.util.Set;

public class NumerosFelices2 {
    public static void main(String[] args) {
        NumerosFelices2 prueba1 = new NumerosFelices2();
        System.out.println(prueba1.esFeliz(22)); // Ejemplo de uso
        prueba1.sacarTiempo(); // Medir el tiempo para un rango de números
    }
    
    public boolean esFeliz(int numero) {
        Set<Integer> vistos = new HashSet<>();
        while (numero != 1 && !vistos.contains(numero)) {
            vistos.add(numero);
            numero = sumaDeCuadradosDeDigitos(numero);
        }
        return numero == 1;
    }
    
    private int sumaDeCuadradosDeDigitos(int numero) {
        int suma = 0;
        while (numero > 0) {
            int digito = numero % 10;
            suma += digito * digito;
            numero /= 10;
        }
        return suma;
    }

    /*
    public void sacarTiempo() {
        int min = 1;
        int max = 500000;
        long inicio = System.nanoTime();
        for (int x = min; x <= max; x++) {
            esFeliz(x);
        }
        long fin = System.nanoTime();
        long tiempoTotal = fin - inicio;
        System.out.println("Tiempo total: " + tiempoTotal + " nanosegundos");
    }
    */
}
