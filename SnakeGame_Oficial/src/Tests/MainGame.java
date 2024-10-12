package Tests;

import javax.swing.JFrame;

import Interfaces.SnakeGame;

public class MainGame {
	public static void main(String [] args) {
		JFrame frame = new JFrame();
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
}
