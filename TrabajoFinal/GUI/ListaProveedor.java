package TrabajoFinal.GUI;

import TrabajoFinal.Libro;
import TrabajoFinal.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaProveedor extends JFrame {
    private JTable tblProveedores;

    public ListaProveedor(ArrayList<Proveedor> listaProveedor) {
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

        for (Proveedor prov : listaProveedor) {
            int idProveedor = prov.getId_proveedor();
            String nombreProveedor = prov.getNombreProveedor();
            agregarProveedor(idProveedor,nombreProveedor);
        }
        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarProveedor(int idProveedor, String nombreProveedor) {
        DefaultTableModel model = (DefaultTableModel) tblProveedores.getModel();
        model.addRow(new Object[]{idProveedor, nombreProveedor});
    }

}
