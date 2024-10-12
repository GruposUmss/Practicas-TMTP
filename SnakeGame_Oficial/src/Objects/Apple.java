package Objects;

import java.util.Random;
import java.awt.*;

public class Apple {
    private final int APPLE_SIZE = 20;
    private int apple_x;
    private int apple_y;
    private Random random;

    public Apple(int width, int height) {
        random = new Random();
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

    private void locationApple(int width, int height) {
        apple_x = random.nextInt((width / APPLE_SIZE) - 1) * APPLE_SIZE;
        apple_y = random.nextInt((height / APPLE_SIZE) - 1) * APPLE_SIZE;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(apple_x, apple_y, APPLE_SIZE, APPLE_SIZE);
    }
}