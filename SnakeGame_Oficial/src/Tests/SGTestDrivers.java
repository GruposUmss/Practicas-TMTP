package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;

import Interfaces.Menu;
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
    
    /* CollisionManager
     * Test para verificar la colision entre los limites y la serpiente(mundo toloidal)
     */
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

    /* CollisionManager
     * Test para verificar la colision entre la cabeza y su cuerpo
     */
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

    /* CollisionManager
     * Test para verificar la colision entre la serpiente y alguna entidad(apple, orange, black hole)
     */
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
    
    /* GameEngine
     * Test para verificar que el motor de juego se ejecute
     */
    @Test
    public void testGameInitialization() {
    	this.snakeGame.initGameValid();
        assertTrue(this.snakeGame.getGameEngine().getInGame()); 
        assertEquals(0, this.snakeGame.getGameEngine().getEntityList().size()); 
        assertEquals(0, this.snakeGame.getGameEngine().getScoreManager().getScore()); 
    }
    
    /* GameEngine
     * Test para verificar que se añadan manzanas a la lista del motor de juego
     */
    @Test
    public void testAddEntityApple() {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().addEntityApple(); 
        assertEquals(1, this.snakeGame.getGameEngine().getEntityList().size()); 
        assertTrue(this.snakeGame.getGameEngine().getEntityList().get(0) instanceof Apple); 
    }
    
    /* GameEngine
     * Test para verificar que añadan naranjas a la lista del motor de juego
     */
    @Test
    public void testAddEntityOrange() {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().addEntityOrange(); 
        assertEquals(1, this.snakeGame.getGameEngine().getEntityList().size()); 
        assertTrue(this.snakeGame.getGameEngine().getEntityList().get(0) instanceof Orange); 
    }
    
    /* GameEngine
     * Test para verificar que se añadan agujeros negros a la lista del motor de juego
     */
    @Test
    public void testAddEntityBlackHole() {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().addEntityBlackHole(); 
        assertEquals(1, this.snakeGame.getGameEngine().getEntityList().size()); 
        assertTrue(this.snakeGame.getGameEngine().getEntityList().get(0) instanceof BlackHole); 
    }
    
    /* GameEngine
     * Test para verificar que se remuevan entidades de la lista del motor de juego
     */
    @Test
    public void testRemoveEntityApple() {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().addEntityApple(); 
        assertEquals(1, this.snakeGame.getGameEngine().getEntityList().size()); 
        this.snakeGame.getGameEngine().removeEntityApple(); 
        assertEquals(0, this.snakeGame.getGameEngine().getEntityList().size()); 
    }
    
    /* GameEngine
     * Test para verificar que el estado visible de la serpiente se alterne al entrar en blink
     */
    @Test
    public void testBlinkSnake() throws InterruptedException {
    	this.snakeGame.initGameValid();
        this.snakeGame.getGameEngine().getSnake().setVisible(true); 
        this.snakeGame.getGameEngine().getSnake().blinkSnake();

        assertFalse(this.snakeGame.getGameEngine().getSnake().getVisible()); 
        Thread.sleep(8000);
        assertTrue(this.snakeGame.getGameEngine().getSnake().getVisible());
    }
    
    /* LevelManager
     * Test para comprobar que si se esten ejecutando los niveles
     */
    @Test
    public void testExecuteLevel () {
    	this.snakeGame.getGameEngine().getLevelManager().reviewLevels(0);
    	assertEquals(GameSettings.Levels.ONE, this.snakeGame.getGameEngine().getLevelManager().getLevelActual());
    	
    	this.snakeGame.getGameEngine().getLevelManager().reviewLevels(500);
    	assertEquals(GameSettings.Levels.TWO, this.snakeGame.getGameEngine().getLevelManager().getLevelActual());
    }
    
    /* LifeManager
     * Test para comprobar que el juego termine, cuando las vidas esten desactivadas
     */
    @Test
    public void testLoseLifes () {
    	this.snakeGame.getGameEngine().getLifeManager().setVisible(false);
    	assertEquals(0, this.snakeGame.getGameEngine().getLifeManager().getLives());
    }
    
    /* PositionManager
     * Test para confirmar que el verificador de posiciones dar true cuando hay una
     * sobreposicion
     */
    @Test
    public void testOverlayPositions() {
    	this.snakeGame.getGameEngine().getPositionManager().addPosition(10, 10, 20);
    	assertTrue(this.snakeGame.getGameEngine().getPositionManager().overlay(10, 10, 20));
    }
    
    /* ScoreManager
     * Test para verificar que el incremente del High Score sea independiente
     */
    @Test
    public void testScoreHardAndEasy () {
    	SnakeGame sg1 = new SnakeGame(this.scoreManager, GameSettings.Dificulty.HARD);
    	sg1.getGameEngine().getScoreManager().increaseScore(100);
    	
    	SnakeGame sg2 = new SnakeGame(this.scoreManager, GameSettings.Dificulty.EASY);
    	sg2.getGameEngine().getScoreManager().increaseScore(300);
    	
    	assertNotEquals(sg1.getGameEngine().getScoreManager().getHighScoreEasy(),
    					sg2.getGameEngine().getScoreManager().getHighScoreHard());
    }
    
    /* AudioPlayer 
	 * Test para verificar que la musica del juego se obtenga y
	 * pueda ejecutarse debidamente
	 */
	@Test
	public void testInitMusicGame() {
		Menu menu = new Menu();
		menu.getAudioPlayer().playLoop();
		assertTrue(menu.getAudioPlayer().getClip().isRunning());
	}
}
