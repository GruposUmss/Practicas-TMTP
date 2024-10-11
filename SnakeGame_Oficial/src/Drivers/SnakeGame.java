package Drivers;

import Objects.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Clase principal que representa el juego Snake
public class SnakeGame extends JPanel implements ActionListener {
	
	//Esto se agrego para verificar la version de la clase serializable
    private static final long serialVersionUID = 1L;

    //Dimension de la ventana en X y Y
    private final int WIDTH = 900; 
    private final int HEIGHT = 600;
    
    // Delay de retraso de actualizaciones de la ventana
    private final int DELAY = 140;
    
    //Instancias de los objetos del juego
    private Snake snake;
    private Apple apple;
    private Orange orange;
    private BlackHole blackHole;
    
    //Estado activo del juego
    private boolean inGame = true;
    
    //Instancia del minutero
    private Timer timer;

    public SnakeGame() {
        initBoard();
    }
    
    public int getAppleX() {
        return apple.getX();
    }

    public int getAppleY() {
        return apple.getY();
    }

    public int getInitialSnakeSize() {
        return snake.getSize();
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
    
        addKeyListener(snake.ms); //Define que el listado de llaves sera la instancia que esta en Snake
        loadGame();
    }
    
    private void loadGame() {
    	
    	timer = new Timer (DELAY, this);
    	timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(inGame) {
    		snake.move();
    	}
    	repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g) {
        // Dibuja la manzana
        apple.draw(g);

        // Dibuja la serpiente
        snake.draw(g);
        
        // Dibuja naranja
        orange.draw(g);
        
        // Dibuja agujero negro
        blackHole.draw(g);
    }
}
