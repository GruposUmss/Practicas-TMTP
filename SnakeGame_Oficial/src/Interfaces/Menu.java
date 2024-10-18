package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

        //Panel para el título
        add(createTitlePanel(), BorderLayout.NORTH);
        
        //Panel para los botones
        add(createButtonPanel(), BorderLayout.CENTER);
    }
    
    private JButton createPlayButton() {
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 20));
        playButton.setBackground(Color.BLUE);
        playButton.setForeground(Color.WHITE);
        playButton.addActionListener(e -> startGame());
        return playButton;
    }
    
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0; // Inicia en la fila 0
        gbc.insets = new Insets(10, 0, 10, 0);

        easyButton = new JToggleButton("Easy");
        hardButton = new JToggleButton("Hard");

        //Usamos un solo ActionListener para manejar la selección
        easyButton.addActionListener(this::toggleDifficulty);
        hardButton.addActionListener(this::toggleDifficulty);

        buttonPanel.add(easyButton, gbc);
        gbc.gridy++; 
        buttonPanel.add(hardButton, gbc); 

        gbc.gridy++; 
        JButton playButton = createPlayButton();
        buttonPanel.add(playButton, gbc); 

        return buttonPanel;
    }
    
    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("SNAKE GAME", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titlePanel.add(titleLabel);
        return titlePanel;
    }
    
    private void toggleDifficulty(ActionEvent e) {
        JToggleButton source = (JToggleButton) e.getSource();
        if (source == easyButton) {
            hardButton.setSelected(!easyButton.isSelected());
        } else {
            easyButton.setSelected(!hardButton.isSelected());
        }
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
