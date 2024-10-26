package Objects;

import Drivers.PositionManager;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.geom.AffineTransform;
import java.awt.*;

public class BlackHole {
    private final int BLACK_HOLE_SIZE = 80;
    private int blackHole_x;
    private int blackHole_y;
    private double angle = 0; 
    private boolean visible;
    private PositionManager posMan;
    

    public BlackHole(int width, int height, PositionManager posMan) {
    	this.visible = true;
    	this.posMan = posMan;
        locationBlackHole(width, height); 
    }
    
    public void setVisible (boolean vs) {
    	this.visible = vs;
    }
    
    public boolean getVisible () {
    	return this.visible;
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
        if(posMan.overlay(blackHole_y, blackHole_x, BLACK_HOLE_SIZE)) {
        	locationBlackHole(width, height);
        }
    }

    public void draw(Graphics g) {
    	if (visible) {
    		angle -= Math.toRadians(2);

            Graphics2D graphics2d = (Graphics2D) g;
            AffineTransform oldTransform = graphics2d.getTransform();

            int centerX = blackHole_x + BLACK_HOLE_SIZE / 2;
            int centerY = blackHole_y + BLACK_HOLE_SIZE / 2;

            graphics2d.rotate(angle, centerX, centerY);
            graphics2d.drawImage(Images.BLACK_HOLE, blackHole_x, blackHole_y, BLACK_HOLE_SIZE, BLACK_HOLE_SIZE, null);
            graphics2d.setTransform(oldTransform); 
    		
    	} else {
    		this.blackHole_x = -this.BLACK_HOLE_SIZE;
    		this.blackHole_y = -this.BLACK_HOLE_SIZE;
    	}
    	
    		
    }
}