package TrabajoFinal.GUI;

import TrabajoFinal.Libro;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListProducto extends JFrame {
    private JTable tblProductos;

    public UpdListProducto(Libro libro) {
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

        ArrayList<Libro> listaLibros = new ArrayList<>();
        listaLibros = libro.getListaLibro();
        int numLibros = listaLibros.size();
        Object[][] data = new Object[numLibros][10];
        for (int i = 0; i < numLibros; i++) {
            Libro libro1 = listaLibros.get(i);
            data[i][0] = libro1.getId_producto();
            data[i][1] = libro1.getPrecio();
            data[i][2] = libro1.getTipoProducto();
            data[i][3] = libro1.getId_libro();
            data[i][4] = libro1.getISBN();
            data[i][5] = libro1.getNombreTitulo();
            data[i][6] = libro1.getId_proveedor();
            data[i][7] = libro1.getEdicion();
            data[i][8] = libro1.getAutor();
            data[i][9] = libro1.getId_categoria();
            agregarProducto(libro1.getId_producto(), libro1.getPrecio(), libro1.getTipoProducto(), libro1.getId_libro(), libro1.getISBN(), libro1.getNombreTitulo(), libro1.getId_proveedor(), libro1.getEdicion(), libro1.getAutor(), libro1.getId_categoria());
        }
        // Agregar listener para el clic en la tabla
        tblProductos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblProductos.getSelectedRow();
                if (selectedRow != -1) {
                    int idProducto = (int) tblProductos.getValueAt(selectedRow, 0);
                    double precio = (double) tblProductos.getValueAt(selectedRow, 1);
                    String tipoProducto = (String) tblProductos.getValueAt(selectedRow, 2);
                    int idLibro = (int) tblProductos.getValueAt(selectedRow, 3);
                    String ISBN = (String) tblProductos.getValueAt(selectedRow, 4);
                    String nombreTitulo = (String) tblProductos.getValueAt(selectedRow, 5);
                    int idProveedor = (int) tblProductos.getValueAt(selectedRow, 6);
                    String edicion = (String) tblProductos.getValueAt(selectedRow, 7);
                    String autor = (String) tblProductos.getValueAt(selectedRow, 8);
                    int idCategoria = (int) tblProductos.getValueAt(selectedRow, 9);

                    // Abrir la ventana de actualización
                    new UpdProducto(idProducto, precio, tipoProducto, idLibro, ISBN, nombreTitulo, idProveedor, edicion, autor, idCategoria, libro);
                }
            }
        });

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarProducto(int id_producto, double precio, String tipoProducto, int id_libro, String ISBN, String NombreTitulo, int id_proveedor, String edicion, String autor, int id_categoria) {
        DefaultTableModel model = (DefaultTableModel) tblProductos.getModel();
        model.addRow(new Object[]{id_producto, precio, tipoProducto, id_libro, ISBN, NombreTitulo, id_proveedor, edicion, autor, id_categoria});
    }

}
