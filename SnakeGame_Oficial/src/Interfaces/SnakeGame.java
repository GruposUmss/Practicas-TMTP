package Interfaces;

import Drivers.*;
import javax.swing.*;
import java.awt.*;

public class SnakeGame extends JPanel{
	
	//Esto se agrego para verificar la version de la clase serializable
    private static final long serialVersionUID = 1L;

    private final int WIDTH = 1360; 
    private final int HEIGHT = 700;
    private GameEngine gameEngine;
    public SnakeGame() {
        initBoard();
    }
    
    public GameEngine getGameEngine() {
    	return this.gameEngine;
    }
     
    public int getWidth() {
    	return WIDTH;
    }
    
    public int getHeight() {
    	return HEIGHT;
    }
    
    private void initBoard() {
        setBackground(Color.black);
        setFocusable(true);
        requestFocusInWindow();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        this.gameEngine = new GameEngine(this);
        gameEngine.starGame();
        
        addKeyListener(new MotionSnake(gameEngine.getSnake())); //Define el listado de llaves para el taclado
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g) {
        gameEngine.getSnake().draw(g); 
        gameEngine.getApple().draw(g); 
        gameEngine.getOrange().draw(g); 
        gameEngine.getBlackHole().draw(g);
    }
}
