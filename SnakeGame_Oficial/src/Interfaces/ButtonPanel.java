package Interfaces;

import Drivers.ScoreManager;
import Objects.GameSettings;
import Objects.Images;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;

public class ButtonPanel extends JPanel {

	private final int LLETER_SIZE = 50;
	private final int BUTTON_WIDTH = 250;
	private final int BUTTON_HEIGHT = 90;
	private final int SIZE_HEART = 200;
    private JToggleButton easyButton;
    private JToggleButton hardButton;
    private JLabel highScoreEasy;
    private JLabel highScoreHard;
    private Menu menu;

    public ButtonPanel(ScoreManager scoreManager, Menu menu) {
        this.menu = menu;
        setLayout(null); 
        createButtons();
        createHighScores(scoreManager);
    }
    
    //se modificooo
    private void createButtons() {
        easyButton = new JToggleButton("Easy");
        easyButton.setBounds(150, 150, this.BUTTON_WIDTH, this.BUTTON_HEIGHT); 
        easyButton.setFont(loadPixelFont(this.LLETER_SIZE));
        easyButton.addActionListener(this::toggleDifficulty);
        add(easyButton);

        hardButton = new JToggleButton("Hard");
        hardButton.setBounds(950, 150, this.BUTTON_WIDTH, this.BUTTON_HEIGHT); 
        hardButton.setFont(loadPixelFont(this.LLETER_SIZE));
        hardButton.addActionListener(this::toggleDifficulty);
        add(hardButton);

        JButton playButton = createPlayButton();
        playButton.setBounds(555, 520, this.BUTTON_WIDTH, this.BUTTON_HEIGHT); 
        add(playButton);
    }
    
    //se modifico
    private void createHighScores(ScoreManager scoreManager) {
        highScoreEasy = new JLabel("High Score Easy:" + String.format("%07d", scoreManager.getHighScoreEasy()));
        highScoreEasy.setFont(loadPixelFont(25));
        highScoreEasy.setForeground(Color.YELLOW);
        highScoreEasy.setBounds(5, 110, 600, 40);
        add(highScoreEasy);
        
        highScoreHard = new JLabel("High Score Hard:" + String.format("%07d", scoreManager.getHighScoreHard()));
        highScoreHard.setFont(loadPixelFont(25));
        highScoreHard.setForeground(Color.YELLOW);
        highScoreHard.setBounds(750, 110, 600, 40);
        add(highScoreHard);
    }

    //Se modifico
    private JButton createPlayButton() {
        JButton playButton = new JButton("Play");
        playButton.setFont(loadPixelFont(this.LLETER_SIZE));
        playButton.setBackground(Color.BLUE);
        playButton.setForeground(Color.WHITE);
        playButton.addActionListener(e -> { 
        	if (!easyButton.isSelected() && !hardButton.isSelected()) {
        		mesageSelectionDificulty(); 
        	} else {
        		this.menu.startGame(); 
        	}
        });
        return playButton;
    }

    //se modifico
    private void toggleDifficulty(ActionEvent e) {
        JToggleButton source = (JToggleButton) e.getSource();

        if (source == easyButton) {
            easyButton.setSelected(true);
            easyButton.setForeground(new Color(0, 0, 255));  
            hardButton.setSelected(false);
            hardButton.setForeground(null);  
        }

        if (source == hardButton) {
            hardButton.setSelected(true);
            hardButton.setForeground(new Color(0, 0, 255)); 
            easyButton.setSelected(false);
            easyButton.setForeground(null);  
        }

        if (easyButton.isSelected()) {
            this.menu.setDifficulty(GameSettings.Dificulty.EASY);
        } else if (hardButton.isSelected()) {
            this.menu.setDifficulty(GameSettings.Dificulty.HARD);
        }
        easyButton.repaint();
        hardButton.repaint();
        revalidate();
        repaint();
    }
    
    //se agrego
    private void mesageSelectionDificulty() {
    	JLabel pressDificulty = new JLabel("Select some difficulty :3");
        pressDificulty.setFont(loadPixelFont(25)); 
        pressDificulty.setForeground(Color.WHITE); 

        setLayout(null);
        pressDificulty.setBounds(360, getHeight() - 50, pressDificulty.getPreferredSize().width, pressDificulty.getPreferredSize().height);
        add(pressDificulty);
        mesageBlinkEfect(pressDificulty);
    }
    
    //se agrego este metodo
    private void mesageBlinkEfect (JLabel label) {
    	Timer blinkTimer = new Timer(300, e -> label.setVisible(!label.isVisible()));
        blinkTimer.start();
        Timer stopTimer = new Timer(4000, e -> { blinkTimer.stop(); label.setVisible(false);});
        
        stopTimer.setRepeats(false);
        stopTimer.start();
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
    
    //se agregoo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (Images.FONDO != null) {
            g.drawImage(Images.FONDO, 0, 0, getWidth(), getHeight(), this); 
        }
        
        if (menu.getDifficulty() == GameSettings.Dificulty.EASY && Images.HEART != null) {
            g.drawImage(Images.HEART, 580, 300, this.SIZE_HEART, this.SIZE_HEART, this);    
        }
    }

}