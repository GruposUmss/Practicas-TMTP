package clases;

import java.util.ArrayList;
import java.util.List;

public class NumerosFelices1 {

	public boolean esFeliz(int numero) {
        List<Integer> lista = new ArrayList<>();
        while (numero != 1 && !lista.contains(numero)) {
            lista.add(numero);
            numero = sumaDeCuadradosDeDigitos(numero);
        }
        return numero == 1;
    }
    
    private int sumaDeCuadradosDeDigitos(int numero) {
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