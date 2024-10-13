package Tests;

import Interfaces.SnakeGame;
import Objects.Snake;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.awt.*;
import javax.swing.*;

class SGTestInterfaces{
	
	private SnakeGame game;
	private JFrame frame;
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
		
		Thread.sleep(800);
	}
	
	@Test
	public void testSizeWindow() {
		assertEquals(1360, frame.getContentPane().getWidth());
		assertEquals(700, frame.getContentPane().getHeight());
	}
	
	@Test
	public void testColorWindow() {
		assertEquals(Color.black, game.getBackground());
	}
	
	@Test
	public void testDrawSnake() {
	    snake = new Snake(3);
	    assertDoesNotThrow(() -> {
	        snake.draw(frame.getGraphics());
	    });
	}
}
