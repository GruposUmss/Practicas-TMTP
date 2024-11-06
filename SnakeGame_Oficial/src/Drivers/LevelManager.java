package Drivers;

import Objects.GameSettings;

/**
 * La clase LevelManager es responsable de gestionar los niveles del juego 
 * en función de la puntuación del jugador. Realiza un seguimiento del nivel 
 * actual y ejecuta las acciones asociadas a cada nivel cuando la puntuación 
 * alcanza umbrales específicos.
 */
public class LevelManager {

	private GameEngine gameEngine;
	//private ScoreManager scoreManager;
	private GameSettings.Levels levelActual;
	
	public LevelManager (ScoreManager scoreManager, GameEngine gameEngine) {
		//this.scoreManager = scoreManager;
		this.gameEngine = gameEngine;
		this.levelActual = GameSettings.Levels.ZERO;
	}
	
	public void reviewLevels (int score) {
		switch (score) {
			case 0 -> {if (this.levelActual == GameSettings.Levels.ZERO) executeLevelONE(); this.levelActual = GameSettings.Levels.ONE;}
			case 500 -> {if (this.levelActual == GameSettings.Levels.ONE) executeLevelTWO(); this.levelActual = GameSettings.Levels.TWO;}
			case 1000 -> {if (this.levelActual == GameSettings.Levels.TWO) executeLevelTHREE(); this.levelActual = GameSettings.Levels.THREE;}
			case 2000 -> {if (this.levelActual == GameSettings.Levels.THREE) executeLevelFOUR(); this.levelActual = GameSettings.Levels.FOUR;}
			case 2500 -> {if (this.levelActual == GameSettings.Levels.FOUR) executeLevelFIVE(); this.levelActual = GameSettings.Levels.FIVE;}
			case 3500 -> {if (this.levelActual == GameSettings.Levels.FIVE) executeLevelSIX(); this.levelActual = GameSettings.Levels.SIX;}
			case 4500 -> {if (this.levelActual == GameSettings.Levels.SIX) executeLevelSEVEN(); this.levelActual = GameSettings.Levels.SEVEN;}
			case 5500 -> {if (this.levelActual == GameSettings.Levels.SEVEN) executeLevelEIGTH(); this.levelActual = GameSettings.Levels.EIGTH;}
			case 6500 -> {if (this.levelActual == GameSettings.Levels.EIGTH) executeLevelNINE(); this.levelActual = GameSettings.Levels.NINE;}
			case 8000 -> {if (this.levelActual == GameSettings.Levels.NINE) executeLevelTEN(); this.levelActual = GameSettings.Levels.TEN;}
		}
	}
	
	//se agrego esto
	public GameSettings.Levels getLevelActual() {
		return this.levelActual;
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