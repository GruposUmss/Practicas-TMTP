package Drivers;

import Interfaces.SnakeGame;

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
	
	public void checkCollisionApple () {
		if(gameEngine.getSnake().getSnakePosX(0) >= gameEngine.getApple().getX() && 
			gameEngine.getSnake().getSnakePosY(0) >= gameEngine.getApple().getY() && 
			gameEngine.getSnake().getSnakePosX(0) < gameEngine.getApple().getX() + gameEngine.getApple().getSize() &&
			gameEngine.getSnake().getSnakePosY(0) < gameEngine.getApple().getY() + gameEngine.getApple().getSize()) {
			
			gameEngine.getApple().locationApple(snakeGame.getWidth(), snakeGame.getHeight());
			gameEngine.getSnake().setSnakeSize(gameEngine.getSnake().getSnakeSize() + 1);
			gameEngine.getScoreManager().increaseScore(10);
			//gameEngine.addPositionActuals();
		}
	}
	
	public void checkCollisionOrange() {
		if(gameEngine.getSnake().getSnakePosX(0) >= gameEngine.getOrange().getX() && 
			gameEngine.getSnake().getSnakePosY(0) >= gameEngine.getOrange().getY() &&
			gameEngine.getSnake().getSnakePosX(0) < gameEngine.getOrange().getX() + gameEngine.getOrange().getSize() &&
			gameEngine.getSnake().getSnakePosY(0) < gameEngine.getOrange().getY() + gameEngine.getOrange().getSize()) {
			
			gameEngine.getOrange().setVisible(false);
			gameEngine.getOrange().resetLocation();
			gameEngine.getSnake().setSnakeSize(gameEngine.getSnake().getSnakeSize() + 4);
			gameEngine.getScoreManager().increaseScore(50);
			//gameEngine.addPositionActuals();
		}
	}

	public void checkCollisionBlackHole () {
		if (!gameEngine.getSnake().getInmunity()) {
			if(gameEngine.getSnake().getSnakePosX(0) >= gameEngine.getBlackHole().getX() && 
				gameEngine.getSnake().getSnakePosY(0) >= gameEngine.getBlackHole().getY() &&
				gameEngine.getSnake().getSnakePosX(0) < gameEngine.getBlackHole().getX() + gameEngine.getBlackHole().getSize() && 
				gameEngine.getSnake().getSnakePosY(0) < gameEngine.getBlackHole().getY() + gameEngine.getBlackHole().getSize()) {
					
				if (gameEngine.getLifeManager().getLives() <= 0) {
					gameEngine.setInGame(false);
				}
					
				gameEngine.getBlackHole().setVisible(false);
				gameEngine.blinkSnake();
				gameEngine.getLifeManager().loseLife();
			}
			
		}
	}
}
