package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import TrabajoFinal.Cliente;
public class DelCliente extends JFrame {
    private JTable tblClientes;
    private JButton btnEliminar;

    public DelCliente(Cliente cliente) {
        setTitle("Lista de Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        ArrayList<Cliente> listaClientes = cliente.getListaClientes();
        int numClientes = listaClientes.size();
        Object[][] data = new Object[numClientes][9];
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente1 = listaClientes.get(i);
            data[i][0] = cliente1.getId_cliente();
            data[i][1] = cliente1.getNombre();
            data[i][2] = cliente1.getApellidoPaterno();
            data[i][3] = cliente1.getApellidoMaterno();
            data[i][4] = cliente1.getRecency();
            data[i][5] = cliente1.getFrecuency();
            data[i][6] = cliente1.getMonetaryValue();
            data[i][7] = cliente1.getRFM_score();
            data[i][8] = cliente1.getId_segmento();
        }
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
                    int idCliente = Integer.parseInt(tblClientes.getValueAt(selectedRow, 0).toString());
                    cliente.eliminar(idCliente,cliente.getListaClientes());
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
