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

    private JToggleButton easyButton;
    private JToggleButton hardButton;
    private JLabel highScoreLabel;
    private Menu menu;

    public ButtonPanel(ScoreManager scoreManager, Menu menu) {
        this.menu = menu;
        setLayout(new GridBagLayout());
        createButtons();
        createHighScoreLabel(scoreManager);
    }

    private void createButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        easyButton = new JToggleButton("Easy");
        hardButton = new JToggleButton("Hard");

        easyButton.setFont(loadPixelFont(20));
        hardButton.setFont(loadPixelFont(20));

        easyButton.addActionListener(this::toggleDifficulty);
        hardButton.addActionListener(this::toggleDifficulty);

        add(easyButton, gbc);
        gbc.gridy++;
        add(hardButton, gbc);

        gbc.gridy++;
        JButton playButton = createPlayButton();
        add(playButton, gbc);
    }

    private JButton createPlayButton() {
        JButton playButton = new JButton("Play");
        playButton.setFont(loadPixelFont(30));
        playButton.setBackground(Color.BLUE);
        playButton.setForeground(Color.WHITE);
        playButton.addActionListener(e -> this.menu.startGame());
        return playButton;
    }

    private void createHighScoreLabel(ScoreManager scoreManager) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 3; 
        highScoreLabel = new JLabel("High Score: " + String.format("%07d", scoreManager.getHighScore()));
        highScoreLabel.setFont(loadPixelFont(30)); 
        highScoreLabel.setForeground(Color.YELLOW); 
        add(highScoreLabel, gbc);
    }

    private void toggleDifficulty(ActionEvent e) {
        JToggleButton source = (JToggleButton) e.getSource();
        if (source == easyButton) {
            hardButton.setSelected(!easyButton.isSelected());
            this.menu.setDificulty(GameSettings.Dificulty.EASY);
        } else {
            easyButton.setSelected(!hardButton.isSelected());
            this.menu.setDificulty(GameSettings.Dificulty.HARD);
        }
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (Images.FONDO != null) {
            g.drawImage(Images.FONDO, 0, 0, getWidth(), getHeight(), this); 
        }
    }
}