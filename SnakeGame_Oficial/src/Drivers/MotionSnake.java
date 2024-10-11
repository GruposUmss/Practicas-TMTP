package Drivers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MotionSnake extends KeyAdapter {
	private boolean rightDirection = true;
	private boolean leftDirection = false;
	private boolean upDirection = false;
	private boolean downDirection = false;
	
	public boolean getRightDirection() {
		return rightDirection;
	}
	
	public boolean getLeftDirection() {
		return leftDirection;
	}
	
	public boolean getUpDirection() {
		return upDirection;
	}
	
	public boolean getDownDirection() {
		return downDirection;
	}
	
	@Override
	public void keyPressed (KeyEvent e) {
		
		int button = e.getKeyCode();
		
		if((button == KeyEvent.VK_RIGHT) && (!leftDirection)) {
			rightDirection = true;
			upDirection = false;
			downDirection = false;
			System.out.println(button);
		}
		if((button == KeyEvent.VK_LEFT) && (!rightDirection)) {
			leftDirection = true;
			upDirection = false;
			downDirection = false;
			System.out.println(button);
		}
		if((button == KeyEvent.VK_UP) && (!downDirection)) {
			upDirection = true;
			leftDirection = false;
			rightDirection = false;
			System.out.println(button);
		}
		if((button == KeyEvent.VK_DOWN) && (!upDirection)) {
			downDirection = true;
			leftDirection = false;
			rightDirection = false;
			System.out.println(button);
		}
	}
}