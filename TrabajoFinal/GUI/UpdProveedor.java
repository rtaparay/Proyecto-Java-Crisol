package TrabajoFinal.GUI;

import TrabajoFinal.Proveedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdProveedor extends JFrame {
    private JTextField txtIdProveedor;
    private JTextField txtNombreProveedor;

    public UpdProveedor(int idProveedor, String nombreProveedor, Proveedor proveedor) {
        // Configuración básica del formulario
        setTitle("Actualizar Proveedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Crear los componentes del formulario
        JLabel lblIdProveedor = new JLabel("ID Proveedor:");
        txtIdProveedor = new JTextField(String.valueOf(idProveedor));
        JLabel lblNombreProveedor = new JLabel("Nombre Proveedor:");
        txtNombreProveedor = new JTextField(nombreProveedor);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                // Mostrar un mensaje de confirmación
                int respuesta = JOptionPane.showConfirmDialog(UpdProveedor.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    int idProveedor = Integer.parseInt(txtIdProveedor.getText());
                    String nombreProveedor = txtNombreProveedor.getText();
                    proveedor.modificar(idProveedor,nombreProveedor,proveedor.getProveedores());
                    // Cerrar la ventana de actualización
                    dispose();
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdProveedor);
        add(txtIdProveedor);
        add(lblNombreProveedor);
        add(txtNombreProveedor);
        add(new JLabel());
        add(btnActualizar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

}
