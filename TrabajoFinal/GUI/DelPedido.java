package TrabajoFinal.GUI;

import TrabajoFinal.Libro;
import TrabajoFinal.Pedido;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DelPedido extends JFrame {
    private JTable tblPedidos;
    private JButton btnEliminar;

    public DelPedido(Pedido pedido) {
        setTitle("Lista de Pedidos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());


        ArrayList<Pedido> listapedido = pedido.getListaPedidos();
        int numPedido = listapedido.size();
        Object[][] data = new Object[numPedido][8];
        for (int i = 0; i < numPedido; i++) {
            Pedido pedido1 = listapedido.get(i);
            data[i][0] = pedido1.getId_pedido();
            data[i][1] = pedido1.getId_tienda();
            data[i][2] = pedido1.getId_cliente();
            data[i][3] = pedido1.getFecha();
            data[i][4] = pedido1.getImporteBruto();
            data[i][5] = pedido.calcularDescuento(pedido1.getImporteBruto());
            data[i][6] = pedido.calcularIGV(pedido1.getImporteBruto(),pedido.calcularDescuento(pedido1.getImporteBruto()));
            data[i][7] = pedido.calcularImporteTotal(pedido1.getImporteBruto()
                    ,pedido.calcularDescuento(pedido1.getImporteBruto()),pedido.calcularIGV(pedido1.getImporteBruto(),pedido.calcularDescuento(pedido1.getImporteBruto())));

        }


        // Nombres de las columnas
        String[] columnNames = {"ID Pedido", "ID Tienda", "ID Cliente", "Fecha del Pedido", "Monto Bruto", "IGV", "Descuento", "Importe Total"};

        // Crear el modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo de tabla
        tblPedidos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblPedidos);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ListSelectionListener para detectar el cambio de selección en la tabla
        tblPedidos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Habilitar o deshabilitar el botón Eliminar según si hay una fila seleccionada
                btnEliminar.setEnabled(tblPedidos.getSelectedRow() != -1);
            }
        });

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(DelPedido.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblPedidos.getSelectedRow();

                    int idPedido = Integer.parseInt(tblPedidos.getValueAt(selectedRow, 0).toString());
                    pedido.eliminar(idPedido,pedido.getListaPedidos());
                    // Eliminar el registro del modelo de tabla
                    tableModel.removeRow(selectedRow);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(DelPedido.this, "El registro ha sido eliminado exitosamente.");

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
