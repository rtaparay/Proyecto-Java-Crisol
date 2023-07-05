package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListaUsuarioSistema extends JFrame {
    private JTable tblUsuarios;

    public ListaUsuarioSistema() {
        // Configuración básica del formulario
        setTitle("Lista de Usuarios del Sistema");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblUsuarios = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblUsuarios);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Usuario", "Nombre", "Contraseña", "Tipo Usuario", "Estado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblUsuarios.setModel(model);

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarUsuario("1", "Usuario1", "password1", "Administrador", "Activo");
        agregarUsuario("2", "Usuario2", "password2", "Empleado", "Inactivo");
        agregarUsuario("3", "Usuario3", "password3", "Visitante", "Activo");

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarUsuario(String idUsuario, String nombre, String contrasena, String tipoUsuario, String estado) {
        DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
        model.addRow(new Object[]{idUsuario, nombre, contrasena, tipoUsuario, estado});
    }

}
