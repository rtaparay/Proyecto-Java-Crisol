package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaLibro extends JFrame {
    private JTable tblLibros;

    public ListaLibro() {
        // Configuración básica del formulario
        setTitle("Lista de Libros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblLibros = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblLibros);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Producto", "Precio", "Tipo de Producto", "ID Libro", "ISBN", "Título", "ID Proveedor", "Edición", "Autor", "ID Categoría"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblLibros.setModel(model);

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarLibro("1", "29.99", "Libro", "001", "978-1234567890", "Libro de ejemplo", "1", "1ra edición", "Autor de ejemplo", "1");
        agregarLibro("2", "19.99", "Libro", "002", "978-0987654321", "Otro libro de ejemplo", "2", "2da edición", "Otro autor de ejemplo", "2");
        agregarLibro("3", "24.99", "Libro", "003", "978-9876543210", "Más libros de ejemplo", "1", "3ra edición", "Autor desconocido", "3");

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarLibro(String idProducto, String precio, String tipoProducto, String idLibro, String isbn, String titulo, String idProveedor, String edicion, String autor, String idCategoria) {
        DefaultTableModel model = (DefaultTableModel) tblLibros.getModel();
        model.addRow(new Object[]{idProducto, precio, tipoProducto, idLibro, isbn, titulo, idProveedor, edicion, autor, idCategoria});
    }

}
