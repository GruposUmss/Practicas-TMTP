package Interfaces;

import Drivers.ScoreManager;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class ScoreDisplay {
    private ScoreManager scoreManager;
    private Font pixelFont;

    public ScoreDisplay(ScoreManager scoreManager) {
        this.scoreManager = scoreManager;
        this.pixelFont = loadPixelFont(30);   
        scoreManager.resetScore();
    }
    
    public Font getPixelFont () {
    	return this.pixelFont;
    }

    private Font loadPixelFont(int size) {
        try {
        	InputStream fontStream = getClass().getResourceAsStream("/PressStart2P-Regular.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            return font.deriveFont(Font.BOLD, size);  
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.BOLD, size);  
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(pixelFont);
        g.drawString(String.format("Score: %07d", scoreManager.getScore()), 10, 30); 
    }
}