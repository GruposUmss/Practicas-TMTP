package Objects;

import Drivers.PositionManager;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;

public class Orange implements ActionListener {
    private final int ORANGE_SIZE = 40;
    private int width;
    private int height;
    private int orange_x;
    private int orange_y;
    private PositionManager posMan;
    private Timer timer;
    private boolean visible;

    public Orange(int width, int height, PositionManager posMan) {
    	this.posMan = posMan;
    	this.width = width;
    	this.height = height;
        this.visible = true;
        locationOrange();
       
    }
    public int getX() {
        return orange_x;
    }

    public int getY() {
        return orange_y;
    }

    public int getSize() {
        return ORANGE_SIZE;
    }
    
    public void loadOrange() {
    	timer = new Timer(4000, this);
    	timer.start();
    } 
    
    public void resetLocation() {
    	visible = false;
    	timer.restart();
    }

    public void locationOrange() {
        orange_x = ThreadLocalRandom.current().nextInt((width / ORANGE_SIZE) - 1) * ORANGE_SIZE;
        orange_y = ThreadLocalRandom.current().nextInt((height / ORANGE_SIZE) - 1) * ORANGE_SIZE;
        if(posMan.overlay(orange_x, orange_y, ORANGE_SIZE)) {
        	locationOrange();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	visible = !visible;
    	locationOrange();
    }
    
    public void draw(Graphics g) {
    	if(visible) {
    		g.drawImage(Images.ALIEN_2, orange_x, orange_y, ORANGE_SIZE, ORANGE_SIZE, null);
    	}
    }
}