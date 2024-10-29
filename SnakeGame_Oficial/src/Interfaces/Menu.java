package Interfaces;

import Objects.GameSettings;
import Objects.Images;
import Drivers.ScoreManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {

	//private int widthFrame;
	//private int heightFrame;
    private JToggleButton easyButton;
    private JToggleButton hardButton;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel highScoreLabel; // Añadido para mostrar el puntaje más alto
    private ScoreManager scoreManager;
    private GameSettings.Dificulty dificulty;

    //se creo dos constructores para poder dividri la responsabilidad de creacion e instancias de Menu
    public Menu () {
    	this.dificulty = GameSettings.Dificulty.EASY;
    	this.scoreManager = new ScoreManager();
    	initMenu();
    }
    
    public Menu(ScoreManager scoreManager) {
    	this.scoreManager = scoreManager; // Inicializa ScoreManager
        initMenu();
    }

    private void initMenu() {
        setTitle("Snake Game - Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); //Maximiza la ventana
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createTitlePanel(), "StartScreen");
        mainPanel.add(createButtonPanel(), "Menu");

        add(mainPanel);
       
        showStartScreen();
        
        
        /*
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                widthFrame = getWidth();
                heightFrame = getHeight();
            }
        });
        */
    }

    private void showStartScreen() {
        cardLayout.show(mainPanel, "StartScreen");
    }

    private JPanel createTitlePanel() {
        //Crear un panel para la carátula
        JPanel titlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = Images.FONDO;
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        titlePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Añadir las palabras en colores diferentes
        JLabel snakeLabel = new JLabel("SNAKE");
        snakeLabel.setFont(loadPixelFont(77));
        snakeLabel.setForeground(Color.GREEN);
        titlePanel.add(snakeLabel, gbc);

        gbc.gridy++;
        JLabel gameLabel = new JLabel("GAME");
        gameLabel.setFont(loadPixelFont(77));
        gameLabel.setForeground(Color.RED);
        titlePanel.add(gameLabel, gbc);

        gbc.gridy++;
        JLabel galacticLabel = new JLabel("GALACTIC");
        galacticLabel.setFont(loadPixelFont(77));
        galacticLabel.setForeground(Color.BLUE);
        titlePanel.add(galacticLabel, gbc);
        
        // Panel de relleno para mantener los títulos en el centro
        gbc.gridy++;
        gbc.weighty = 1.0;
        JPanel fillerPanel = new JPanel();
        fillerPanel.setOpaque(false);  
        titlePanel.add(fillerPanel, gbc);

        // Mensaje en la parte inferior
        gbc.gridy++;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(20, 0, 30, 0);
        
        JLabel pressKeyLabel = new JLabel("Press Enter or Space key to enter");
        pressKeyLabel.setFont(loadPixelFont(20)); 
        pressKeyLabel.setForeground(Color.WHITE); 
        titlePanel.add(pressKeyLabel, gbc);
        
        // Efecto de parpadeo para el mensaje
        Timer blinkTimer = new Timer(300, e -> pressKeyLabel.setVisible(!pressKeyLabel.isVisible()));
        blinkTimer.start();

        titlePanel.setFocusable(true);
        titlePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    switchToMenu();
                }
            }
        });

        return titlePanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = Images.FONDO;
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        easyButton = new JToggleButton("Easy");
        hardButton = new JToggleButton("Hard");

        easyButton.setFont(loadPixelFont(20));
        hardButton.setFont(loadPixelFont(20));

        // Usamos un solo ActionListener para manejar la selección
        easyButton.addActionListener(this::toggleDifficulty);
        hardButton.addActionListener(this::toggleDifficulty);

        buttonPanel.add(easyButton, gbc);
        gbc.gridy++;
        buttonPanel.add(hardButton, gbc);

        gbc.gridy++;
        JButton playButton = createPlayButton();
        buttonPanel.add(playButton, gbc);
        
        //Añadir JLabel para mostrar el puntaje más alto
        gbc.gridy++;
        highScoreLabel = new JLabel("High Score: " + String.format("%07d", scoreManager.getHighScore()));
        highScoreLabel.setFont(loadPixelFont(30)); 
        highScoreLabel.setForeground(Color.YELLOW); 
        buttonPanel.add(highScoreLabel, gbc);

        return buttonPanel;
    }

    private void toggleDifficulty(ActionEvent e) {
        JToggleButton source = (JToggleButton) e.getSource();
        if (source == easyButton) {
            hardButton.setSelected(!easyButton.isSelected());
            this.dificulty = GameSettings.Dificulty.EASY;
           
        } else {
            easyButton.setSelected(!hardButton.isSelected());
            this.dificulty = GameSettings.Dificulty.HARD;
        }
    }


    private JButton createPlayButton() {
        JButton playButton = new JButton("Play");
        playButton.setFont(loadPixelFont(30));
        playButton.setBackground(Color.BLUE);
        playButton.setForeground(Color.WHITE);
        playButton.addActionListener(e -> startGame());
        return playButton;
    }

    private void switchToMenu() {
        cardLayout.show(mainPanel, "Menu");
        mainPanel.revalidate(); //Actualiza el panel
        mainPanel.repaint(); //Vuelve a dibujar
    }

    private void startGame() {
        dispose();
        JFrame gameFrame = new JFrame("Snake Game");
        SnakeGame snakeGame = new SnakeGame(this.scoreManager, this.dificulty);
        gameFrame.add(snakeGame);
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza la ventan
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
        
        System.out.println(snakeGame.getWidth() + snakeGame.getHeight());
    }
    
    
    private Font loadPixelFont(int size) {
        try {
            File fontFile = new File("C:/Users/Adrian/workspace/Fuente Pixel/PressStart2P-Regular.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            return font.deriveFont(Font.BOLD, size);  // Ajustar el tamaño y estilo
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font("SansSerif", Font.BOLD, size);  // Fallback en caso de error
        }
    }
}