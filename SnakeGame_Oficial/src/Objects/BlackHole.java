package Objects;

import java.util.Random;
import java.awt.*;

public class BlackHole {
    private final int BLACK_HOLE_SIZE = 30;
    private int blackHole_x;
    private int blackHole_y;
    private Random random;

    public BlackHole(int width, int height) {
        random = new Random();
        locationBlackHole(width, height); 
    }

    private void locationBlackHole(int width, int height) {
        blackHole_x = random.nextInt(width - BLACK_HOLE_SIZE);
        blackHole_y = random.nextInt(height - BLACK_HOLE_SIZE);
    }

    public int getX() {
        return blackHole_x;
    }

    public int getY() {
        return blackHole_y;
    }

    public int getSize() {
        return BLACK_HOLE_SIZE; 
    }

    public void draw(Graphics g) {
        g.setColor(Color.cyan); 
        g.fillOval(blackHole_x, blackHole_y, BLACK_HOLE_SIZE, BLACK_HOLE_SIZE); 
    }
}
