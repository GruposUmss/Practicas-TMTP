package Tests;

import Interfaces.SnakeGame;
import Objects.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.awt.*;
import javax.swing.*;

class SnakeGameTest{
	
	private SnakeGame game;
	private JFrame frame;
	private Apple apple;
	private Snake snake;
	
	@BeforeEach
	public void setUp() throws InterruptedException {
		frame = new JFrame();
		game = new SnakeGame();
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Thread.sleep(3000);

	}
	
	//Tests de visualizacion de la ventana del juego
	@Test
	public void testSizeWindow() {
		assertEquals(1360, frame.getContentPane().getWidth());
		assertEquals(700, frame.getContentPane().getHeight());
	}
	
	@Test
	public void testColorWindow() {
		assertEquals(Color.black, game.getBackground());
	}
	
	
	//Tests de verificacion de alteatoriedad de la manzana
	@Test
	public void testAppleLimits() {
		apple = new Apple(frame.getContentPane().getWidth(), frame.getContentPane().getHeight(), game.posMan()); 
		int appleX = apple.getX();
        int appleY = apple.getY();
        
        assertTrue(appleY > 0 && appleY <= (frame.getContentPane().getHeight()) - 20);
        assertTrue(appleX > 0 && appleX <= (frame.getContentPane().getWidth()) - 20);
	}
	
	@Test
	public void testAppleRandom() {
		apple = new Apple(frame.getContentPane().getWidth(), frame.getContentPane().getHeight(), game.posMan()); 
		assertNotNull(apple.getX());
		assertNotNull(apple.getY());
	}
	
	
	//Tests para probar la visualizacion de la serpiente
	@Test
	public void testSnakeInitial() {
		snake = new Snake(5);
		assertEquals(5, snake.getSnakeSize());
	}
}
