package TrabajoFinal.GUI;

import TrabajoFinal.UsuarioSistema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;

public class ListaUsuarioSistema extends JFrame {
    private JTable tblUsuarios;

    public ListaUsuarioSistema(ArrayList<UsuarioSistema> luser) {
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

        //UsuarioSistema user = new UsuarioSistema("","","","","");
        //ArrayList<UsuarioSistema> luser = new ArrayList<UsuarioSistema>();
        //ArrayList<UsuarioSistema> luser1 = new ArrayList<UsuarioSistema>();
        //Carga inicial con datos ficticios
        //luser1 = user.cargaInicial(luser);
        // Llenar la tabla que se mostrara en el formulario
        for (UsuarioSistema usuario : luser) {
            String idUsuario = usuario.getId_usuario();
            String nombre = usuario.getNombre();
            String password = usuario.getPassword();
            String tipoUsuario = usuario.getTipoUsuario();
            String estado = usuario.getEstado();
            agregarUsuario(idUsuario, nombre, password, tipoUsuario, estado);
        }

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarUsuario(String idUsuario, String nombre, String contrasena, String tipoUsuario, String estado) {
        DefaultTableModel model = (DefaultTableModel) tblUsuarios.getModel();
        model.addRow(new Object[]{idUsuario, nombre, contrasena, tipoUsuario, estado});
    }

}
