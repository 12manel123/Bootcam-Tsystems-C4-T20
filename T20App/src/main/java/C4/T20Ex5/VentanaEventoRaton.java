package C4.T20Ex5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEventoRaton {
    private JTextArea areaTexto;
    private JButton botonLimpiar;

    public VentanaEventoRaton() {
        JFrame ventana = new JFrame("Ex5 - VentanaEventoRaton");
        areaTexto = new JTextArea(20, 50);
        areaTexto.setEditable(false); // Para que el usuario no pueda editar el texto

        areaTexto.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                areaTexto.append("Clic de ratón en (" + e.getX() + ", " + e.getY() + ")\n");
            }
        });

        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText(""); // Limpia el contenido del área de texto
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Eventos de Ratón:"), BorderLayout.NORTH);
        panel.add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        panel.add(botonLimpiar, BorderLayout.SOUTH);
        ventana.add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
