package clases;

import java.util.HashSet;
import java.util.Set;

public class NumerosFelices2 {
    
    public boolean esFeliz(int numero) {
        Set<Integer> vistos = new HashSet<>();
        while (numero != 1 && !vistos.contains(numero)) {
            vistos.add(numero);
            numero = sumaDeCuadrados(numero);
        }
        return numero == 1;
    }
    
    private int sumaDeCuadrados(int numero) {
        int suma = 0;
        while (numero > 0) {
            int digito = numero % 10;
            suma += digito * digito;
            numero /= 10;
        }
        return suma;
    }
    
    public void recorrido(int rango) {
    	int num = 1;
    	while(num <= rango) {
    		esFeliz(num);
    		num++;
    	}
    }
}