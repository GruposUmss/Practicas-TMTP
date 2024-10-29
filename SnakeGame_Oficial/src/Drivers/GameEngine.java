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
	private CollisionsManager collisionManager;
	private PositionManager positionManager;
	private ScoreManager scoreManager; //Agregado para el puntaje
	private LifeManager lifeManager;
	
	private Timer timer;
	
	private final int DELAY = 90;
	private boolean inGame = true;
	
	public GameEngine(SnakeGame snakeGame, ScoreManager scoreManager) {
		this.scoreManager = scoreManager;
		this.lifeManager = new LifeManager();
		this.positionManager = new PositionManager();
		this.snakeGame = snakeGame;
        this.snake = new Snake(5); 
        this.apple = new Apple(snakeGame.getWidth(), snakeGame.getHeight(), positionManager); 
        this.blackHole = new BlackHole(snakeGame.getWidth(), snakeGame.getHeight(), positionManager);
        this.orange = new Orange(snakeGame.getWidth(), snakeGame.getHeight(), positionManager);
		this.collisionManager = new CollisionsManager(snakeGame, this);
	}
	
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	public LifeManager getLifeManager () {
		return this.lifeManager;
	}
	
	public ScoreManager getScoreManager () { 
        return this.scoreManager;
    }
	
	public PositionManager getPositionManager() {
		return this.positionManager;
	}
	
	public CollisionsManager getCollisionsManager() {
		return this.collisionManager;
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
	
	public void startGame() {
		addPositionActuals();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void blinkSnake () {
		snake.setInmunity(true);
		Timer blinkTimer = new Timer(150, new ActionListener() {
	        private int blinkCount = 0;
	        
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            snake.setVisible(!snake.getVisible());  // Alterna visibilidad
	            snakeGame.repaint();  // Re-pinta el juego para reflejar los cambios
	             
	            blinkCount++;
	            if (blinkCount >= 30) {  // Detener después de 5 parpadeos
	                ((Timer) e.getSource()).stop();  // Detiene el temporizador
	                snake.setVisible(true);  // Asegura que la serpiente quede visible al final
	                snakeGame.repaint();  // Re-pinta por última vez
	                snake.setInmunity(false);
	            }
	        }
	    });
	    blinkTimer.start();  // Inicia el temporizador para el parpadeo
	}
	
	private void endGame() {
	    timer.stop();
	    if (SwingUtilities.getWindowAncestor(snakeGame) != null) {
	        SwingUtilities.getWindowAncestor(snakeGame).dispose();
	    }
	    new Menu(this.scoreManager).setVisible(true);
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
			addPositionActuals();
			collisionManager.checkCollisionLimits();
			collisionManager.checkCollisionBody(); 
			collisionManager.checkCollisionApple();
			collisionManager.checkCollisionOrange();
			collisionManager.checkCollisionBlackHole();
		}else {
			endGame();
		}		
		snakeGame.repaint();
	}
}
