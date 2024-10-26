package Drivers;

import Objects.*;
import Interfaces.SnakeGame;

public class CollisionsManager {
	private Snake snake;
	private Apple apple;
	private Orange orange;
	private BlackHole blackHole;
	private SnakeGame snakeGame;
	private GameEngine gameEngine;
	private PositionManager posMan;
	private ScoreManager scoreManager;
	private LifeManager lifeManager; 
	
	public CollisionsManager(Snake s, Apple a, Orange o, BlackHole bh, SnakeGame sg, PositionManager pm, ScoreManager sm, LifeManager lm, GameEngine ge) {
		this.snake = s;
		this.apple = a;
		this.orange = o;
		this.blackHole = bh;
		this.snakeGame = sg;
		this.gameEngine = ge;
		this.posMan = pm;
		this.scoreManager = sm;
		this.lifeManager = lm;
	}
	
	public void checkCollisionLimits() {
		if (snake.getSnakePosX(0) >= snakeGame.getWidth()) {
			snake.setSnakePosX(0);
		} else if (snake.getSnakePosX(0) < 0) {
			snake.setSnakePosX(snakeGame.getWidth() - snake.getSnakeRectSize());
		}
		
		if (snake.getSnakePosY(0) >= snakeGame.getHeight()) {
			snake.setSnakePosY(0);
		} else if (snake.getSnakePosY(0) < 0) {
			snake.setSnakePosY(snakeGame.getHeight() - snake.getSnakeRectSize());
		}
	}

	public void checkCollisionBody() {
		/*
		int cont = snake.getSnakeSize();
		while (cont > 0) {
			if (!snake.getInmunity()) {
				if((snake.getSnakePosX(0) == snake.getSnakePosX(cont)) && 
					(snake.getSnakePosY(0) == snake.getSnakePosY(cont))) {
					if (lifeManager.getLives() <= 0) {
						gameEngine.setInGame(false);
					}
					lifeManager.loseLife();
					gameEngine.blinkSnake();
					break;
				}
			} 
			cont--;
		}
		*/
		if(snake.getInmunity()) return;
		for (int i = snake.getSnakeSize(); i > 0; i--) {
				if((snake.getSnakePosX(0) == snake.getSnakePosX(i)) && 
					(snake.getSnakePosY(0) == snake.getSnakePosY(i))) {
					if (lifeManager.getLives() <= 0) {
						gameEngine.setInGame(false);
					}
					lifeManager.loseLife();
					gameEngine.blinkSnake();	
				}
		}
		
	}
	
	public void checkCollisionApple() {
		if(snake.getSnakePosX(0) >= apple.getX() && 
			snake.getSnakePosY(0) >= apple.getY() && 
			snake.getSnakePosX(0) < apple.getX() + apple.getSize() &&
			snake.getSnakePosY(0) < apple.getY() + apple.getSize()) {
			
			apple.locationApple(snakeGame.getWidth(), snakeGame.getHeight());
			posMan.removePosition(apple.getX(), apple.getY(), apple.getSize());
			snake.setSnakeSize(snake.getSnakeSize() + 1);
			scoreManager.increaseScore(10);
			gameEngine.addPositionActuals();
		}
	}
	
	public void checkCollisionOrange() {
		if(snake.getSnakePosX(0) >= orange.getX() && 
			snake.getSnakePosY(0) >= orange.getY() &&
			snake.getSnakePosX(0) < orange.getX() + orange.getSize() &&
			snake.getSnakePosY(0) < orange.getY() + orange.getSize()) {
			
			orange.setVisible(false);
			orange.resetLocation();
			posMan.removePosition(orange.getX(), orange.getY(), orange.getSize());
			snake.setSnakeSize(snake.getSnakeSize() + 4);
			scoreManager.increaseScore(50);
			gameEngine.addPositionActuals();
		}
	}

	public void checkCollisionBlackHole() {
		if (!snake.getInmunity()) {
			if(snake.getSnakePosX(0) >= blackHole.getX() && 
				snake.getSnakePosY(0) >= blackHole.getY() &&
				snake.getSnakePosX(0) < blackHole.getX() + blackHole.getSize() && 
				snake.getSnakePosY(0) < blackHole.getY() + blackHole.getSize()) {
					
				if (lifeManager.getLives() <= 0) {
					gameEngine.setInGame(false);
				}
					
				blackHole.setVisible(false);
				gameEngine.blinkSnake();
				lifeManager.loseLife();
			}
			
		}
	}
}
