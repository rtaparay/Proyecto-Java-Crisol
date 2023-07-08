package TrabajoFinal.GUI;
import TrabajoFinal.UsuarioSistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class UpdListUsuario extends JFrame {
    private JTable tblUsuarios;
    private JScrollPane scrollPane;

    public UpdListUsuario(UsuarioSistema user) {
        setTitle("Lista de Usuarios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        ArrayList<UsuarioSistema> luser = new ArrayList<>();
        luser = user.getLuser();
        int numUsuarios = luser.size();
        Object[][] data = new Object[numUsuarios][5];
        for (int i = 0; i < numUsuarios; i++) {
            UsuarioSistema usuario = luser.get(i);
            data[i][0] = usuario.getId_usuario();
            data[i][1] = usuario.getNombre();
            data[i][2] = usuario.getPassword();
            data[i][3] = usuario.getTipoUsuario();
            data[i][4] = usuario.getEstado();
        }


        // Nombres de las columnas
        String[] columnNames = {"Id Usuario", "Nombre", "Contraseña", "Tipo Usuario", "Estado"};

        // Crear la tabla con los datos y los nombres de las columnas
        tblUsuarios = new JTable(data, columnNames);
        scrollPane = new JScrollPane(tblUsuarios);
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
                UpdUsuario updUsuario = new UpdUsuario(idUsuario, nombre, contrasena, tipoUsuario, estado,user);
                updUsuario.setVisible(true);

            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
