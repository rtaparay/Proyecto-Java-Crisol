package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelCliente extends JFrame {
    private JTable tblClientes;
    private JButton btnEliminar;

    public DelCliente() {
        setTitle("Lista de Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Datos de ejemplo
        Object[][] data = {
                {"1", "Juan", "Perez", "Lopez", "5", "10", "100", "A", "1"},
                {"2", "Maria", "Gomez", "Rodriguez", "3", "8", "200", "B", "2"},
                {"3", "Carlos", "Lopez", "Hernandez", "4", "12", "150", "A", "1"},
                {"4", "Laura", "Torres", "Perez", "2", "6", "120", "C", "3"},
                {"5", "Pedro", "Fernandez", "Gonzalez", "1", "3", "50", "D", "4"}
        };

        // Nombres de las columnas
        String[] columnNames = {"Id Cliente", "Nombre", "Apellido Paterno", "Apellido Materno", "Recency", "Frequency",
                "Monetary Value", "RFM Score", "Id Segmento"};

        // Crear el modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo de tabla
        tblClientes = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblClientes);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ListSelectionListener para detectar el cambio de selección en la tabla
        tblClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Habilitar o deshabilitar el botón Eliminar según si hay una fila seleccionada
                btnEliminar.setEnabled(tblClientes.getSelectedRow() != -1);
            }
        });

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(DelCliente.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblClientes.getSelectedRow();

                    // Eliminar el registro del modelo de tabla
                    tableModel.removeRow(selectedRow);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(DelCliente.this, "Registro eliminado exitosamente");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEliminar);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
