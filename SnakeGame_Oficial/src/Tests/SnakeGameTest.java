package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Interfaces.SnakeGame;

import org.junit.jupiter.api.BeforeEach;
import java.awt.*;
import javax.swing.*;

class SnakeGameTest {
	
	private SnakeGame game;
	private JFrame frame;
	
	@BeforeEach
	public void setUp() {
		frame = new JFrame();
		game = new SnakeGame();
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	
	//Tests de visualizacion de la ventana del juego
	@Test
	public void testSizeWindow() {
		assertEquals(900, frame.getContentPane().getWidth());
		assertEquals(600, frame.getContentPane().getHeight());
	}
	
	@Test
	public void testColorWindow() {
		assertEquals(Color.white, game.getBackground());
	}
	
	
	//Tests de verificacion de alteatoriedad de la manzana
	@Test
	public void testAppleLimits() {
		int appleX = game.getAppleX();
        int appleY = game.getAppleY();
        
        assertTrue(appleY > 0 && appleY <= (frame.getContentPane().getHeight()) - 20);
        assertTrue(appleX > 0 && appleX <= (frame.getContentPane().getWidth()) - 20);
	}
	
	@Test
	public void testAppleRandom() {
		assertNotNull(game.getAppleX());
		assertNotNull(game.getAppleY());
	}
	
	
	//Tests para probar la visualizacion de la serpiente
	@Test
	public void testSnakeInitial() {
		assertEquals(5, game.getInitialSnakeSize());
	}
}
