package C4.T20Ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBotones {
    private JLabel etiqueta;
    private JButton boton1;
    private JButton boton2;

    public VentanaBotones() {
        JFrame ventana = new JFrame("Ex2 - VentanaBotones");

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        etiqueta = new JLabel("Ningun boton presionado");

        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("Ultimo clic: Boton 1");
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                etiqueta.setText("Ultimo clic: Boton 2");
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(etiqueta);
        panel.add(boton1);
        panel.add(boton2);
        ventana.add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}