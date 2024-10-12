package Objects;

import java.awt.*;

public class Snake {

	private Directions direction;
    private final int DOT_SIZE = 20;
    private final int[] pos_x;
    private final int[] pos_y;
    private int dots; 
    

    public Snake(int initialSize) {
    	this.direction = Directions.RIGTH;
        pos_x = new int[900];  
        pos_y = new int[900];
        dots = initialSize;
        initSnake();
    }
    
    public void setDirection(Directions direction) {
    	this.direction = direction; 
    }

    private void initSnake() {
        for (int i = 0; i < dots; i++) {
            pos_x[i] = 60 - i * 10;
            pos_y[i] = 60;
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
    	
    	if(direction == Directions.RIGTH) {
    		pos_x[0] += DOT_SIZE;
    	}
    	
    	if(direction == Directions.LEFT) {
    		pos_x[0] -= DOT_SIZE;
    	}
    	
    	if(direction == Directions.DOWN) {
    		pos_y[0] += DOT_SIZE;
    	}
    	
    	if(direction == Directions.UP) {
    		pos_y[0] -= DOT_SIZE;
    	}
    }
    
    public boolean movingRigth() {
    	return direction == Directions.RIGTH;
    }
    
    public boolean movingLeft() {
    	return direction == Directions.LEFT;
    }
    
    public boolean movingUp() {
    	return direction == Directions.UP;
    }
    
    public boolean movingDown() {
    	return direction == Directions.DOWN;
    }
    
}