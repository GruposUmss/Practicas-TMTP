package Interfaces;

import Drivers.LifeManager;
import Objects.Images;
import javax.swing.*;
import java.awt.*;

public class LifeDisplay extends JPanel {
	
	private final int HEART_SIZE = 40;
    private LifeManager lifeManager;
    private boolean visible;

    public LifeDisplay(LifeManager lifeManager) {
    	this.visible = true;
        this.lifeManager = lifeManager;
        setPreferredSize(new Dimension(200, 50));
    }
    
    public void setVisible (boolean visible) {
    	this.visible = visible;
    	if (!this.visible) {
    		this.lifeManager.setVisible(this.visible);
    	}
    }
    
    public void draw(Graphics g) {
    	if (!this.visible) return; 
        for (int i = 0; i < lifeManager.getLives(); i++) {
            Image heartImage = Images.HEART; 
            if (heartImage != null) {
                g.drawImage(heartImage, 10 + i * 30, 40, this.HEART_SIZE, this.HEART_SIZE, null); 
            }
        }
    }
}