package Interfaces;

import Drivers.LifeManager;
import Objects.Images;
import javax.swing.*;
import java.awt.*;

public class LifeDisplay extends JPanel {
    private LifeManager lifeManager;

    public LifeDisplay(LifeManager lifeManager) {
        this.lifeManager = lifeManager;
        setPreferredSize(new Dimension(200, 50));
    }

    public void draw(Graphics g) {
        for (int i = 0; i < lifeManager.getLives(); i++) {
            Image heartImage = Images.HEART; 
            if (heartImage != null) {
                g.drawImage(heartImage, 10 + i * 30, 40, 40, 40, null); 
            }
        }
    }
}