package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

	public Menu() {
        initMenu();
    }

    private void initMenu() {
    	
        setTitle("Snake Game - Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

       
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        buttonPanel.add(playButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    private void startGame() {
        dispose();
        JFrame gameFrame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        gameFrame.add(game);
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }
}
