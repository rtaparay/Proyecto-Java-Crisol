package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TrabajoFinal.UsuarioSistema;

public class RegistraUsuarioSistema extends JFrame {
    private JTextField txtIdUsuario;
    private JTextField txtNombre;
    private JPasswordField txtContrasena;
    private JTextField txtTipoUsuario;
    private JTextField txtEstado;

    public RegistraUsuarioSistema(UsuarioSistema user) {

        // Configuración básica del formulario
        setTitle("Registro de Usuario del Sistema");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Creación de los componentes del formulario
        JLabel lblIdUsuario = new JLabel("ID de Usuario:");
        txtIdUsuario = new JTextField();

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();

        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField();

        JLabel lblTipoUsuario = new JLabel("Tipo de Usuario:");
        txtTipoUsuario = new JTextField();

        JLabel lblEstado = new JLabel("Estado:");
        txtEstado = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraUsuarioSistema.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    grabarRegistro(user);
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdUsuario);
        add(txtIdUsuario);
        add(lblNombre);
        add(txtNombre);
        add(lblContrasena);
        add(txtContrasena);
        add(lblTipoUsuario);
        add(txtTipoUsuario);
        add(lblEstado);
        add(txtEstado);
        add(new JLabel());
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro(UsuarioSistema user) {
        String idUsuario = txtIdUsuario.getText();
        String nombre = txtNombre.getText();
        String contrasena = new String(txtContrasena.getPassword());
        String tipoUsuario = txtTipoUsuario.getText();
        String estado = txtEstado.getText();
        UsuarioSistema us = new UsuarioSistema("","","","","");
        // Aquí puedes realizar la lógica de grabación del registro en la base de datos o en otro medio
        // Por ahora, solo mostraremos un mensaje con los datos ingresados
        us.setId_usuario(idUsuario);
        us.setNombre(nombre);
        us.setPassword(contrasena);
        us.setTipoUsuario(tipoUsuario);
        us.setEstado(estado);
        user.registrar(us,user.getLuser());

        String mensaje = "Registro grabado:\n"
                + "ID de Usuario: " + idUsuario + "\n"
                + "Nombre: " + nombre + "\n"
                + "Contraseña: " + contrasena + "\n"
                + "Tipo de Usuario: " + tipoUsuario + "\n"
                + "Estado: " + estado + "\n";
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
