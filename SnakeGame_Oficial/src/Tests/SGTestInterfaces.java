package Tests;

import java.awt.*;                   
import javax.swing.*;                 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Interfaces.*;
import Interfaces.Menu;
import Objects.*;
import Drivers.*;

class SGTestInterfaces extends JFrame{
	
	private SnakeGame snakeGame;
	private JFrame gameFrame;
	private Snake snake;
	private ScoreManager scoreManager;
	
	@BeforeEach
	public void setUp() {
		this.scoreManager = new ScoreManager();
		this.gameFrame = new JFrame("Snake Game");
        this.snakeGame = new SnakeGame(this.scoreManager, GameSettings.Dificulty.EASY);
        this.gameFrame.add(snakeGame);
        this.gameFrame.pack();
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.gameFrame.setLocationRelativeTo(null);
	}
	
	/* SnakeGame
	 * Test para verificar que se esten creando todos los componentes que 
	 * tendra SnakeGame
	 */
	@Test
	public void testInitialization() {
	    assertNotNull(snakeGame.getGameEngine());
	    assertNotNull(snakeGame.getScoreDisplay());
	    assertNotNull(snakeGame.getLifeDisplay());
	    assertNotNull(snakeGame.getLevelDisplay());
	    assertNotNull(snakeGame.getMotionSnake());
	    assertEquals(1340, snakeGame.getWidth());
	    assertEquals(700, snakeGame.getHeight());
	}
	
	/* SnakeGame
	 * Test para verificar que al iniciar el juego, el timer tambien se active
	 */
	@Test
	public void testGameValidation () {
		this.snakeGame.initGameValid();
		assertTrue(this.snakeGame.getGameEngine().getTimer() != null);
	}
	
	/* SnakeGame
	 * Test para verificar si al terminar el juego, el estado de InGame se 
	 * vuelve False
	 */
	@Test
	public void testGameState() {
		SnakeGame snakeGame = new SnakeGame(this.scoreManager, GameSettings.Dificulty.EASY);
	    snakeGame.getGameEngine().startGame();
	    assertTrue(snakeGame.getGameEngine().getInGame()); 
	    snakeGame.getGameEngine().endGame();
	    assertFalse(snakeGame.getGameEngine().getInGame()); 
	}
	
	/* LifeDisplay
	 * Test para verificar la visibilidad de las vidas en el juego
	 * en base a la dificultad actual
	 */
	@Test
	public void testLifeDisplayVisibility() {
	    snakeGame = new SnakeGame(new ScoreManager(), GameSettings.Dificulty.EASY);
	    assertTrue(snakeGame.getLifeDisplay().isVisible());

	    snakeGame = new SnakeGame(new ScoreManager(), GameSettings.Dificulty.HARD);
	    assertFalse(snakeGame.getLifeDisplay().getVisible());
	}
	
	/* LifeDisplay
	 * Test para verificar que las vida se inicializen correctamente
	 * en el juego
	 */
	@Test
	public void testInitializationLifeDisplay() {
	    assertNotNull(this.snakeGame.getLifeDisplay());
	    assertTrue(this.snakeGame.getLifeDisplay().isVisible()); 
	}
	
	/* Menu
	 * Test para verificar el tamaño de la ventana del menu
	 */
	@Test
	public void testSizeWindow() {
		assertEquals(1340, gameFrame.getContentPane().getWidth());
		assertEquals(700, gameFrame.getContentPane().getHeight());
	}
	
	/* ScoreDisplay
	 * Test para validar la existencia del score en el juego
	 */
	@Test
	public void testDrawScore() {
	    this.scoreManager.resetScore(); 
	    Graphics g = gameFrame.getGraphics(); 
	    assertDoesNotThrow(() -> this.snakeGame.getScoreDisplay().draw(g)); 
	}
	
	/* ButtonPanel
	 * Test para verificar que los tres botones del panel se ejecuten y tengan
	 * las dimenciones esperadas
	 */
	@Test 
	public void testButtonsInitialization () {
		ButtonPanel buttonPanel = new ButtonPanel(this.scoreManager, new Menu());
		
		assertNotNull(buttonPanel.getEasyButton());
        assertEquals(new Rectangle(150, 150, 250, 90), buttonPanel.getEasyButton().getBounds());
        
		assertNotNull(buttonPanel.getHardButton());
        assertEquals(new Rectangle(950, 150, 250, 90), buttonPanel.getHardButton().getBounds());
        
		assertNotNull(buttonPanel.getPlayButton());
        assertEquals(new Rectangle(555, 520, 250, 90), buttonPanel.getPlayButton().getBounds());
	}
	
	/* TitlePanel
	 * Test para verificar que los titulos se generen en la ventana inicial
	 */
	@Test
	public void testTitleComponents () {
		TitlePanel titleComponents = new TitlePanel ();
		
		assertNotNull(titleComponents.getSnakeLabel());
		assertNotNull(titleComponents.getGameLabel());
		assertNotNull(titleComponents.getGalacticLabel());
		assertNotNull(titleComponents.getPressKeyLabel());
	}
	
	/* LevelDisplay
	 * Test para varificar que el mostrador de nivelesse ejecute al momento de crearlo
	 */
	@Test
	public void testLevelDisplayInitialization () {
		LevelDisplay levelDisplay = this.snakeGame.getLevelDisplay();
		assertTrue(levelDisplay.getPixelFont() != null);
	}
	
	/* Snake(Test de Interfaz)
	 * Test para verificar que la serpiente se este graficando en SnakeGame
	 */
	@Test
	public void testDrawSnake() {
	    snake = new Snake(3);
	    assertDoesNotThrow(() -> {
	        snake.draw(gameFrame.getGraphics());
	    });
	}
}
