package TrabajoFinal.GUI;

import TrabajoFinal.Libro;
import TrabajoFinal.Proveedor;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DelProveedor extends JFrame {
    private JTable tblProveedores;
    private JButton btnEliminar;

    public DelProveedor(Proveedor proveedor) {
        setTitle("Lista de Proveedores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        ArrayList<Proveedor> listaProveedores = proveedor.getProveedores();
        int numProveedores = listaProveedores.size();
        Object[][] data = new Object[numProveedores][2];
        // Datos de ejemplo
        for (int i = 0; i < numProveedores; i++) {
            Proveedor prov1 = listaProveedores.get(i);
            data[i][0] = prov1.getId_proveedor();
            data[i][1] = prov1.getNombreProveedor();
        }
        // Nombres de las columnas
        String[] columnNames = {"Id Proveedor", "Nombre Proveedor"};

        // Crear el modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo de tabla
        tblProveedores = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblProveedores);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ListSelectionListener para detectar el cambio de selección en la tabla
        tblProveedores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Habilitar o deshabilitar el botón Eliminar según si hay una fila seleccionada
                btnEliminar.setEnabled(tblProveedores.getSelectedRow() != -1);
            }
        });

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(DelProveedor.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblProveedores.getSelectedRow();
                    int idProducto = Integer.parseInt(tblProveedores.getValueAt(selectedRow, 0).toString());
                    proveedor.eliminar(idProducto, proveedor.getProveedores());
                    // Eliminar el registro del modelo de tabla
                    tableModel.removeRow(selectedRow);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(DelProveedor.this, "El registro ha sido eliminado exitosamente.");

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
