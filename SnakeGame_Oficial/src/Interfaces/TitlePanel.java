package Interfaces;

import Objects.Images;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FontFormatException;
import java.io.InputStream;
import java.io.IOException;


public class TitlePanel extends JPanel {

    public TitlePanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);
        createTitleComponents();
        setupKeyListener();
    }

    private void createTitleComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel snakeLabel = new JLabel("SNAKE");
        snakeLabel.setFont(loadPixelFont(77));
        snakeLabel.setForeground(Color.GREEN);
        add(snakeLabel, gbc);

        gbc.gridy++;
        JLabel gameLabel = new JLabel("GAME");
        gameLabel.setFont(loadPixelFont(77));
        gameLabel.setForeground(Color.RED);
        add(gameLabel, gbc);

        gbc.gridy++;
        JLabel galacticLabel = new JLabel("GALACTIC");
        galacticLabel.setFont(loadPixelFont(77));
        galacticLabel.setForeground(Color.BLUE);
        add(galacticLabel, gbc);

        gbc.gridy++;
        gbc.weighty = 1.0;
        JPanel fillerPanel = new JPanel();
        fillerPanel.setOpaque(false);  
        add(fillerPanel, gbc);

        gbc.gridy++;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(20, 0, 30, 0);

        JLabel pressKeyLabel = new JLabel("Press Enter or Space key to enter");
        pressKeyLabel.setFont(loadPixelFont(20)); 
        pressKeyLabel.setForeground(Color.WHITE); 
        add(pressKeyLabel, gbc);
        setupBlinkingEffect(pressKeyLabel);
    }

    private void setupBlinkingEffect(JLabel label) {
        Timer blinkTimer = new Timer(300, e -> label.setVisible(!label.isVisible()));
        blinkTimer.start();
    }

    private void setupKeyListener() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                	System.out.println("1");
                	((Menu) SwingUtilities.getWindowAncestor(TitlePanel.this)).showMenuButton();
                }
            }
        });
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