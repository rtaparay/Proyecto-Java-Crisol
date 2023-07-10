package TrabajoFinal.GUI;

import TrabajoFinal.Libro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraLibro extends JFrame {
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

    public RegistraLibro(Libro libro) {
        // Configuración básica del formulario
        setTitle("Registro de Libro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(11, 2));

        // Creación de los componentes del formulario
        JLabel lblIdProducto = new JLabel("ID de Producto:");
        txtIdProducto = new JTextField();

        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField();

        JLabel lblTipoProducto = new JLabel("Tipo de Producto:");
        txtTipoProducto = new JTextField();

        JLabel lblIdLibro = new JLabel("ID de Libro:");
        txtIdLibro = new JTextField();

        JLabel lblISBN = new JLabel("ISBN:");
        txtISBN = new JTextField();

        JLabel lblTitulo = new JLabel("Título:");
        txtTitulo = new JTextField();

        JLabel lblIdProveedor = new JLabel("ID de Proveedor:");
        txtIdProveedor = new JTextField();

        JLabel lblEdicion = new JLabel("Edición:");
        txtEdicion = new JTextField();

        JLabel lblAutor = new JLabel("Autor:");
        txtAutor = new JTextField();

        JLabel lblIdCategoria = new JLabel("ID de Categoría:");
        txtIdCategoria = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraLibro.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    grabarRegistro(libro);
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
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro(Libro libro) {
        int idProducto = Integer.parseInt(txtIdProducto.getText());
        double precio = Double.parseDouble(txtPrecio.getText());
        String tipoProducto = txtTipoProducto.getText();
        int idLibro = Integer.parseInt(txtIdLibro.getText());
        String ISBN = txtISBN.getText();
        String nombreTitulo = txtTitulo.getText();
        int idProveedor = Integer.parseInt(txtIdProveedor.getText());
        String edicion = txtEdicion.getText();
        String autor = txtAutor.getText();
        int idCategoria = Integer.parseInt(txtIdCategoria.getText());

        // Aquí puedes realizar la lógica de grabación del registro en la base de datos o en otro medio
        // Por ahora, solo mostraremos un mensaje con los datos ingresados
        Libro libro1 = new Libro(idProducto, precio, tipoProducto, idLibro, ISBN, nombreTitulo, idProveedor, edicion, autor, idCategoria);
        libro.registrar(libro1, libro.getListaLibro());

        String mensaje = "Registro grabado:\n"
                + "ID de Producto: " + idProducto + "\n"
                + "Precio: " + precio + "\n"
                + "Tipo de Producto: " + tipoProducto + "\n"
                + "ID de Libro: " + idLibro + "\n"
                + "ISBN: " + ISBN + "\n"
                + "Nombre del Título: " + nombreTitulo + "\n"
                + "ID de Proveedor: " + idProveedor + "\n"
                + "Edición: " + edicion + "\n"
                + "Autor: " + autor + "\n"
                + "ID de Categoría: " + idCategoria + "\n";
        JOptionPane.showMessageDialog(this, mensaje);
    }



}
