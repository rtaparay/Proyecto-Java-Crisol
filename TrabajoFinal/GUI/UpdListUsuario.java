package TrabajoFinal.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListUsuario extends JFrame {
    private JTable tblUsuarios;

    public UpdListUsuario() {
        setTitle("Lista de Usuarios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Datos de ejemplo
        Object[][] data = {
                {"1", "John Doe", "123456", "Admin", "Activo"},
                {"2", "Jane Smith", "qwerty", "Usuario", "Inactivo"},
                {"3", "Michael Johnson", "password", "Usuario", "Activo"},
                {"4", "Emily Davis", "abcdef", "Admin", "Inactivo"},
                {"5", "Robert Wilson", "987654", "Usuario", "Activo"},
                {"6", "Jessica Brown", "secret", "Admin", "Inactivo"},
                {"7", "David Lee", "letmein", "Usuario", "Activo"},
                {"8", "Jennifer Clark", "pass123", "Admin", "Inactivo"},
                {"9", "Daniel Thomas", "iloveyou", "Usuario", "Activo"},
                {"10", "Sarah Anderson", "hello", "Admin", "Inactivo"}
        };

        // Nombres de las columnas
        String[] columnNames = {"Id Usuario", "Nombre", "Contraseña", "Tipo Usuario", "Estado"};

        // Crear la tabla con los datos y los nombres de las columnas
        tblUsuarios = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tblUsuarios);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ActionListener para el evento de hacer clic en un registro
        tblUsuarios.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tblUsuarios.getSelectedRow();
            if (selectedRow != -1) {
                String idUsuario = tblUsuarios.getValueAt(selectedRow, 0).toString();
                String nombre = tblUsuarios.getValueAt(selectedRow, 1).toString();
                String contrasena = tblUsuarios.getValueAt(selectedRow, 2).toString();
                String tipoUsuario = tblUsuarios.getValueAt(selectedRow, 3).toString();
                String estado = tblUsuarios.getValueAt(selectedRow, 4).toString();

                // Abrir la ventana UpdUsuario con los datos del registro seleccionado
                UpdUsuario updUsuario = new UpdUsuario(idUsuario, nombre, contrasena, tipoUsuario, estado);
                updUsuario.setVisible(true);
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
