package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Objects.*;
import Drivers.*;
import Interfaces.SnakeGame;

class SGTestObjects  {

	private int WIDTH;
	private int HEIGHT;
	private SnakeGame snakeGame;
    private ScoreManager scoreManager;
    private GameEngine gameEngine;

    @BeforeEach 
    public void setUp() {
    	this.scoreManager = new ScoreManager();
        this.snakeGame = new SnakeGame(this.scoreManager, GameSettings.Dificulty.HARD);
        this.gameEngine = new GameEngine(this.snakeGame, this.scoreManager);
    	this.WIDTH = this.gameEngine.getSnakeGame().getWidth();
        this.HEIGHT = this.gameEngine.getSnakeGame().getHeight();
    }
    
    /* Snake
	 * Test para verificar que el Registrador de direcciones agrege 
	 * cualquier posicion en orden al mover la serpiente
	 */
	@Test
	public void testSnakeSegmentDirectionAfterMove() {
	    this.gameEngine.getSnake().setDirection(GameSettings.Directions.UP);
	    this.gameEngine.getSnake().move();
	    assertEquals(GameSettings.Directions.UP, this.gameEngine.getSnake().getRegisterDirection(0));
	    this.gameEngine.getSnake().move();
	    assertEquals(GameSettings.Directions.UP, this.gameEngine.getSnake().getRegisterDirection(1));  
	}
    
	/* Snake
	 * Test para verificar que la serpiente se inicie en el tamaño especificado
	 */
	@Test
	public void testSnakeInitial() {
		assertEquals(5, this.gameEngine.getSnake().getSnakeSize());
	}
	
	/* Snake
	 * Test para validar que la posicion de la serpiente cambie hacia la IZQUIERDA
	 */
	@Test
	public void testSnakeValidateSides() {
	    this.gameEngine.getSnake().setDirection(GameSettings.Directions.RIGHT);
	    this.gameEngine.getSnake().move();
	    assertEquals(80, this.gameEngine.getSnake().getSnakePosX(0));
	}
	
	/* Snake 
	 * Test para validar que la posicion de la serpiente cambie hacia ABAJO
	 */
	@Test
	public void testSnakeValidateUpDown() {
	    this.gameEngine.getSnake().setDirection(GameSettings.Directions.DOWN);
	    this.gameEngine.getSnake().move();
	    assertEquals(80, this.gameEngine.getSnake().getSnakePosY(0));
	}
	
	/* Snake
	 * Test para validar que la serpiente se pueda mover en las cuatro direcciones
	 * cardinales
	 */
	
	@Test
	public void testMovingAllDirections() {
		this.gameEngine.getSnake().setDirection(GameSettings.Directions.RIGHT);
		assertTrue(this.gameEngine.getSnake().movingRight());
		
		this.gameEngine.getSnake().setDirection(GameSettings.Directions.LEFT);
		assertTrue(this.gameEngine.getSnake().movingLeft());
		
		this.gameEngine.getSnake().setDirection(GameSettings.Directions.UP);
		assertTrue(this.gameEngine.getSnake().movingUp());
		
		this.gameEngine.getSnake().setDirection(GameSettings.Directions.DOWN);
		assertTrue(this.gameEngine.getSnake().movingDown());
	}
	
	/* Snake
	 * Test para verificar que el tamaño de la serpiente cambie correctamente
	 */
	@Test
	public void testSnakeIncrement() {
		this.gameEngine.getSnake().setSnakeSize(this.gameEngine.getSnake().getSnakeSize() + 1);
		assertEquals(6, this.gameEngine.getSnake().getSnakeSize());
	}
	
	/* Snake
	 * Test para validar que las imagenes de la Cabeza se cargen 
	 * correctamente
	 */
	@Test
	public void testHeadImage() {
	    assertNotNull(this.gameEngine.getSnake().getHeadImage(GameSettings.Directions.RIGHT));
	    assertNotNull(this.gameEngine.getSnake().getHeadImage(GameSettings.Directions.LEFT));
	    assertNotNull(this.gameEngine.getSnake().getHeadImage(GameSettings.Directions.UP));
	    assertNotNull(this.gameEngine.getSnake().getHeadImage(GameSettings.Directions.DOWN));
	}
	
	/* Snake
	 * Test para validar que las imagenes del Cuerpo se cargen 
	 * correctamente
	 */
	@Test
	public void testBodyImage() {
	    assertNotNull(this.gameEngine.getSnake().getBodyImage(GameSettings.Directions.RIGHT));
	    assertNotNull(this.gameEngine.getSnake().getBodyImage(GameSettings.Directions.LEFT));
	    assertNotNull(this.gameEngine.getSnake().getBodyImage(GameSettings.Directions.UP));
	    assertNotNull(this.gameEngine.getSnake().getBodyImage(GameSettings.Directions.DOWN));
	}
	
	/* Apple
	 * Test para verificar que la posicion de la manzana no sobrepase los
	 * limites de la ventana del juego
	 */
	@Test
	public void testAppleLimits() {
		this.gameEngine.addEntityApple();
		Apple apple = (Apple)this.gameEngine.getEntityList().get(0);
		assertTrue((apple.getX() >= 0) && (apple.getX() <= (this.WIDTH - apple.getSize())));
		assertTrue((apple.getY() >= 0) && (apple.getY() <= (this.HEIGHT - apple.getSize())));
	}
	
	/* Orange
	 * Test para verficar que la posicion de la naranja no sobrepase los
	 * limites de la ventana del juego 
	 */
	@Test
	public void testOrangeLimits() {
		this.gameEngine.addEntityOrange();
		Orange orange = (Orange)this.gameEngine.getEntityList().get(0);
		assertTrue((orange.getX() > 0) && (orange.getX() <= (this.WIDTH - orange.getSize())));
		assertTrue((orange.getY() > 0) && (orange.getY() <= (this.HEIGHT - orange.getSize())));
	}
	
	/* Orange
	 * Test para verificar que el action listener de la naranja, 
	 * modifique el estado de la naranja
	 */
	@Test
    public void testAOrangectionPerformed() {
		this.gameEngine.addEntityOrange();
		Orange orange = (Orange)this.gameEngine.getEntityList().get(0);
        boolean initialVisibility =  orange.getVisible();
        orange.actionPerformed(null);  
        assertNotEquals(initialVisibility, orange.getVisible());
    }
	
	/* BlackHole
	 * Test para verficar que la posicion del agujero negro no sobrepase los
	 * limites de la ventana del juego
	 */
	@Test
	public void testBlackHoleLimits() {
		this.gameEngine.addEntityBlackHole();
		BlackHole blackHole = (BlackHole)this.gameEngine.getEntityList().get(0);
		assertTrue((blackHole.getX() >= 0) && (blackHole.getX() <= (this.WIDTH - blackHole.getSize())));
		assertTrue((blackHole.getY() >= 0) && (blackHole.getY() <= (this.HEIGHT - blackHole.getSize())));
	}
	
	/* BlackHole
	 * Test para verificar que el action listener del agujero negro, 
	 * modifique el estado actual del agujero negro
	 */
	@Test
    public void testBlackHoleActionPerformed() {
		this.gameEngine.addEntityBlackHole();
		BlackHole blackHole = (BlackHole)this.gameEngine.getEntityList().get(0);
		boolean initialVisibility =  blackHole.getVisible();
        blackHole.actionPerformed(null);  
        assertNotEquals(initialVisibility, blackHole.getVisible());
    }
}
