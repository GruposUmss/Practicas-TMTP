package Tests;

import Interfaces.*;
import Interfaces.Menu;
import Objects.GameSettings;
import Objects.Snake;
import Drivers.ScoreManager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.awt.*;
import javax.swing.*;

class SGTestInterfaces extends JFrame{
	
	private SnakeGame snakeGame;
	private JFrame gameFrame;
	private Snake snake;
	private ScoreManager scoreManager;
	private Menu menu = new Menu();
	
	@BeforeEach
	public void setUp() throws InterruptedException {
		this.scoreManager = new ScoreManager();
		this.gameFrame = new JFrame("Snake Game");
        this.snakeGame = new SnakeGame(this.scoreManager, GameSettings.Dificulty.EASY);
        this.gameFrame.add(snakeGame);
        this.gameFrame.pack();
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameFrame.setVisible(true);
        this.gameFrame.setLocationRelativeTo(null);
		
		Thread.sleep(400);
	}
	
	@Test
	public void testInitialization() {
	    assertNotNull(snakeGame.getGameEngine());
	    assertNotNull(snakeGame.getScoreDisplay());
	    assertNotNull(snakeGame.getLifeDisplay());
	    assertEquals(Color.black, snakeGame.getBackground());
	    assertEquals(1340, snakeGame.getWidth());
	    assertEquals(700, snakeGame.getHeight());
	}
	
	@Test
	public void testLifeDisplayVisibility() {
	    
	    snakeGame = new SnakeGame(new ScoreManager(), GameSettings.Dificulty.EASY);
	    assertTrue(snakeGame.getLifeDisplay().isVisible());

	
	    snakeGame = new SnakeGame(new ScoreManager(), GameSettings.Dificulty.HARD);
	    assertFalse(snakeGame.getLifeDisplay().getVisible());
	}
	
	@Test
	public void testGameState() {
		SnakeGame snakeGame = new SnakeGame(this.scoreManager, GameSettings.Dificulty.EASY);
	    snakeGame.getGameEngine().startGame();
	    assertTrue(snakeGame.getGameEngine().getInGame()); 
	    snakeGame.getGameEngine().endGame();
	    assertFalse(snakeGame.getGameEngine().getInGame()); 
	}
	
	@Test
	public void testSizeWindow() {
		assertEquals(1340, gameFrame.getContentPane().getWidth());
		assertEquals(700, gameFrame.getContentPane().getHeight());
	}
	
	@Test
	public void testColorWindow() {
		assertEquals(Color.black, snakeGame.getBackground());
	}
	
	@Test
	public void testDrawSnake() {
	    snake = new Snake(3);
	    assertDoesNotThrow(() -> {
	        snake.draw(gameFrame.getGraphics());
	    });
	}
	
	@Test
	public void testInitializationScoreDisplay() {
	    assertNotNull(this.snakeGame.getScoreDisplay());
	    assertEquals(0, scoreManager.getScore());
	}
	
	@Test
	public void testDrawScore() {
	    this.scoreManager.resetScore(); 
	    Graphics g = gameFrame.getGraphics(); 
	    assertDoesNotThrow(() -> this.snakeGame.getScoreDisplay().draw(g)); 
	}
	
	@Test
	public void testInitializationLifeDisplay() {
	    assertNotNull(this.snakeGame.getLifeDisplay());
	    assertTrue(this.snakeGame.getLifeDisplay().isVisible()); 
	}
	
	@Test
	public void testMenuInitialization() {
	    assertNotNull(this.menu); 
	    assertNotNull(this.menu.getEasyButton()); 
	    assertNotNull(this.menu.getHardButton()); 
	}
}
