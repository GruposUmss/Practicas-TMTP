package clases;

import java.util.HashSet;
import java.util.Set;

public class NumerosFelices2 {
    
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
    
    public void recorrido() {
    	int num = 1;
    	while(num < 100) {
    		esFeliz(num);
    		num++;
    	}
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
