package Interfaces;

import Drivers.*;
import Objects.GameSettings;
import javax.swing.*;
import java.awt.*;

//Clase principal que representa el juego Snake
public class SnakeGame extends JPanel{
	
    //Dimension de la ventana en X y Y
    private final int WIDTH = 1360; 
    private final int HEIGHT = 700;
    
    private LifeDisplay lifeDisplay;
    private ScoreDisplay scoreDisplay;
    private GameEngine gameEngine;
    
    public SnakeGame(ScoreManager sm, GameSettings.Dificulty dificulty) {
    	initBoard(sm,  dificulty);
    }
    
    public GameEngine getGameEngine() {
    	return this.gameEngine;
    }
    
    public int getWidth() {
    	return this.WIDTH;
    }
    
    public int getHeight() {
    	return this.HEIGHT;
    }
    
    private void initBoard(ScoreManager scoreManager, GameSettings.Dificulty dificulty) {
        setBackground(Color.black);
        setFocusable(true);
        requestFocusInWindow();
        
        this.gameEngine = new GameEngine(this, scoreManager);
        
        this.scoreDisplay = new ScoreDisplay(scoreManager);
        this.lifeDisplay = new LifeDisplay(gameEngine.getLifeManager());
        if (dificulty != GameSettings.Dificulty.EASY) {
        	this.lifeDisplay.setVisible(false);
        }
        gameEngine.startGame();
        
        addKeyListener(new MotionSnake(gameEngine.getSnake())); //Define el listado de llaves para el taclado
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g) {
        gameEngine.getSnake().draw(g); //Dibuja la manzana
        gameEngine.getApple().draw(g); //Dibuja la serpiente
        gameEngine.getOrange().draw(g); //Dibuja naranja
        gameEngine.getBlackHole().draw(g); //Dibuja agujero negro
        scoreDisplay.draw(g); //Dibuja el score
        lifeDisplay.draw(g); //Dibuja las vidas
    }
}
