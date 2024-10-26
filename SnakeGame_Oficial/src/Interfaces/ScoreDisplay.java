package Interfaces;

import Drivers.ScoreManager;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ScoreDisplay {
    private ScoreManager scoreManager;
    private Font pixelFont;

    public ScoreDisplay(ScoreManager scoreManager) {
        this.scoreManager = scoreManager;
        this.pixelFont = loadPixelFont(30);   
        scoreManager.resetScore();
    }

    private Font loadPixelFont(int size) {
        try {
            File fontFile = new File("C:/Users/Adrian/workspace/Fuente Pixel/PressStart2P-Regular.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
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