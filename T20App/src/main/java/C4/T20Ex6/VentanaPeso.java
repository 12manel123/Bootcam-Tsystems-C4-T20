package C4.T20Ex6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPeso {
    private JTextField campoPeso;
    private JTextField campoAltura;
    private JButton botonCalcular;
    private JTextArea areaResultado;

    public VentanaPeso() {
        JFrame ventana = new JFrame("Calculadora de IMC");
        campoPeso = new JTextField(10);
        campoAltura = new JTextField(10);
        botonCalcular = new JButton("Calcular IMC");

        botonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        areaResultado = new JTextArea(10, 30);
        areaResultado.setEditable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Peso (kg):"));
        panel.add(campoPeso);
        panel.add(new JLabel("Altura (m):"));
        panel.add(campoAltura);
        panel.add(botonCalcular);
        Container contentPane = ventana.getContentPane();
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(campoPeso.getText());
            double altura = Double.parseDouble(campoAltura.getText());
            double imc = peso/( altura * altura);
            areaResultado.setText("Su IMC es: " + imc + "\n");

            if (imc < 18.5) {areaResultado.append("Bajo peso");} 
            else if (imc < 25) {areaResultado.append("Peso normal");} 
            else if (imc < 30) {areaResultado.append("Sobrepeso");} 
            else {areaResultado.append("Obesidad");}
        } 
        catch (NumberFormatException e) {areaResultado.setText("Por favor, ingrese valores válidos para peso y altura.");}
    }
}
