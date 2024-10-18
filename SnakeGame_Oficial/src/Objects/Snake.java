package Objects;

import java.awt.*;

public class Snake {

	private final Directions[] registerDirection;
    private final int RECT_SIZE = 20;
    private final int[] pos_x;
    private final int[] pos_y; 
    private int snakeSize; 
    private Directions direction;
    
    public Snake(int snakeSize) {
    	this.registerDirection = new Directions[900];
    	this.direction = Directions.RIGTH;
    	this.snakeSize = snakeSize;
        this.pos_x = new int[900];  
        this.pos_y = new int[900];
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
    	if (direction != null) {  //Evita que la dirección sea null y se genera un IllegalException
            this.direction = direction;
        } 
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
                g.drawImage(getHeadImage(registerDirection[i]), pos_x[i], pos_y[i], RECT_SIZE, RECT_SIZE, null);
            } else {
            	g.drawImage(getBodyImage(registerDirection[i]), pos_x[i], pos_y[i], RECT_SIZE, RECT_SIZE, null);
            }
        }
    }
    
    private Image getBodyImage(Directions dir) {
    	if (dir == null) dir = Directions.RIGTH;//Evita que se den direcciones nulas, debido a las actualizaciones
        switch (dir) {
            case LEFT: return Images.SNAKE_BODY_LEFT;
            case UP: return Images.SNAKE_BODY_UP;
            case DOWN: return Images.SNAKE_BODY_DOWN;
            case RIGTH: return Images.SNAKE_BODY_RIGTH;
            default: return Images.SNAKE_BODY_RIGTH;
        }
    }
    
    private Image getHeadImage(Directions dir) {
    	if (dir == null) dir = Directions.RIGTH; //Evita que se den direcciones nulas, debido a las actualizaciones
        switch (dir) {
            case LEFT: return Images.SNAKE_HEAD_LEFT;
            case UP: return Images.SNAKE_HEAD_UP;
            case DOWN: return Images.SNAKE_HEAD_DOWN;
            case RIGTH: return Images.SNAKE_HEAD_RIGTH;
            default: return Images.SNAKE_HEAD_RIGTH;
        }
    }
    
    public void move() {
    	for(int i = snakeSize; i > 0; i--) {
    		pos_x[i] = pos_x[i - 1];
    		pos_y[i] = pos_y[i - 1];
    		registerDirection[i] = registerDirection[i - 1]; //Asignar direccion de siguiente al anterior
    	}
    	registerDirection[0] = direction; //Guardar la dirección de la cabeza en registerDirection[0]
    	
    	switch (direction) {
	        case RIGTH -> pos_x[0] += RECT_SIZE;
	        case LEFT  -> pos_x[0] -= RECT_SIZE;
	        case DOWN  -> pos_y[0] += RECT_SIZE;
	        case UP    -> pos_y[0] -= RECT_SIZE;
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