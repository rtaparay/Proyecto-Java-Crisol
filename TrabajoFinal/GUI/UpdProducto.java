package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdProducto extends JFrame {
    private JTextField txtIdProducto;
    private JTextField txtPrecio;
    private JTextField txtTipoProducto;
    private JTextField txtIdLibro;
    private JTextField txtISBN;
    private JTextField txtTitulo;
    private JTextField txtIdProveedor;
    private JTextField txtEdicion;
    private JTextField txtAutor;
    private JTextField txtIdCategoria;

    public UpdProducto(String idProducto, String precio, String tipoProducto, String idLibro, String isbn, String titulo, String idProveedor, String edicion, String autor, String idCategoria) {
        // Configuración básica del formulario
        setTitle("Actualizar Producto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(11, 2));

        // Crear los componentes del formulario
        JLabel lblIdProducto = new JLabel("ID Producto:");
        txtIdProducto = new JTextField(idProducto);
        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField(precio);
        JLabel lblTipoProducto = new JLabel("Tipo Producto:");
        txtTipoProducto = new JTextField(tipoProducto);
        JLabel lblIdLibro = new JLabel("ID Libro:");
        txtIdLibro = new JTextField(idLibro);
        JLabel lblISBN = new JLabel("ISBN:");
        txtISBN = new JTextField(isbn);
        JLabel lblTitulo = new JLabel("Título:");
        txtTitulo = new JTextField(titulo);
        JLabel lblIdProveedor = new JLabel("ID Proveedor:");
        txtIdProveedor = new JTextField(idProveedor);
        JLabel lblEdicion = new JLabel("Edición:");
        txtEdicion = new JTextField(edicion);
        JLabel lblAutor = new JLabel("Autor:");
        txtAutor = new JTextField(autor);
        JLabel lblIdCategoria = new JLabel("ID Categoría:");
        txtIdCategoria = new JTextField(idCategoria);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes escribir el código para actualizar los datos del producto

                // Mostrar un mensaje de confirmación
                int respuesta = JOptionPane.showConfirmDialog(UpdProducto.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Aquí puedes escribir el código para realizar la actualización del registro

                    // Cerrar la ventana de actualización
                    dispose();
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdProducto);
        add(txtIdProducto);
        add(lblPrecio);
        add(txtPrecio);
        add(lblTipoProducto);
        add(txtTipoProducto);
        add(lblIdLibro);
        add(txtIdLibro);
        add(lblISBN);
        add(txtISBN);
        add(lblTitulo);
        add(txtTitulo);
        add(lblIdProveedor);
        add(txtIdProveedor);
        add(lblEdicion);
        add(txtEdicion);
        add(lblAutor);
        add(txtAutor);
        add(lblIdCategoria);
        add(txtIdCategoria);
        add(new JLabel());
        add(btnActualizar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }
}
