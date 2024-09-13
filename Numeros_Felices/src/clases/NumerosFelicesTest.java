package clases;

import org.junit.jupiter.api.Test;

class NumerosFelicesTest {
	
	int rango = 1500000;
	
	@Test
    public void testNumFel1() {
        NumerosFelices1 numFel1 = new NumerosFelices1();

        long startTime = System.nanoTime(); 
        numFel1.recorrido(rango);
        long endTime = System.nanoTime(); 

        double durationNanos = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("El tiempo de ejecucion del recorrido 1: %.9f segundos%n", durationNanos);
    }
	
	@Test
    public void testNumFel2() {
        NumerosFelices2 numFel1 = new NumerosFelices2();

        long startTime = System.nanoTime(); 
        numFel1.recorrido(rango);
        long endTime = System.nanoTime(); 

        double durationNanos = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("El tiempo de ejecucion del recorrido 2: %.9f segundos%n", durationNanos);
    }
	
	@Test
    public void testNumFel3() {
        NumerosFelices3 numFel1 = new NumerosFelices3();

        long startTime = System.nanoTime(); 
        numFel1.recorrido(rango);
        long endTime = System.nanoTime(); 

        double durationNanos = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("El tiempo de ejecucion del recorrido 3: %.9f segundos%n", durationNanos);
    }
}