package TrabajoFinal.GUI;

import TrabajoFinal.UsuarioSistema;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DelUsuario extends JFrame {
    private JTable tblUsuarios;
    private JButton btnEliminar;

    public DelUsuario(UsuarioSistema user) {
        setTitle("Lista de Usuarios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Datos de ejemplo
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

        // Crear el modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo de tabla
        tblUsuarios = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblUsuarios);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ListSelectionListener para detectar el cambio de selección en la tabla
        tblUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Habilitar o deshabilitar el botón Eliminar según si hay una fila seleccionada
                btnEliminar.setEnabled(tblUsuarios.getSelectedRow() != -1);
            }
        });

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(DelUsuario.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblUsuarios.getSelectedRow()-1;

                    // Eliminar el registro del modelo de tabla
                    tableModel.removeRow(selectedRow+1);
                    String idUsuario = tblUsuarios.getValueAt(selectedRow, 0).toString();
                    user.eliminar(idUsuario,user.getLuser());
                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(DelUsuario.this, "El registro ha sido eliminado exitosamente.");

                    // Desactivar el botón Eliminar
                    btnEliminar.setEnabled(false);
                }
            }
        });

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEliminar);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
