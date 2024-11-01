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
			case 2000 -> {if (this.levelActual == GameSettings.Levels.FOUR) executeLevelFOUR(); this.levelActual = GameSettings.Levels.FIVE;}
			case 2500 -> {if (this.levelActual == GameSettings.Levels.FIVE) executeLevelFIVE(); this.levelActual = GameSettings.Levels.SIX;}
			case 3500 -> {if (this.levelActual == GameSettings.Levels.SIX) executeLevelSIX(); this.levelActual = GameSettings.Levels.SEVEN;}
			case 4500 -> {if (this.levelActual == GameSettings.Levels.SEVEN) executeLevelSEVEN(); this.levelActual = GameSettings.Levels.EIGTH;}
			case 5500 -> {if (this.levelActual == GameSettings.Levels.EIGTH) executeLevelEIGTH(); this.levelActual = GameSettings.Levels.NINE;}
			case 6500 -> {if (this.levelActual == GameSettings.Levels.NINE) executeLevelNINE(); this.levelActual = GameSettings.Levels.TEN;}
			case 8000 -> {if (this.levelActual == GameSettings.Levels.TEN) executeLevelTEN(); this.levelActual = GameSettings.Levels.ELEVEN;}
		}
	}
	
	private void executeLevelONE() {
		gameEngine.addEntityApple();
	}
	
	private void executeLevelTWO () {
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelTHREE () {
		gameEngine.addEntityOrange();
		gameEngine.removeEntityBlackHole();
	}
	
	private void executeLevelFOUR () {
		gameEngine.addEntityApple();
		gameEngine.addEntityBlackHole();
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelFIVE () {
		gameEngine.addEntityOrange();
		gameEngine.removeEntityBlackHole();
	}
	
	private void executeLevelSIX () {
		gameEngine.addEntityBlackHole();
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelSEVEN () {
		gameEngine.addEntityBlackHole();
		gameEngine.addEntityApple();
		gameEngine.removeEntityOrange();
	}
	
	private void executeLevelEIGTH () {
		gameEngine.addEntityOrange();
		gameEngine.removeEntityApple();
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelNINE () {
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelTEN () {
		gameEngine.addEntityBlackHole();
	}
}
