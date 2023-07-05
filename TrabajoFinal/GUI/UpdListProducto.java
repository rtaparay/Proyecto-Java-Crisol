package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListProducto extends JFrame {
    private JTable tblProductos;

    public UpdListProducto() {
        // Configuración básica del formulario
        setTitle("Lista de Productos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblProductos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblProductos);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Producto", "Precio", "Tipo Producto", "ID Libro", "ISBN", "Título", "ID Proveedor", "Edición", "Autor", "ID Categoría"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblProductos.setModel(model);

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarProducto("1", "10.99", "Electrónico", "1", "ISBN123", "Producto 1", "1", "Primera Edición", "Autor 1", "1");
        agregarProducto("2", "19.99", "Físico", "2", "ISBN456", "Producto 2", "2", "Segunda Edición", "Autor 2", "2");
        agregarProducto("3", "15.99", "Digital", "3", "ISBN789", "Producto 3", "3", "Tercera Edición", "Autor 3", "3");

        // Agregar listener para el clic en la tabla
        tblProductos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblProductos.getSelectedRow();
                if (selectedRow != -1) {
                    String idProducto = (String) tblProductos.getValueAt(selectedRow, 0);
                    String precio = (String) tblProductos.getValueAt(selectedRow, 1);
                    String tipoProducto = (String) tblProductos.getValueAt(selectedRow, 2);
                    String idLibro = (String) tblProductos.getValueAt(selectedRow, 3);
                    String isbn = (String) tblProductos.getValueAt(selectedRow, 4);
                    String titulo = (String) tblProductos.getValueAt(selectedRow, 5);
                    String idProveedor = (String) tblProductos.getValueAt(selectedRow, 6);
                    String edicion = (String) tblProductos.getValueAt(selectedRow, 7);
                    String autor = (String) tblProductos.getValueAt(selectedRow, 8);
                    String idCategoria = (String) tblProductos.getValueAt(selectedRow, 9);

                    // Abrir la ventana de actualización
                    new UpdProducto(idProducto, precio, tipoProducto, idLibro, isbn, titulo, idProveedor, edicion, autor, idCategoria);
                }
            }
        });

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarProducto(String idProducto, String precio, String tipoProducto, String idLibro, String isbn, String titulo, String idProveedor, String edicion, String autor, String idCategoria) {
        DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
        model.addRow(new Object[]{idProducto, precio, tipoProducto, idLibro, isbn, titulo, idProveedor, edicion, autor, idCategoria});
    }

}
