package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraCliente extends JFrame {
    private JTextField txtIdCliente;
    private JTextField txtNombre;
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtRecency;
    private JTextField txtFrecuency;
    private JTextField txtMonetaryValue;
    private JTextField txtRFMScore;
    private JTextField txtIdSegmento;

    public RegistraCliente() {
        // Configuración básica del formulario
        setTitle("Registro de Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        // Creación de los componentes del formulario
        JLabel lblIdCliente = new JLabel("ID Cliente:");
        txtIdCliente = new JTextField();

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();

        JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
        txtApellidoPaterno = new JTextField();

        JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
        txtApellidoMaterno = new JTextField();

        JLabel lblRecency = new JLabel("Recency:");
        txtRecency = new JTextField();

        JLabel lblFrecuency = new JLabel("Frecuency:");
        txtFrecuency = new JTextField();

        JLabel lblMonetaryValue = new JLabel("Monetary Value:");
        txtMonetaryValue = new JTextField();

        JLabel lblRFMScore = new JLabel("RFM Score:");
        txtRFMScore = new JTextField();

        JLabel lblIdSegmento = new JLabel("ID Segmento:");
        txtIdSegmento = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraCliente.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    grabarRegistro();
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
        add(lblFrecuency);
        add(txtFrecuency);
        add(lblMonetaryValue);
        add(txtMonetaryValue);
        add(lblRFMScore);
        add(txtRFMScore);
        add(lblIdSegmento);
        add(txtIdSegmento);
        add(new JLabel());
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro() {
        String idCliente = txtIdCliente.getText();
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        String recency = txtRecency.getText();
        String frecuency = txtFrecuency.getText();
        String monetaryValue = txtMonetaryValue.getText();
        String rfmScore = txtRFMScore.getText();
        String idSegmento = txtIdSegmento.getText();

        // Aquí puedes realizar la lógica para grabar el registro en tu base de datos o en algún otro medio de almacenamiento
        // Por ahora, simplemente mostraremos un mensaje con los datos ingresados
        String mensaje = "Registro grabado:\n"
                + "ID Cliente: " + idCliente + "\n"
                + "Nombre: " + nombre + "\n"
                + "Apellido Paterno: " + apellidoPaterno + "\n"
                + "Apellido Materno: " + apellidoMaterno + "\n"
                + "Recency: " + recency + "\n"
                + "Frecuency: " + frecuency + "\n"
                + "Monetary Value: " + monetaryValue + "\n"
                + "RFM Score: " + rfmScore + "\n"
                + "ID Segmento: " + idSegmento;
        JOptionPane.showMessageDialog(this, mensaje);
    }
}