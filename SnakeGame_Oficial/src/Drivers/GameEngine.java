package Drivers;

import Objects.*;
import Interfaces.*;
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
	
	public GameEngine(SnakeGame snakeGame) {
		this.positionManager = new PositionManager();
		this.snakeGame = snakeGame;
        this.snake = new Snake(5); 
        this.apple = new Apple(snakeGame.getWidth(), snakeGame.getHeight(), positionManager); 
        this.blackHole = new BlackHole(snakeGame.getWidth(), snakeGame.getHeight(), positionManager);
        this.orange = new Orange(snakeGame.getWidth(), snakeGame.getHeight(), positionManager);
        orange.loadOrange();
       
		this.collision = new CollisionsManager(snake, apple, orange, blackHole, snakeGame, positionManager, this);
	}
	
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	public PositionManager getPositionManager() {
		return this.positionManager;
	}
	
	public CollisionsManager getCollisionsManager() {
		return this.collision;
	}
	
	public boolean getInGame() {
		return this.inGame;
	}
	
	public Snake getSnake() {
		return this.snake;
	}
	
	public Apple getApple() {
		return this.apple;
	}
	
	public Orange getOrange() {
		return this.orange;
	}
	
	public BlackHole getBlackHole() {
		return this.blackHole;
	}
	
	public void starGame() {
		addPositionActuals();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	private void endGame() {
	    timer.stop();
	    if (SwingUtilities.getWindowAncestor(snakeGame) != null) {
	        SwingUtilities.getWindowAncestor(snakeGame).dispose();
	    }
	    new Menu().setVisible(true);
	}
	
	public void removePositionActual(int x, int y, int size) {
		positionManager.removePosition(x, y, size);
	}
	
	public void addPositionActuals() {
		positionManager.clearPositions();
		positionManager.addPosition(apple.getX(), apple.getY(), apple.getSize());
		positionManager.addPosition(orange.getX(), orange.getY(), orange.getSize());
		positionManager.addPosition(blackHole.getX(), blackHole.getY(), blackHole.getSize());
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
			endGame();
		}		
		snakeGame.repaint();
	}
}
