package C4.T20Ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaContador {
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JButton boton1;
    private JButton boton2;
    private int contadorBoton1 = 0;
    private int contadorBoton2 = 0;

    public VentanaContador() {
        JFrame ventana = new JFrame("Ex3 - VentanaContador");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        etiqueta1 = new JLabel("Clics en Boton 1: 0");
        etiqueta2 = new JLabel("Clics en Boton 2: 0");
        boton1 = new JButton("Boton 1");
        boton2 = new JButton("Boton 2");

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contadorBoton1++;
                etiqueta1.setText("Clics en Boton 1: " + contadorBoton1);
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contadorBoton2++;
                etiqueta2.setText("Clics en Boton 2: " + contadorBoton2);
            }
        });
        

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        etiqueta1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        etiqueta2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(boton1);
        panel.add(boton2);
        
        ventana.add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
