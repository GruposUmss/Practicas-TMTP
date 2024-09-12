package clases;

import java.util.HashSet;
import java.util.Set;

public class NumerosFelices3 {

    public boolean esFeliz(int numero) {
        return esFelizRecursivo(numero, new HashSet<>());
    }

    private boolean esFelizRecursivo(int numero, Set<Integer> visitados) {
        if (numero == 1) {
            return true;
        }
        if (!visitados.add(numero)) {
            return false;
        }
        int siguienteNumero = sumaDeCuadradosDeDigitos(numero);
        return esFelizRecursivo(siguienteNumero, visitados);
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

    public void recorrido(int rango) {
        for (int num = 1; num <= rango; num++) {
            if (esFeliz(num)) {
                System.out.println(num + " es un número feliz.");
            } else {
                System.out.println(num + " no es un número feliz.");
            }
        }
    }

    public static void main(String[] args) {
        
    	_NumerosFelices3 numerosFelices = new NumerosFelices3()
        numerosFelices.recorrido(100);
    }
    
    
}

