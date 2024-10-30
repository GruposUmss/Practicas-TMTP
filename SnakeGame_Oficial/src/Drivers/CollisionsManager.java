package Drivers;

import Interfaces.SnakeGame;
import Objects.*;

public class CollisionsManager {
	
	private SnakeGame snakeGame;
	private GameEngine gameEngine;
	
	public CollisionsManager( SnakeGame sg, GameEngine ge) {
		this.snakeGame = sg;
		this.gameEngine = ge;
	}
	
	public void checkCollisionLimits () {
		if (gameEngine.getSnake().getSnakePosX(0) >= snakeGame.getWidth()) {
			gameEngine.getSnake().setSnakePosX(0);
		} else if (gameEngine.getSnake().getSnakePosX(0) < 0) {
			gameEngine.getSnake().setSnakePosX(snakeGame.getWidth() - gameEngine.getSnake().getSnakeRectSize());
		}
		
		if (gameEngine.getSnake().getSnakePosY(0) >= snakeGame.getHeight()) {
			gameEngine.getSnake().setSnakePosY(0);
		} else if (gameEngine.getSnake().getSnakePosY(0) < 0) {
			gameEngine.getSnake().setSnakePosY(snakeGame.getHeight() - gameEngine.getSnake().getSnakeRectSize());
		}
	}

	public void checkCollisionBody () {
		if(gameEngine.getSnake().getInmunity()) return;
		for (int i = gameEngine.getSnake().getSnakeSize(); i > 0; i--) {
				if((gameEngine.getSnake().getSnakePosX(0) == gameEngine.getSnake().getSnakePosX(i)) && 
					(gameEngine.getSnake().getSnakePosY(0) == gameEngine.getSnake().getSnakePosY(i))) {
					if (gameEngine.getLifeManager().getLives() <= 0) {
						gameEngine.setInGame(false);
					}
					gameEngine.getLifeManager().loseLife();
					gameEngine.blinkSnake();	
				}
		}
	}
	
	public void checkCollisionEntity () {
		for (Entity entity: gameEngine.getEntityList()) {
			if(gameEngine.getSnake().getSnakePosX(0) >= entity.getX() && 
					gameEngine.getSnake().getSnakePosY(0) >= entity.getY() && 
					gameEngine.getSnake().getSnakePosX(0) < entity.getX() + entity.getSize() &&
					gameEngine.getSnake().getSnakePosY(0) < entity.getY() + entity.getSize()) {
					
					if (entity instanceof Apple) {
						collisionApple(entity);
					}
					if (entity instanceof Orange) {
						collisionOrange(entity);
					}
					if (entity instanceof BlackHole) {
						if (!gameEngine.getSnake().getInmunity()) collisionBlackHole(entity);
					}
			}
		}
	}
	
	private void collisionApple (Entity entity) {
		entity.location(snakeGame.getWidth(), snakeGame.getHeight());
		gameEngine.getSnake().setSnakeSize(gameEngine.getSnake().getSnakeSize() + 1);
		gameEngine.getScoreManager().increaseScore(100);
	}
	
	private void collisionOrange (Entity entity) {
		Orange orange = (Orange)entity;
		orange.setVisible(false);
		orange.resetLocation();
		gameEngine.getSnake().setSnakeSize(gameEngine.getSnake().getSnakeSize() + 3);
		gameEngine.getScoreManager().increaseScore(200);
	}
	
	private void collisionBlackHole (Entity entity) {
		if (gameEngine.getLifeManager().getLives() <= 0) {
			gameEngine.setInGame(false);
		}
		BlackHole blackHole = (BlackHole)entity;
		blackHole.setVisible(false);
		blackHole.resetLocation();
		gameEngine.blinkSnake();
		gameEngine.getLifeManager().loseLife();
	}
}