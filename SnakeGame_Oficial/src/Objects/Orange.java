package Objects;

import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class Orange {
    private final int ORANGE_SIZE = 20;
    private int orange_x;
    private int orange_y;
    private Random random;
    private boolean visible;
    private Timer timer;

    public Orange(int width, int height) {
        random = new Random();
        visible = true;
        locationOrange(width, height, 0, 0, 0, 0, height, height); 

        timer = new Timer(4000, e -> toggleVisibility(width, height, 0, 0, 0, 0, height, height));
        timer.start(); 
    }
    
    public int getX() {
        return orange_x;
    }

    public int getY() {
        return orange_y;
    }

    public boolean isVisible() {
        return visible; 
    }

    private void toggleVisibility(int width, int height, int blackHoleX, int blackHoleY, int blackHoleSize, int appleX, int appleY, int appleSize) {
        visible = !visible; 
        if (visible) {
            locationOrange(width, height, blackHoleX, blackHoleY, blackHoleSize, appleX, appleY, appleSize); // Reubica la naranja
        }
    }

    public void locationOrange(int width, int height, int blackHoleX, int blackHoleY, int blackHoleSize, int appleX, int appleY, int appleSize) {
        do {
            orange_x = random.nextInt((width / ORANGE_SIZE) - 1) * ORANGE_SIZE;
            orange_y = random.nextInt((height / ORANGE_SIZE) - 1) * ORANGE_SIZE;
        } while (isOverlapping(blackHoleX, blackHoleY, blackHoleSize, appleX, appleY, appleSize));
    }

    private boolean isOverlapping(int blackHoleX, int blackHoleY, int blackHoleSize, int appleX, int appleY, int appleSize) {
        int distanceToBlackHole = calculateDistance(orange_x, orange_y, blackHoleX, blackHoleY, ORANGE_SIZE, blackHoleSize);
        int distanceToApple = calculateDistance(orange_x, orange_y, appleX, appleY, ORANGE_SIZE, appleSize);
        return distanceToBlackHole < 0 || distanceToApple < 0; 
    }

    private int calculateDistance(int x1, int y1, int x2, int y2, int size1, int size2) {
        int distanceX = x1 - x2;
        int distanceY = y1 - y2;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        return (int) (distance - (size1 + size2) / 2);
    }

    public void draw(Graphics g) {
        if (visible) {
            g.setColor(Color.ORANGE);
            g.fillOval(orange_x, orange_y, ORANGE_SIZE, ORANGE_SIZE);
        }
    }
}