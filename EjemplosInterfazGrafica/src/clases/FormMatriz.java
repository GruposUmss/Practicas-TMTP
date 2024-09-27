package clases;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.GridLayout;

public class FormMatriz extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int filas = 5;
    private final int columnas = 5;
    private JButton[][] botones;

    public FormMatriz() {
        initComponents();
        crearMatrizDeBotones();
    }

    private void crearMatrizDeBotones() {
        botones = new JButton[filas][columnas];
        JPanel panelBotones = new JPanel(new GridLayout(filas, columnas, 5, 5)); // Usar GridLayout para organizar los botones

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new JButton(); // Crear un nuevo botón
                botones[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde para los botones
                botones[i][j].setBackground(Color.YELLOW); // Fondo para los botones
                panelBotones.add(botones[i][j]); // Añadir el botón al panel
            }
        }

        // Añadir el panel de botones al JFrame
        add(panelBotones);
    }

    private void initComponents() {
        setTitle("Matriz de Botones");
        setSize(400, 400); // Tamaño adecuado para mostrar todos los botones
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }
}
