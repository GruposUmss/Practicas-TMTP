package Drivers;

import Objects.Apple;
import Objects.Snake;
import javax.swing.*;
import java.awt.*;

// Clase principal que representa el juego Snake
public class SnakeGame extends JPanel {
	
	//Esto se agrego para verificar la version de la clase serializable
    private static final long serialVersionUID = 1L;

    //Dimension de la ventana en X y Y
    private final int WIDTH = 900; 
    private final int HEIGHT = 600;
    
    private Snake snake;
    private Apple apple;

    public SnakeGame() {
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.white);
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        snake = new Snake(5); // Inicia la serpiente con tamaño 5
        apple = new Apple(WIDTH, HEIGHT); // Coloca la manzana
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
}
