package C4.T20Ex7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaPesetaEuros {
    private JTextField campoPesetas;
    private JTextField campoEuros;
    private JButton botonPesetasAEuros;
    private JButton botonEurosAPesetas;
    private JButton botonBorrar;
    private JTextArea areaResultado;
    private static final double TASA_CAMBIO = 166.386;

    public VentanaPesetaEuros() {
        // Crear una instancia de JFrame (ventana)
        JFrame ventana = new JFrame("Conversor Pesetas a Euros");

        // Crear campos de entrada para pesetas y euros
        campoPesetas = new JTextField(10);
        campoEuros = new JTextField(10);

        // Crear botones para realizar la conversión en ambas direcciones y para borrar los campos
        botonPesetasAEuros = new JButton("Pesetas a Euros");
        botonEurosAPesetas = new JButton("Euros a Pesetas");
        botonBorrar = new JButton("Borrar");

        // Agregar ActionListeners a los botones para realizar la conversión y borrar
        botonPesetasAEuros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirPesetasAEuros();
            }
        });

        botonEurosAPesetas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirEurosAPesetas();
            }
        });

        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarCampos();
            }
        });

        // Agregar KeyListeners para permitir la operación con los botones desde el teclado
        campoPesetas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    convertirPesetasAEuros();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        campoEuros.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    convertirEurosAPesetas();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        // Crear un área de texto para mostrar el resultado
        areaResultado = new JTextArea(10, 30);
        areaResultado.setEditable(false);

        // Crear un panel y agregar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Pesetas:"));
        panel.add(campoPesetas);
        panel.add(botonPesetasAEuros);
        panel.add(new JLabel("Euros:"));
        panel.add(campoEuros);
        panel.add(botonEurosAPesetas);
        panel.add(botonBorrar);

        // Agregar el panel y el área de texto a la ventana
        Container contentPane = ventana.getContentPane();
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Ajustar el tamaño de la ventana automáticamente según el contenido
        ventana.pack();

        // Centrar la ventana en la pantalla
        ventana.setLocationRelativeTo(null);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }

    private void convertirPesetasAEuros() {
        try {
            String pesetasStr = campoPesetas.getText();
            if (pesetasStr.isEmpty()) {
                mostrarMensajeError("Ingrese una cantidad en pesetas.");
                return;
            }
            
            double pesetas = Double.parseDouble(pesetasStr);
            double euros = pesetas / TASA_CAMBIO;

            campoEuros.setText(String.format("%.2f", euros));
            areaResultado.setText(String.format("%.2f pesetas equivale a %.2f euros.", pesetas, euros));
        } catch (NumberFormatException e) {
            mostrarMensajeError("Formato de número inválido en pesetas.");
        }
    }

    private void convertirEurosAPesetas() {
        try {
            String eurosStr = campoEuros.getText();
            if (eurosStr.isEmpty()) {
                mostrarMensajeError("Ingrese una cantidad en euros.");
                return;
            }
            
            double euros = Double.parseDouble(eurosStr);
            double pesetas = euros * TASA_CAMBIO;

            campoPesetas.setText(String.format("%.2f", pesetas));
            areaResultado.setText(String.format("%.2f euros equivale a %.2f pesetas.", euros, pesetas));
        } catch (NumberFormatException e) {
            mostrarMensajeError("Formato de número inválido en euros.");
        }
    }

    private void borrarCampos() {
        campoPesetas.setText("");
        campoEuros.setText("");
        areaResultado.setText("");
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
