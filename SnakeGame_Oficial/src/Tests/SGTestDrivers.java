package Tests;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test; 
import Interfaces.SnakeGame;
import Objects.*;
import Drivers.*;

public class SGTestDrivers {

    private SnakeGame snakeGame;
    private CollisionsManager collisionsManager;
    private ScoreManager scoreManager;
    private PositionManager positionManager = new PositionManager();

    @BeforeEach 
    public void setUp() {
        this.scoreManager = new ScoreManager();
        this.snakeGame = new SnakeGame(this.scoreManager, GameSettings.Dificulty.HARD); 
        collisionsManager = new CollisionsManager(this.snakeGame, this.snakeGame.getGameEngine());
    }

    @Test
    public void testCheckCollisionLimits() {
        this.snakeGame.getGameEngine().getSnake().setSnakePosX(0); 
        this.snakeGame.getGameEngine().getSnake().setDirection(GameSettings.Directions.LEFT);
        this.snakeGame.getGameEngine().getSnake().move();
        collisionsManager.checkCollisionLimits();
        assertEquals(this.snakeGame.getWidth() - snakeGame.getGameEngine().getSnake().getSnakeRectSize(), 
        			this.snakeGame.getGameEngine().getSnake().getSnakePosX(0));

        this.snakeGame.getGameEngine().getSnake().setSnakePosX(this.snakeGame.getWidth()); 
        collisionsManager.checkCollisionLimits();
        assertEquals(0, this.snakeGame.getGameEngine().getSnake().getSnakePosX(0)); 
    }

    @Test
    public void testCheckCollisionBody() {
    	this.snakeGame.getGameEngine().getSnake().setSnakeSize(3);
    	this.snakeGame.getGameEngine().getSnake().setSnakePosX(50);
    	this.snakeGame.getGameEngine().getSnake().setSnakePosY(50);
    	this.snakeGame.getGameEngine().getSnake().move();
   
    	this.snakeGame.getGameEngine().getSnake().setSnakePosX(50); 
    	this.snakeGame.getGameEngine().getSnake().setSnakePosY(50);
        collisionsManager.checkCollisionBody();

        assertFalse(this.snakeGame.getGameEngine().getInGame()); 
    }

    @Test
    public void testCheckCollisionEntity() {
    	this.snakeGame.setVisible(false);
    	this.snakeGame.initGameValid();
    	Apple apple = new Apple(this.snakeGame.getWidth(), this.snakeGame.getHeight(), this.positionManager);
        this.snakeGame.getGameEngine().getEntityList().add(apple);
        this.snakeGame.getGameEngine().getSnake().setSnakePosX(apple.getX());
        this.snakeGame.getGameEngine().getSnake().setSnakePosY(apple.getY());
        
        collisionsManager.checkCollisionEntity();

        assertTrue(apple.getVisible()); 
        assertEquals(6, this.snakeGame.getGameEngine().getSnake().getSnakeSize());
        assertEquals(100, this.snakeGame.getGameEngine().getScoreManager().getScore()); 
    }
    
    @Test
    public void testGameInitialization() {
    	this.snakeGame.initGameValid();
        assertTrue(this.snakeGame.getGameEngine().getInGame()); 
        assertEquals(0, this.snakeGame.getGameEngine().getEntityList().size()); 
        assertEquals(0, this.snakeGame.getGameEngine().getScoreManager().getScore()); 
    }
    
    @Test
    public void testAddEntityApple() {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().addEntityApple(); 
        assertEquals(1, this.snakeGame.getGameEngine().getEntityList().size()); 
        assertTrue(this.snakeGame.getGameEngine().getEntityList().get(0) instanceof Apple); 
    }
    
    @Test
    public void testAddEntityOrange() {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().addEntityOrange(); 
        assertEquals(1, this.snakeGame.getGameEngine().getEntityList().size()); 
        assertTrue(this.snakeGame.getGameEngine().getEntityList().get(0) instanceof Orange); 
    }
    
    @Test
    public void testAddEntityBlackHole() {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().addEntityBlackHole(); 
        assertEquals(1, this.snakeGame.getGameEngine().getEntityList().size()); 
        assertTrue(this.snakeGame.getGameEngine().getEntityList().get(0) instanceof BlackHole); 
    }
    
    @Test
    public void testRemoveEntityApple() {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().addEntityApple(); 
        assertEquals(1, this.snakeGame.getGameEngine().getEntityList().size()); 
        this.snakeGame.getGameEngine().removeEntityApple(); 
        assertEquals(0, this.snakeGame.getGameEngine().getEntityList().size()); 
    }
    
    @Test
    public void testBlinkSnake() throws InterruptedException {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().getSnake().setVisible(true); 
        this.snakeGame.getGameEngine().getSnake().blinkSnake();

        assertFalse(this.snakeGame.getGameEngine().getSnake().getVisible()); 
        Thread.sleep(8000);
        assertTrue(this.snakeGame.getGameEngine().getSnake().getVisible());
    }
}
