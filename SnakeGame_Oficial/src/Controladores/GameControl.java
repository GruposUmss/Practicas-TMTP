package Controladores;

import javax.swing.*;
import java.awt.*;
import Objects.Apple;
import Objects.orange;
import Objects.BlackHole;

public class GameControl extends JPanel {

	private static final long serialVersionUID = 1L;
	private orange orange;
    private BlackHole blackHole;
    private Apple apple;

    public GameControl() {
        blackHole = new BlackHole(400, 400);
        apple = new Apple(400, 400); 
        orange = new orange(400, 400);
        
        orange.locationOrange(400, 400, blackHole.getX(), blackHole.getY(), blackHole.getSize(), apple.getX(), apple.getY(), apple.getSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (orange.isVisible()) {
            orange.draw(g);
        }
        blackHole.draw(g);
        apple.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        GameControl panel = new GameControl();
        frame.add(panel);
        frame.setSize(400, 400);|
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
