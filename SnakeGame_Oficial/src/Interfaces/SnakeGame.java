package Interfaces;

import Objects.*;
import Drivers.*;
import javax.swing.*;
import java.awt.*;

// Clase principal que representa el juego Snake
public class SnakeGame extends JPanel{
	
	//Esto se agrego para verificar la version de la clase serializable
    private static final long serialVersionUID = 1L;

    //Dimension de la ventana en X y Y
    private final int WIDTH = 1360; 
    private final int HEIGHT = 700;
    
    //Instancias de los objetos del juego
    private Snake snake;
    private Apple apple;
    private Orange orange;
    private BlackHole blackHole;
    private GameEngine gameEngine;
    private PositionManager positionManager;

    public SnakeGame() {
        initBoard();
    }
    
    public PositionManager posMan() {
    	return positionManager;
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
        
        this.positionManager = new PositionManager();
        snake = new Snake(5); 
        apple = new Apple(WIDTH, HEIGHT, positionManager); 
        orange = new Orange(WIDTH, HEIGHT, positionManager); 
        blackHole = new BlackHole(WIDTH, HEIGHT, positionManager);
        orange.loadOrange();
    
        gameEngine = new GameEngine(snake, apple, orange, blackHole,positionManager, this);
        gameEngine.starGame();
        
        addKeyListener(new MotionSnake (snake)); //Define el listado de llaves para el taclado
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g) {
        apple.draw(g); //Dibuja la manzana
        snake.draw(g); //Dibuja la serpiente
        orange.draw(g); //Dibuja naranja
        blackHole.draw(g); //Dibuja agujero negro
    }
}
