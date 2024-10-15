package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    
    private JToggleButton easyButton;
    private JToggleButton hardButton; 

    public Menu() {
        initMenu();
    }

    private void initMenu() {
        setTitle("Snake Game - Menu");
        setSize(1700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para el título
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("SNAKE GAME", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); 
        titlePanel.add(titleLabel);
        
        add(titlePanel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());  // Usamos GridBagLayout para centrar los botones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 0, 10, 0); 

        //creacion de los botones de dificultad 
        easyButton = new JToggleButton("Easy");
        hardButton = new JToggleButton("Hard");
        
      
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (easyButton.isSelected()) {
                    hardButton.setSelected(false);
                }
            }
        });

        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hardButton.isSelected()) {
                    easyButton.setSelected(false);
                }
            }
        });

        gbc.gridy = 0;  
        buttonPanel.add(easyButton, gbc);

       
        gbc.gridy = 1; 
        buttonPanel.add(hardButton, gbc);

    
        gbc.gridy = 2;  
       
        
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 20));
        playButton.setBackground(Color.BLUE); 
        playButton.setForeground(Color.WHITE); 
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame(); // 
            }
        });

        buttonPanel.add(playButton, gbc);

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
