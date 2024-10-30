package Objects;

import Drivers.PositionManager;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;

public class Orange extends Entity implements ActionListener {
    private int width;
    private int height;
    private Timer timer;
    
    public Orange(int width, int height, PositionManager posMan) {
    	super(width, height, posMan);
    	this.width = width;
    	this.height = height;
        locationOrange();
        loadOrange();
    }
    
    public void loadOrange() {
    	timer = new Timer(4000, this);
    	timer.start();
    } 
    
    public void resetLocation() {
    	//locationOrange();
    	timer.restart();
    }

    public void locationOrange() {
        posX = ThreadLocalRandom.current().nextInt((width / ENTITY_SIZE) - 1) * ENTITY_SIZE;
        posY = ThreadLocalRandom.current().nextInt((height / ENTITY_SIZE) - 1) * ENTITY_SIZE;
        if(posMan.overlay(posX, posY, ENTITY_SIZE)) {
        	locationOrange();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	visible = !visible;
    	if (visible) {
            locationOrange();  
        } else {
        	//Restablece los valores de coordenadas para no mantenerla aun asi cuadno visible sea FALSE
        	posX = -this.ENTITY_SIZE;
        	posY = -this.ENTITY_SIZE;
        }
    }
    
    @Override
    public void draw(Graphics g) {
    	if(visible) {
    		g.drawImage(Images.ALIEN_2, posX, posY, this.ENTITY_SIZE, this.ENTITY_SIZE, null);
    	}
    }
}