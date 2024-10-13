package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import javax.swing.JFrame;
import Interfaces.SnakeGame;
import Drivers.*;
import Objects.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SGTestDrivers {
    
    private SnakeGame game;
    private JFrame frame;
    private CollisionsManager collisionManager;
    private GameEngine gameEngine;
    private Snake snake;

    @BeforeEach
    public void setUp() throws InterruptedException{
    	
    	frame = new JFrame();
		game = new SnakeGame();
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		gameEngine = game.getGameEngine();
		snake = gameEngine.getSnake();
		collisionManager = gameEngine.getCollisionsManager();
		
		Thread.sleep(8000);
    }

    @Test
    @Order(1)
    public void testSnakeCollisionWithLimits() {
        collisionManager.checkCollisionLimits();
        assertFalse(gameEngine.getInGame());
    }
    
    @Test
    @Order(2)
    public void testSnakeCollisionWithBody() {
        collisionManager.checkCollisionBody();
        assertFalse(gameEngine.getInGame());
    }
    
    @Test
    @Order(3)
    public void testAppleCollisionWithSnake() throws InterruptedException{
    	int initial = snake.getSnakeSize();
    	Thread.sleep(8000);
        collisionManager.checkCollisionApple();
        assertTrue(initial != snake.getSnakeSize());
    }
    
    @Test
    @Order(4)
    public void testOrangeCollisionWithSnake() throws InterruptedException{
    	int initial = snake.getSnakeSize();
    	Thread.sleep(8000);
        collisionManager.checkCollisionOrange();
        assertTrue(initial != snake.getSnakeSize());
    }
    
    @Test
    @Order(5)
    public void testBlackHoleCollisionWithSnake() throws InterruptedException{
        collisionManager.checkCollisionBlackHole();
        assertFalse(gameEngine.getInGame());
    }
}