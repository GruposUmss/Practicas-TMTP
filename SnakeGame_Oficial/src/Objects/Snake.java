package Objects;

import java.awt.*;

public class Snake {

	private Directions direction;
    private final int RECT_SIZE = 20;
    private final int[] pos_x;
    private final int[] pos_y; 
    private int snakeSize; 
    
    public Snake(int snakeSize) {
    	this.direction = Directions.RIGTH;
    	this.snakeSize = snakeSize;
        pos_x = new int[900];  
        pos_y = new int[900];
        initSnake();
    }
    
    public void setSnakeSize(int n) {
    	this.snakeSize = n;
    }
    
    public int getSnakeSize() {
    	return snakeSize;
    }
    
    public int getSnakePosX(int x) {
    	return pos_x[x];
    }
    
    public int getSnakePosY(int y) {
    	return pos_y[y];
    }
    
    public void setDirection(Directions direction) {
    	this.direction = direction; 
    }

    private void initSnake() {
        for (int i = 0; i < snakeSize; i++) {
            pos_x[i] = 60 - i * 10;
            pos_y[i] = 60;
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < snakeSize; i++) {
            if (i == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.green);
            }
            g.fillRect(pos_x[i], pos_y[i], RECT_SIZE, RECT_SIZE);
        }
    }
    
    public void move() {
    	for(int i = snakeSize; i > 0; i--) {
    		pos_x[i] = pos_x[i - 1];
    		pos_y[i] = pos_y[i - 1];
    	}
    	
    	if(direction == Directions.RIGTH) {
    		pos_x[0] += RECT_SIZE;
    	}
    	
    	if(direction == Directions.LEFT) {
    		pos_x[0] -= RECT_SIZE;
    	}
    	
    	if(direction == Directions.DOWN) {
    		pos_y[0] += RECT_SIZE;
    	}
    	
    	if(direction == Directions.UP) {
    		pos_y[0] -= RECT_SIZE;
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