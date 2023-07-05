package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraProveedor extends JFrame {
    private JTextField txtIdProveedor;
    private JTextField txtNombreProveedor;

    public RegistraProveedor() {
        // Configuración básica del formulario
        setTitle("Registro de Proveedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Creación de los componentes del formulario
        JLabel lblIdProveedor = new JLabel("ID de Proveedor:");
        txtIdProveedor = new JTextField();

        JLabel lblNombreProveedor = new JLabel("Nombre de Proveedor:");
        txtNombreProveedor = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraProveedor.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    grabarRegistro();
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdProveedor);
        add(txtIdProveedor);
        add(lblNombreProveedor);
        add(txtNombreProveedor);
        add(new JLabel());
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro() {
        String idProveedor = txtIdProveedor.getText();
        String nombreProveedor = txtNombreProveedor.getText();

        // Aquí puedes realizar la lógica para grabar el registro en tu base de datos o en algún otro medio de almacenamiento
        // Por ahora, simplemente mostraremos un mensaje con los datos ingresados
        String mensaje = "Registro grabado:\n"
                + "ID de Proveedor: " + idProveedor + "\n"
                + "Nombre de Proveedor: " + nombreProveedor;
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
