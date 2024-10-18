package Interfaces;

import Drivers.*;
import javax.swing.*;
import java.awt.*;

//Clase principal que representa el juego Snake
public class SnakeGame extends JPanel{
	
    //Dimension de la ventana en X y Y
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
        gameEngine.getSnake().draw(g); //Dibuja la manzana
        gameEngine.getApple().draw(g); //Dibuja la serpiente
        gameEngine.getOrange().draw(g); //Dibuja naranja
        gameEngine.getBlackHole().draw(g); //Dibuja agujero negro
    }
}
