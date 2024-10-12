package Drivers;

import Objects.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import Interfaces.SnakeGame;

public class GameEngine implements ActionListener {

	private Snake snake;
	private Apple apple;
	private Orange orange;
	private BlackHole blackHole;
	private SnakeGame snakeGame;
	
	private Timer timer;
	
	private final int DELAY = 90;
	private boolean inGame = true;
	
	public GameEngine(Snake snake, Apple apple, Orange orange, BlackHole blackHole, SnakeGame snakeGame) {
		this.snake = snake;
		this.apple = apple;
		this.orange = orange;
		this.blackHole = blackHole;
		this.snakeGame = snakeGame;
	}
	
	public void starGame() {
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame) {
			snake.move();	
		}		
		snakeGame.repaint();
	}
	
	private void checkCollisions() {
	
	}
}
