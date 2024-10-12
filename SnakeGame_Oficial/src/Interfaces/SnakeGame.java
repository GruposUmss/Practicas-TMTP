package Interfaces;

import Objects.*;
import javax.swing.*;

import Drivers.GameEngine;
import Drivers.MotionSnake;

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

    public SnakeGame() {
        initBoard();
    }
    
    private void initBoard() {
        setBackground(Color.black);
        setFocusable(true);
        requestFocusInWindow();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        snake = new Snake(5); 
        apple = new Apple(WIDTH, HEIGHT); 
        orange = new Orange(WIDTH, HEIGHT); 
        blackHole = new BlackHole(WIDTH, HEIGHT);
        orange.locationOrange(WIDTH, HEIGHT, blackHole.getX(), blackHole.getY(), blackHole.getSize(), apple.getX(), apple.getY(), apple.getSize());
    
        gameEngine = new GameEngine(snake, apple, orange, blackHole, this);
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
