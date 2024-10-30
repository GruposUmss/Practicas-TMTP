package Drivers;

import Objects.*;
import Interfaces.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameEngine implements ActionListener {

	private List<Entity> entityList;
	private Snake snake;
	private SnakeGame snakeGame;
	private CollisionsManager collisionManager;
	private PositionManager positionManager;
	private ScoreManager scoreManager; 
	private LifeManager lifeManager;
	private LevelManager levelManager;

	private Timer timer;
	
	private final int DELAY = 90;
	private boolean inGame = true;
	
	public GameEngine(SnakeGame snakeGame, ScoreManager scoreManager) {
		this.snakeGame = snakeGame;
		this.scoreManager = scoreManager;
		this.lifeManager = new LifeManager();
		this.positionManager = new PositionManager();
		this.collisionManager = new CollisionsManager(snakeGame, this);
		this.levelManager = new LevelManager(scoreManager, this);
		this.snake = new Snake(5);
		this.entityList = new ArrayList<Entity>();
	}
	
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	public boolean getInGame() {
		return this.inGame;
	}
	
	public Snake getSnake() {
		return this.snake;
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
	
	public void addEntityApple () {
		this.entityList.add(new Apple(snakeGame.getWidth(), snakeGame.getHeight(), this.positionManager));
	}
	
	public void addEntityOrange () {
		this.entityList.add(new Orange(snakeGame.getWidth(), snakeGame.getHeight(), this.positionManager));
	}
	
	public void addEntityBlackHole () {
		this.entityList.add(new BlackHole(snakeGame.getWidth(), snakeGame.getHeight(), this.positionManager));
	}
	
	public List<Entity> getEntityList () {
		return this.entityList;
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
	            snake.setVisible(!snake.getVisible());  //Alterna visibilidad
	            snakeGame.repaint();  //Re-pinta el juego para reflejar los cambios
	             
	            blinkCount++;
	            if (blinkCount >= 30) {  //Detener después de 5 parpadeos
	                ((Timer) e.getSource()).stop();  //Detiene el temporizador
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
		
		for (Entity entity: this.entityList) {
			positionManager.addPosition(entity.getX(), entity.getY(), entity.getSize());
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame) {
			snake.move();
			addPositionActuals();
			levelManager.reviewLevels();
			collisionManager.checkCollisionLimits();
			collisionManager.checkCollisionBody(); 
			collisionManager.checkCollisionEntity();
		}else {
			endGame();
		}		
		snakeGame.repaint();
	}
}
