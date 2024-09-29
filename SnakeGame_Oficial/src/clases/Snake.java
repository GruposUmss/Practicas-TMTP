package clases;
import java.awt.*;

class Snake {

    private final int DOT_SIZE = 20;
    private final int[] x;
    private final int[] y;
    private int dots; 

    public Snake(int initialSize) {
        x = new int[900];  
        y = new int[900];
        dots = initialSize;
        initSnake();
    }

    private void initSnake() {
        for (int i = 0; i < dots; i++) {
            x[i] = 50 - i * 10;
            y[i] = 50;
        }
    }

    public int getSize() {
        return dots;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < dots; i++) {
            if (i == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.green);
            }
            g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
        }
    }
}