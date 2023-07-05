package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraCategoria extends JFrame {
    private JTextField txtIdCategoria;
    private JTextField txtNombreCategoria;

    public RegistraCategoria() {
        // Configuración básica del formulario
        setTitle("Registro de Categoría");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Creación de los componentes del formulario
        JLabel lblIdCategoria = new JLabel("ID Categoría:");
        txtIdCategoria = new JTextField();

        JLabel lblNombreCategoria = new JLabel("Nombre de Categoría:");
        txtNombreCategoria = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraCategoria.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    grabarRegistro();
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdCategoria);
        add(txtIdCategoria);
        add(lblNombreCategoria);
        add(txtNombreCategoria);
        add(new JLabel());
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro() {
        String idCategoria = txtIdCategoria.getText();
        String nombreCategoria = txtNombreCategoria.getText();

        // Aquí puedes realizar la lógica para grabar el registro en tu base de datos o en algún otro medio de almacenamiento
        // Por ahora, simplemente mostraremos un mensaje con los datos ingresados
        JOptionPane.showMessageDialog(this, "Registro grabado:\nID Categoría: " + idCategoria + "\nNombre de Categoría: " + nombreCategoria);
    }


}
