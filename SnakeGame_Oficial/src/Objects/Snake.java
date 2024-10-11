package Objects;

import Drivers.MotionSnake;
import java.awt.*;

public class Snake {

    private final int DOT_SIZE = 20;
    private final int[] pos_x;
    private final int[] pos_y;
    private int dots; 
    public MotionSnake ms; 

    public Snake(int initialSize) {
    	ms = new MotionSnake();
        pos_x = new int[900];  
        pos_y = new int[900];
        dots = initialSize;
        initSnake();
    }
    
    public int getSize() {
        return dots;
    }

    private void initSnake() {
        for (int i = 0; i < dots; i++) {
            pos_x[i] = 50 - i * 10;
            pos_y[i] = 50;
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < dots; i++) {
            if (i == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.green);
            }
            g.fillRect(pos_x[i], pos_y[i], DOT_SIZE, DOT_SIZE);
        }
    }
    
    public void move() {
    	for(int i = dots; i > 0; i--) {
    		pos_x[i] = pos_x[i - 1];
    		pos_y[i] = pos_y[i - 1];
    	}
    	
    	if(ms.getRightDirection()) {
    		pos_x[0] += DOT_SIZE;
    	}
    	
    	if(ms.getLeftDirection()) {
    		pos_x[0] -= DOT_SIZE;
    	}
    	
    	if(ms.getDownDirection()) {
    		pos_y[0] += DOT_SIZE;
    	}
    	
    	if(ms.getUpDirection()) {
    		pos_y[0] -= DOT_SIZE;
    	}
    }
}