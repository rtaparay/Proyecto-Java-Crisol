package TrabajoFinal.GUI;

import TrabajoFinal.Libro;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelLibro extends JFrame {
    private JTable tblLibros;
    private JButton btnEliminar;

    public DelLibro(Libro libro) {
        setTitle("Lista de Libros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        ArrayList<Libro> listaLibros = libro.getListaLibro();
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
        }


        // Nombres de las columnas
        String[] columnNames = {"Id de Producto", "Precio", "Tipo de Producto", "Id de Libro", "ISBN", "Título",
                "Id Proveedor", "Edición", "Autor", "Id Categoría"};

        // Crear el modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo de tabla
        tblLibros = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblLibros);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ListSelectionListener para detectar el cambio de selección en la tabla
        tblLibros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Habilitar o deshabilitar el botón Eliminar según si hay una fila seleccionada
                btnEliminar.setEnabled(tblLibros.getSelectedRow() != -1);
            }
        });

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(DelLibro.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblLibros.getSelectedRow();

                    // Eliminar el registro del modelo de tabla

                    int idProducto = Integer.parseInt(tblLibros.getValueAt(selectedRow, 0).toString());
                    libro.eliminar(idProducto, libro.getListaLibro());
                    // Mostrar mensaje de éxito
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(DelLibro.this, "El registro ha sido eliminado exitosamente.");

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
