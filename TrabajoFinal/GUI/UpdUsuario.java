package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TrabajoFinal.UsuarioSistema;
import java.util.ArrayList;
public class UpdUsuario extends JFrame {
    private JTextField txtIdUsuario;
    private JTextField txtNombre;
    private JTextField txtContrasena;
    private JTextField txtTipoUsuario;
    private JTextField txtEstado;

    public UpdUsuario(String idUsuario, String nombre, String contrasena, String tipoUsuario, String estado, UsuarioSistema user) {
        setTitle("Actualizar Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblIdUsuario = new JLabel("Id Usuario:");
        txtIdUsuario = new JTextField(idUsuario);
        txtIdUsuario.setEditable(false);
        panel.add(lblIdUsuario);
        panel.add(txtIdUsuario);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(nombre);
        panel.add(lblNombre);
        panel.add(txtNombre);

        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JTextField(contrasena);
        panel.add(lblContrasena);
        panel.add(txtContrasena);

        JLabel lblTipoUsuario = new JLabel("Tipo Usuario:");
        txtTipoUsuario = new JTextField(tipoUsuario);
        panel.add(lblTipoUsuario);
        panel.add(txtTipoUsuario);

        JLabel lblEstado = new JLabel("Estado:");
        txtEstado = new JTextField(estado);
        panel.add(lblEstado);
        panel.add(txtEstado);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(UpdUsuario.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener los valores actualizados de los campos de texto
                    String idUsuario = txtIdUsuario.getText();
                    String nombre = txtNombre.getText();
                    String contrasena = txtContrasena.getText();
                    String tipoUsuario = txtTipoUsuario.getText();
                    String estado = txtEstado.getText();

                    // Realizar la actualización en la base de datos o en la estructura de datos correspondiente
                    user.modificar(idUsuario,nombre,contrasena,tipoUsuario,estado,user.getLuser());
                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(UpdUsuario.this, "Registro actualizado exitosamente");

                    // Cerrar la ventana
                    dispose();
                }
            }
        });

        panel.add(btnActualizar);

        add(panel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
}
