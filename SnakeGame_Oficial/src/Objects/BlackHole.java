package Objects;

import Drivers.PositionManager;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;

public class BlackHole {
    private final int BLACK_HOLE_SIZE = 80;
    private int blackHole_x;
    private int blackHole_y;
    private PositionManager posMan;
    

    public BlackHole(int width, int height, PositionManager posMan) {
    	this.posMan = posMan;
        locationBlackHole(width, height); 
    }
    public int getX() {
        return this.blackHole_x;
    }

    public int getY() {
        return this.blackHole_y;
    }

    public int getSize() {
        return this.BLACK_HOLE_SIZE; 
    }

    public void locationBlackHole(int width, int height) {
        blackHole_x = ThreadLocalRandom.current().nextInt((width / BLACK_HOLE_SIZE) - 1) * BLACK_HOLE_SIZE;
        blackHole_y = ThreadLocalRandom.current().nextInt((height / BLACK_HOLE_SIZE) - 1) * BLACK_HOLE_SIZE;
        if(posMan.overlay(blackHole_x, blackHole_y, BLACK_HOLE_SIZE)) {
        	locationBlackHole(width, height);
        }
    }

    public void draw(Graphics g) {
    	g.drawImage(Images.BLACK_HOLE, blackHole_x, blackHole_y, BLACK_HOLE_SIZE, BLACK_HOLE_SIZE, null); 
    }
}