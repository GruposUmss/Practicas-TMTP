package Drivers;

import Objects.GameSettings;

public class LevelManager {

	private GameEngine gameEngine;
	private ScoreManager scoreManager;
	private GameSettings.Levels levelActual;
	
	public LevelManager (ScoreManager scoreManager, GameEngine gameEngine) {
		this.scoreManager = scoreManager;
		this.gameEngine = gameEngine;
		this.levelActual = GameSettings.Levels.ONE;
	}
	
	public void reviewLevels () {
		int scoreActual = scoreManager.getScore();
		
		switch (scoreActual) {
			case 0 -> {if (this.levelActual == GameSettings.Levels.ONE) executeLevelONE(); this.levelActual = GameSettings.Levels.TWO;}
			case 500 -> {if (this.levelActual == GameSettings.Levels.TWO) executeLevelTWO(); this.levelActual = GameSettings.Levels.THREE;}
			case 1000 -> {if (this.levelActual == GameSettings.Levels.THREE) executeLevelTHREE(); this.levelActual = GameSettings.Levels.FOUR;}
		}
	}
	
	private void executeLevelONE() {
		gameEngine.addEntityApple();
	}
	
	private void executeLevelTWO () {
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelTHREE () {
		
	}
}
