package clases;

import java.awt.*;
import javax.swing.*;

public class JButtonListenerExample {
    //Ventana principal del ejemplo
    static JFrame frame;

    public static void main(String[] args) {
        //Programar la ejecución en el hilo de despacho de eventos (EDT)
        SwingUtilities.invokeLater(JButtonListenerExample::displayJFrame);
    }

    // Método para configurar y mostrar el JFrame
    static void displayJFrame() {
        // Crear el JFrame con título
        frame = new JFrame("Ejemplo de Listener de JButton");

        // Crear el JButton con texto
        JButton showDialogButton = new JButton("HOLO :O");

        // Añadir un ActionListener con expresión lambda al JButton
        showDialogButton.addActionListener(e -> {
            // Crear un JDialog modal con un mensaje cuando se presiona el botón
            JDialog dialog = new JDialog(frame, "Mensaje", true);
            dialog.getContentPane().add(new JLabel("¡Hola! Has presionado el botón.", SwingConstants.CENTER));
            dialog.setSize(200, 100);
            dialog.setLocationRelativeTo(frame);
            dialog.setVisible(true);
        });

        // Configurar el layout del JFrame y añadir el JButton
        frame.setLayout(new FlowLayout());
        frame.add(showDialogButton);

        // Configurar y mostrar el JFrame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}