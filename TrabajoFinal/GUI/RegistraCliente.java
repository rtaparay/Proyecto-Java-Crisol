package TrabajoFinal.GUI;

import TrabajoFinal.Cliente;

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

    public RegistraCliente(Cliente cliente) {
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
                    grabarRegistro(cliente);
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

    private void grabarRegistro(Cliente cliente) {
        int idCliente = Integer.parseInt(txtIdCliente.getText());
        String nombre = txtNombre.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        int recency = Integer.parseInt(txtRecency.getText());
        int frecuency = Integer.parseInt(txtFrecuency.getText());
        double monetaryValue = Double.parseDouble(txtMonetaryValue.getText());
        int RFM_score = Integer.parseInt(txtRFMScore.getText());
        char idSegmento = txtIdSegmento.getText().charAt(0);

        // Aquí puedes realizar la lógica de grabación del registro en la base de datos o en otro medio
        // Por ahora, solo mostraremos un mensaje con los datos ingresados
        Cliente cliente1 = new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, recency, frecuency, monetaryValue, RFM_score, idSegmento);
        cliente.registrar(cliente1,cliente.getListaClientes() );

        String mensaje = "Registro grabado:\n"
                + "ID de Cliente: " + idCliente + "\n"
                + "Nombre: " + nombre + "\n"
                + "Apellido Paterno: " + apellidoPaterno + "\n"
                + "Apellido Materno: " + apellidoMaterno + "\n"
                + "Recency: " + recency + "\n"
                + "Frecency: " + frecuency + "\n"
                + "Monetary Value: " + monetaryValue + "\n"
                + "RFM Score: " + RFM_score + "\n"
                + "ID de Segmento: " + idSegmento + "\n";
        JOptionPane.showMessageDialog(this, mensaje);
    }

}