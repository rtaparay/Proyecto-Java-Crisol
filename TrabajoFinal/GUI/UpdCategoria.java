package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdCategoria extends JFrame {
    private String idCategoria;
    private String nombreCategoria;
    private JTextField txtNombreCategoria;
    private boolean registroActualizado;

    public UpdCategoria(String idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        registroActualizado = false;

        // Configuración básica del formulario
        setTitle("Actualizar Categoría");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Creación de los componentes del formulario
        JLabel lblIdCategoria = new JLabel("ID de Categoría:");
        JTextField txtIdCategoria = new JTextField(idCategoria);
        txtIdCategoria.setEditable(false);

        JLabel lblNombreCategoria = new JLabel("Nombre de Categoría:");
        txtNombreCategoria = new JTextField(nombreCategoria);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(UpdCategoria.this, "¿Está seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    actualizarRegistro();
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdCategoria);
        add(txtIdCategoria);
        add(lblNombreCategoria);
        add(txtNombreCategoria);
        add(new JLabel());
        add(btnActualizar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(false);
    }

    public boolean isRegistroActualizado() {
        return registroActualizado;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return txtNombreCategoria.getText();
    }

    public void mostrarFormulario() {
        setVisible(true);
    }

    private void actualizarRegistro() {
        // Aquí puedes realizar la lógica de actualización del registro en la base de datos o en otro medio
        // Por ahora, solo mostraremos un mensaje con los datos ingresados
        String mensaje = "Registro actualizado:\n"
                + "ID de Categoría: " + idCategoria + "\n"
                + "Nombre de Categoría: " + getNombreCategoria() + "\n";
        JOptionPane.showMessageDialog(this, mensaje);

        // Actualizar el estado de actualización
        registroActualizado = true;

        // Cerrar el formulario
        dispose();
    }
}
