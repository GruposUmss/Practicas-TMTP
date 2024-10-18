package Objects;

import Drivers.PositionManager;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Apple{
    private final int APPLE_SIZE = 40;
    private int apple_x;
    private int apple_y;
    private PositionManager posMan;

    public Apple(int width, int height, PositionManager posMan) {
    	this.posMan = posMan;
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
        apple_x = ThreadLocalRandom.current().nextInt((width / APPLE_SIZE) - 1) * APPLE_SIZE;
        apple_y = ThreadLocalRandom.current().nextInt((height / APPLE_SIZE) - 1) * APPLE_SIZE;
        if(posMan.overlay(apple_x, apple_y, APPLE_SIZE)) {
        	locationApple(width, height);
        }
    }
    
    public void draw(Graphics g) {
    	g.drawImage(Images.ALIEN_1, apple_x, apple_y, APPLE_SIZE, APPLE_SIZE, null);
    }
}