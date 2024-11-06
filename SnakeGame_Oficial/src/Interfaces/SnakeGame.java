package Interfaces;

import Drivers.*;
import Objects.Entity;
import Objects.GameSettings;
import javax.swing.*;
import java.awt.*;

/**
 * La clase SnakeGame representa el juego de Snake. Es el panel principal donde se dibujan 
 * los elementos del juego, como el puntaje, las vidas y la serpiente. 
 */
public class SnakeGame extends JPanel{
	
    //Dimension de la ventana del juego
    private final int WIDTH = 1340; 
    private final int HEIGHT = 700;
    
    private LifeDisplay lifeDisplay;
    private ScoreDisplay scoreDisplay;
    private LevelDisplay levelDisplay;// se agrego estoooooooooooooooooooooo
    private GameEngine gameEngine;
    private GameSettings.Dificulty dificulty;
    private boolean visible = true;
    
    public SnakeGame(ScoreManager scoreManager, GameSettings.Dificulty dificulty) {
    	initBoard(scoreManager,  dificulty);
    	this.dificulty = dificulty;
    }
   
    private void initBoard(ScoreManager scoreManager, GameSettings.Dificulty dificulty) {
    	setBackground(Color.black); //Establece el fondo del panel
        setPreferredSize(new Dimension(getWidth(), getHeight())); // stablece el tamaño preferido
        setFocusable(true); //Permite que el panel reciba eventos de teclado
        requestFocusInWindow(); //Solicita el foco para el panel

        //Inicializa los componentes del juego(Motor de Juego y Displays)
        this.gameEngine = new GameEngine(this, scoreManager);
        this.scoreDisplay = new ScoreDisplay(scoreManager);
        this.lifeDisplay = new LifeDisplay(gameEngine.getLifeManager());
        this.levelDisplay = new LevelDisplay(gameEngine.getLevelManager()); // se agrego estoooooooooooooooooooooo
        
        //Establece la visibilidad de las vidas según la dificultad
        if (dificulty != GameSettings.Dificulty.EASY) {
            this.lifeDisplay.setVisible(false);
        }

        //Agrega un listener para los movimientos de la serpiente
        addKeyListener(new MotionSnake(gameEngine.getSnake()));
    }
    
    public void initGameValid () {
    	if (this.visible) gameEngine.startGame(); 
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g) {
    	gameEngine.getSnake().draw(g); 
        scoreDisplay.draw(g);
        lifeDisplay.draw(g);
        levelDisplay.draw(g); // se agregoooooooooooooooo
        
        for (Entity entity: gameEngine.getEntityList()) {
        	entity.draw(g);
        }
    }
    
    //Metodo Getters y Setters de la clase---------
    public GameEngine getGameEngine() {
    	return this.gameEngine;
    }
    
    public ScoreDisplay getScoreDisplay () {
    	return this.scoreDisplay;
    }
    
    public LifeDisplay getLifeDisplay () {
    	return this.lifeDisplay;
    }
    
    public GameSettings.Dificulty getDificulty () {
    	return this.dificulty;
    }
    
    public int getWidth() {
    	return this.WIDTH;
    }
    
    public int getHeight() {
    	return this.HEIGHT;
    }
    
    public void setVisible (boolean visible) {
    	this.visible = visible;
    }
}