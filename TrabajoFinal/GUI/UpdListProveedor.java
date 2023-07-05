package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListProveedor extends JFrame {
    private JTable tblProveedores;

    public UpdListProveedor() {
        // Configuración básica del formulario
        setTitle("Lista de Proveedores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblProveedores = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblProveedores);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Proveedor", "Nombre Proveedor"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblProveedores.setModel(model);

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarProveedor("1", "Proveedor 1");
        agregarProveedor("2", "Proveedor 2");
        agregarProveedor("3", "Proveedor 3");

        // Agregar listener para el clic en la tabla
        tblProveedores.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblProveedores.getSelectedRow();
                if (selectedRow != -1) {
                    String idProveedor = (String) tblProveedores.getValueAt(selectedRow, 0);
                    String nombreProveedor = (String) tblProveedores.getValueAt(selectedRow, 1);

                    // Abrir la ventana de actualización
                    new UpdProveedor(idProveedor, nombreProveedor);
                }
            }
        });

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarProveedor(String idProveedor, String nombreProveedor) {
        DefaultTableModel model = (DefaultTableModel) tblProveedores.getModel();
        model.addRow(new Object[]{idProveedor, nombreProveedor});
    }

}
