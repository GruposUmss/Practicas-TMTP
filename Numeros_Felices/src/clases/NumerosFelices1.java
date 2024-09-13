package clases;

import java.util.ArrayList;
import java.util.List;

public class NumerosFelices1 {

	public boolean esFeliz(int numero) {
        List<Integer> visitados = new ArrayList<>();
        while (numero != 1 && !visitados.contains(numero)) {
        	visitados.add(numero);
            numero = sumaDeCuadrados(numero);
        }
        return numero == 1;
    }
    
    private int sumaDeCuadrados(int numero) {
        int suma = 0;
        while (numero > 0) {
            int digito = numero % 10;
            suma += Math.pow(digito, 2);
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