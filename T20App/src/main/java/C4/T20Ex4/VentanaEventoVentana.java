package C4.T20Ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaEventoVentana {
    private JTextArea areaTexto;

    public VentanaEventoVentana() {
        JFrame ventana = new JFrame("Ex4 - VentanaEventoVentana");
        areaTexto = new JTextArea(20, 50);
        areaTexto.setEditable(false); // Para que el usuario no pueda editar el texto
        
        ventana.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
                areaTexto.append("Ventana abierta\n");
            }

            public void windowClosing(WindowEvent e) {
                areaTexto.append("Ventana cerrandose\n");
            }

            public void windowClosed(WindowEvent e) {
                areaTexto.append("Ventana cerrada\n");
            }

            public void windowIconified(WindowEvent e) {
                areaTexto.append("Ventana minimizada\n");
            }

            public void windowDeiconified(WindowEvent e) {
                areaTexto.append("Ventana restaurada\n");
            }

            public void windowActivated(WindowEvent e) {
                areaTexto.append("Ventana activada\n");
            }

            public void windowDeactivated(WindowEvent e) {
                areaTexto.append("Ventana desactivada\n");
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Eventos de Ventana:"), BorderLayout.NORTH);
        panel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        ventana.add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
