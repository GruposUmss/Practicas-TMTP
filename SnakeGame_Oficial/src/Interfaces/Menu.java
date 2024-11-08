package Interfaces;

import Objects.GameSettings;
import Drivers.ScoreManager;
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
	
    private final int WIDTH_WINDOW = 1360; 
    private final int HEIGHT_WINDOW = 740;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ScoreManager scoreManager;
    private GameSettings.Dificulty difficulty;
    private AudioPlayer audioPlayer;

    public Menu() {
        this.difficulty = GameSettings.Dificulty.EASY;
        this.scoreManager = new ScoreManager();
        this.audioPlayer = new AudioPlayer(); //se agrego estoo
        this.audioPlayer.playLoop(); //se agrego estoo
        initMenu();
    }

    public Menu(ScoreManager scoreManager) {
        this.scoreManager = scoreManager; 
        initMenu();
    }

    private void initMenu() {
        setTitle("Snake Game - Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.WIDTH_WINDOW, this.HEIGHT_WINDOW);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new TitlePanel(), "StartScreen");
        mainPanel.add(new ButtonPanel(scoreManager, this), "MenuButton");
        
        add(mainPanel);
        showStartScreen();
    }

    private void showStartScreen() {
        cardLayout.show(mainPanel, "StartScreen");
    }
    
    public void showMenuButton() {
        cardLayout.show(mainPanel, "MenuButton");
        mainPanel.revalidate(); 
        mainPanel.repaint(); 
    }
    
    public void startGame() {
        dispose();
        JFrame gameFrame = new JFrame("Snake Game");
        SnakeGame snakeGame = new SnakeGame(this.scoreManager, difficulty);
        snakeGame.initGameValid();
        gameFrame.add(snakeGame);
        gameFrame.pack();
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
    }
    
    public GameSettings.Dificulty getDifficulty (){ // se agrego esto
    	return this.difficulty;
    }
    
    public void setDifficulty (GameSettings.Dificulty dificulty) {
    	this.difficulty = dificulty;
    }
    
    public int getWidthWindow() {
    	return this.WIDTH_WINDOW;
    }
    
    public int getHeightWindow() {
    	return this.HEIGHT_WINDOW;
    }
}