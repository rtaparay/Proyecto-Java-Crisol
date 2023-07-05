package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdCliente extends JFrame {
    private JTextField txtIdCliente;
    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtRecency;
    private JTextField txtFrequency;
    private JTextField txtMonetaryValue;
    private JTextField txtRfmScore;
    private JTextField txtIdSegmento;

    public UpdCliente(String idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String recency, String frequency, String monetaryValue, String rfmScore, String idSegmento) {
        // Configuración básica del formulario
        setTitle("Actualizar Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        // Crear los componentes del formulario
        JLabel lblIdCliente = new JLabel("ID Cliente:");
        txtIdCliente = new JTextField(idCliente);
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(nombre);
        JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
        txtApellidoPaterno = new JTextField(apellidoPaterno);
        JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
        txtApellidoMaterno = new JTextField(apellidoMaterno);
        JLabel lblRecency = new JLabel("Recency:");
        txtRecency = new JTextField(recency);
        JLabel lblFrequency = new JLabel("Frequency:");
        txtFrequency = new JTextField(frequency);
        JLabel lblMonetaryValue = new JLabel("Monetary Value:");
        txtMonetaryValue = new JTextField(monetaryValue);
        JLabel lblRfmScore = new JLabel("RFM Score:");
        txtRfmScore = new JTextField(rfmScore);
        JLabel lblIdSegmento = new JLabel("ID Segmento:");
        txtIdSegmento = new JTextField(idSegmento);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes escribir el código para actualizar los datos del cliente

                // Mostrar un mensaje de confirmación
                int respuesta = JOptionPane.showConfirmDialog(UpdCliente.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Aquí puedes escribir el código para realizar la actualización del registro

                    // Cerrar la ventana de actualización
                    dispose();
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdCliente);
        add(txtIdCliente);
        add(lblNombre);
        add(txtNombre);
        add(lblApellidoPaterno);
        add(txtApellidoPaterno);
        add(lblApellidoMaterno);
        add(txtApellidoMaterno);
        add(lblRecency);
        add(txtRecency);
        add(lblFrequency);
        add(txtFrequency);
        add(lblMonetaryValue);
        add(txtMonetaryValue);
        add(lblRfmScore);
        add(txtRfmScore);
        add(lblIdSegmento);
        add(txtIdSegmento);
        add(new JLabel());
        add(btnActualizar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }


}
