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
	
	public CollisionsManager(Snake snake, Apple apple, Orange orange, BlackHole blackHole, SnakeGame snakeGame,PositionManager posMan, GameEngine gameEngine) {
		this.snake = snake;
		this.apple = apple;
		this.orange = orange;
		this.blackHole = blackHole;
		this.snakeGame = snakeGame;
		this.gameEngine = gameEngine;
		this.posMan = posMan;
	}
	
	public void checkCollisionLimits() {
		if(snake.getSnakePosX(0) >= snakeGame.getWidth() || snake.getSnakePosX(0) < 0 || 
		   snake.getSnakePosY(0) >= snakeGame.getHeight() || snake.getSnakePosY(0) < 0) {
			gameEngine.setInGame(false);
		}
	}
	
	public void checkCollisionBody() {
		for(int i = snake.getSnakeSize(); i > 0; i--) {
			if((snake.getSnakePosX(0) == snake.getSnakePosX(i)) && (snake.getSnakePosY(0) == snake.getSnakePosY(i))) {
				gameEngine.setInGame(false);
			}
		}
	}
	
	public void checkCollisionApple() {
		if(snake.getSnakePosX(0) == apple.getX() && snake.getSnakePosY(0) == apple.getY()) {
			snake.setSnakeSize(snake.getSnakeSize() + 1);
			posMan.removePosition(apple.getX(), apple.getY(), apple.getSize());
			apple.locationApple(snakeGame.getWidth(), snakeGame.getHeight());
			gameEngine.addPositionActuals();
		}
	}
	
	public void checkCollisionOrange() {
		if(snake.getSnakePosX(0) == orange.getX() && snake.getSnakePosY(0) == orange.getY()) {
			snake.setSnakeSize(snake.getSnakeSize() + 4);
			posMan.removePosition(orange.getX(), orange.getY(), orange.getSize());
			orange.resetLocation();
			gameEngine.addPositionActuals();
		}
	}
	
	public void checkCollisionBlackHole() {
		if(snake.getSnakePosX(0) >= blackHole.getX() && 
			snake.getSnakePosY(0) >= blackHole.getY() &&
			snake.getSnakePosX(0) < blackHole.getX() + blackHole.getSize() && 
			snake.getSnakePosY(0) < blackHole.getY() + blackHole.getSize()) {
			gameEngine.setInGame(false);
		}
	}
}
