package Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    
    private JToggleButton easyButton; // Botón para el modo fácil
    private JToggleButton hardButton; // Botón para el modo difícil

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
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Aumentar el tamaño de la fuente
        titlePanel.add(titleLabel);
        
        add(titlePanel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());  // Usamos GridBagLayout para centrar los botones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 0, 10, 0); 

        // Crear botones de dificultad
        easyButton = new JToggleButton("Easy");
        hardButton = new JToggleButton("Hard");
        
        // Acción del botón Easy
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (easyButton.isSelected()) {
                    hardButton.setSelected(false); // Desactiva el botón Hard
                }
            }
        });

        // Acción del botón Hard
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hardButton.isSelected()) {
                    easyButton.setSelected(false); // Desactiva el botón Easy
                }
            }
        });

        gbc.gridy = 0;  // Fila 0
        buttonPanel.add(easyButton, gbc);

        // Añadir el botón "Hard" en la segunda fila
        gbc.gridy = 1;  // Fila 1
        buttonPanel.add(hardButton, gbc);

        // Botón Play en una fila debajo de los botones de dificultad
        gbc.gridy = 2;  // Fila 2
       
        // Botón Play
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 20));
        playButton.setBackground(Color.BLUE); // Fondo azul
        playButton.setForeground(Color.WHITE); // Texto blanco
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame(); // Aquí podrías pasar la dificultad seleccionada si lo deseas
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
