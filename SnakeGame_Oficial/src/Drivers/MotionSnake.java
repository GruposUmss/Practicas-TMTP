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
		
		if((button == KeyEvent.VK_RIGHT) && (!snake.movingLeft())) {
			snake.setDirection(Directions.RIGTH);
			System.out.println(button);
		}
		
		if((button == KeyEvent.VK_LEFT) && (!snake.movingRigth())) {
			snake.setDirection(Directions.LEFT);
			System.out.println(button);
		}
		if((button == KeyEvent.VK_UP) && (!snake.movingDown())) {
			snake.setDirection(Directions.UP);
			System.out.println(button);
		}
		if((button == KeyEvent.VK_DOWN) && (!snake.movingUp())) {
			snake.setDirection(Directions.DOWN);
			System.out.println(button);
		}
	}
}