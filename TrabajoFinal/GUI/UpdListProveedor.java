package TrabajoFinal.GUI;

import TrabajoFinal.Libro;
import TrabajoFinal.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdListProveedor extends JFrame {
    private JTable tblProveedores;

    public UpdListProveedor(Proveedor proveedor) {
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

        ArrayList<Proveedor> listaProveedor = new ArrayList<>();
        listaProveedor = proveedor.getProveedores();
        int numLibros = listaProveedor.size();
        Object[][] data = new Object[numLibros][10];
        for (int i = 0; i < numLibros; i++) {
            Proveedor prov1 = listaProveedor.get(i);
            data[i][0] = prov1.getId_proveedor();
            data[i][1] = prov1.getNombreProveedor();
            agregarProveedor(prov1.getId_proveedor(),prov1.getNombreProveedor());
        }
        // Agregar listener para el clic en la tabla
        tblProveedores.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblProveedores.getSelectedRow();
                if (selectedRow != -1) {
                    int idProveedor = (int) tblProveedores.getValueAt(selectedRow, 0);
                    String nombreProveedor = (String) tblProveedores.getValueAt(selectedRow, 1);

                    // Abrir la ventana de actualización
                    new UpdProveedor(idProveedor, nombreProveedor,proveedor);
                }
            }
        });

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarProveedor(int idProveedor, String nombreProveedor) {
        DefaultTableModel model = (DefaultTableModel) tblProveedores.getModel();
        model.addRow(new Object[]{idProveedor, nombreProveedor});
    }

}
