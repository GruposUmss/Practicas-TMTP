package Objects;


import Drivers.PositionManager;
import java.util.Random;
import java.awt.*;

public class Apple {
    private final int APPLE_SIZE = 20;
    private int apple_x;
    private int apple_y;
    private Random random;
    private PositionManager posMan;

    public Apple(int width, int height, PositionManager posMan) {
    	this.posMan = posMan;
        this.random = new Random();
        locationApple(width, height);
    }
    public int getX() {
        return apple_x;
    }

    public int getY() {
        return apple_y;
    }

    public int getSize() {
        return APPLE_SIZE;
    }

    public void locationApple(int width, int height) {
        apple_x = random.nextInt((width / APPLE_SIZE) - 1) * APPLE_SIZE;
        apple_y = random.nextInt((height / APPLE_SIZE) - 1) * APPLE_SIZE;
        if(posMan.overlay(apple_x, apple_y, APPLE_SIZE)) {
        	locationApple(width, height);
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(apple_x, apple_y, APPLE_SIZE, APPLE_SIZE);
    }
}