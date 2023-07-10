package TrabajoFinal.GUI;

import TrabajoFinal.Libro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaLibro extends JFrame {
    private JTable tblLibros;

    public ListaLibro(ArrayList<Libro> listaLibro) {
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


        for (Libro libro : listaLibro) {
            int idProducto = libro.getId_producto();
            double precio = libro.getPrecio();
            String tipoProducto = libro.getTipoProducto();
            int idLibro = libro.getId_libro();
            String ISBN = libro.getISBN();
            String nombreTitulo = libro.getNombreTitulo();
            int idProveedor = libro.getId_proveedor();
            String edicion = libro.getEdicion();
            String autor = libro.getAutor();
            int idCategoria = libro.getId_categoria();

            agregarLibro(idProducto, precio, tipoProducto, idLibro, ISBN, nombreTitulo, idProveedor, edicion, autor, idCategoria);
        }
        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarLibro(int idProducto, double precio, String tipoProducto, int idLibro, String ISBN, String nombreTitulo, int idProveedor, String edicion, String autor, int idCategoria) {
        DefaultTableModel model = (DefaultTableModel) tblLibros.getModel();
        model.addRow(new Object[]{idProducto, precio, tipoProducto, idLibro, ISBN, nombreTitulo, idProveedor, edicion, autor, idCategoria});
    }

}
