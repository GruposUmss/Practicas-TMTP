package clases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

class NumerosFelicesTest {
	
	@Test
	public void testNumFel1_1() {
		NumerosFelices1 numFel1 = new NumerosFelices1();
		
		numFel1.recorrido(100);
	}
	
	@Test
    public void testNumFel1_2() {
        NumerosFelices1 numFel1 = new NumerosFelices1();

        long startTime = System.nanoTime(); 
        numFel1.recorrido(100);
        long endTime = System.nanoTime(); 

        double durationNanos = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("El tiempo de ejecucion del recorrido fue: %.9f segundos%n", durationNanos);
    }
	
	@Test
	public void testNumFel1_3() {
		NumerosFelices1 numFel1 = new NumerosFelices1();
		
		assertTimeout(Duration.ofSeconds(5), () -> {
            numFel1.recorrido(100);
        });
	}
}