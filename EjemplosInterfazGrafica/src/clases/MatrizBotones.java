package clases;

import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MatrizBotones {
    public static void main(String[] args) {
        // Ejecutar el código en el Event Dispatch Thread para asegurar la correcta ejecución de Swing
        SwingUtilities.invokeLater(() -> {
            // Crear una instancia de la ventana con la matriz de botones
            FormMatriz ventana = new FormMatriz();
            
            // Obtener las dimensiones de la pantalla
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            
            // Posicionar la ventana en el centro de la pantalla
            ventana.setLocation(pantalla.width / 2 - ventana.getSize().width / 2, pantalla.height / 2 - ventana.getSize().height / 2);
            
            // Mostrar la ventana
            ventana.setVisible(true);
        });
    }
}
