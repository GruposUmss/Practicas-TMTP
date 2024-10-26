package Drivers;

import Objects.Directions;
import Objects.Snake;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MotionSnake extends KeyAdapter {
	
	private Snake snake;
	
	public MotionSnake(Snake snake) {
		this.snake = snake;
	}
	
	@Override
	public void keyPressed (KeyEvent e) {
		int button = e.getKeyCode();
		
		switch (button) {
	        case KeyEvent.VK_RIGHT -> { if (!snake.movingLeft()) snake.setDirection(Directions.RIGTH); }
	        case KeyEvent.VK_LEFT -> { if (!snake.movingRigth()) snake.setDirection(Directions.LEFT); }
	        case KeyEvent.VK_UP -> { if (!snake.movingDown()) snake.setDirection(Directions.UP); }
	        case KeyEvent.VK_DOWN -> { if (!snake.movingUp()) snake.setDirection(Directions.DOWN); }
	    }
	}
}