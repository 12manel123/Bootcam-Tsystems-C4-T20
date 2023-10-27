package C4.T20Ex1;
import javax.swing.*;

public class VentanaEditar {
    public VentanaEditar() {
        // Crear una instancia de JFrame (ventana)
        JFrame ventana = new JFrame("Ex1 - VentanaEditar");
        
        // Configurar la operación por defecto al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear una etiqueta
        JLabel etiqueta = new JLabel("¡Hola, mundo!");
        
        // Agregar la etiqueta a la ventana
        ventana.add(etiqueta);
        
        // Ajustar el tamaño de la ventana automáticamente según el contenido
        ventana.pack();
        
        // Centrar la ventana en la pantalla
        ventana.setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
