package Drivers;

import Objects.*;
import Interfaces.SnakeGame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GameEngine implements ActionListener {

	private Snake snake;
	private Apple apple;
	private Orange orange;
	private BlackHole blackHole;
	private SnakeGame snakeGame;
	private CollisionsManager collision;
	private PositionManager positionManager;
	
	private Timer timer;
	
	private final int DELAY = 90;
	private boolean inGame = true;
	
	public GameEngine(Snake snake, Apple apple, Orange orange, BlackHole blackHole,PositionManager positionManager, SnakeGame snakeGame) {
		this.snake = snake;
		this.apple = apple;
		this.orange = orange;
		this.blackHole = blackHole;
		this.snakeGame = snakeGame;
		this.positionManager = positionManager;
		this.collision = new CollisionsManager(snake, apple, orange, blackHole, snakeGame, positionManager, this);
	}
	
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	public void starGame() {
		addPositionActuals();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void removePositionActual(int x, int y, int size) {
		positionManager.removePosition(x, y, size);
	}
	
	public void addPositionActuals() {
		positionManager.clearPositions();
		positionManager.addPosition(apple.getX(), apple.getY(), apple.getSize());
		positionManager.addPosition(orange.getX(), orange.getY(), orange.getSize());
		positionManager.addPosition(blackHole.getX(), blackHole.getY(), orange.getSize());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame) {
			snake.move();
			collision.checkCollisionLimits();
			collision.checkCollisionBody(); 
			collision.checkCollisionApple();
			collision.checkCollisionOrange();
			collision.checkCollisionBlackHole();
		}else {
			timer.stop();
		}		
		snakeGame.repaint();
	}
}
