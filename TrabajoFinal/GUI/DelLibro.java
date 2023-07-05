package TrabajoFinal.GUI;

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

    public DelLibro() {
        setTitle("Lista de Libros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Datos de ejemplo
        Object[][] data = {
                {"1", "10.00", "Ficción", "1", "1234567890", "Libro A", "1", "1ra Edición", "Autor A", "1"},
                {"2", "15.00", "No Ficción", "2", "0987654321", "Libro B", "2", "2da Edición", "Autor B", "2"},
                {"3", "20.00", "Ficción", "3", "9876543210", "Libro C", "3", "3ra Edición", "Autor C", "3"},
                {"4", "25.00", "No Ficción", "4", "5678901234", "Libro D", "4", "4ta Edición", "Autor D", "4"},
                {"5", "30.00", "Ficción", "5", "4321098765", "Libro E", "5", "5ta Edición", "Autor E", "5"}
        };

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
                    tableModel.removeRow(selectedRow);

                    // Mostrar mensaje de éxito
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
