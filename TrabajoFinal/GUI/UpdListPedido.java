package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListPedido extends JFrame {
    private JTable tblPedidos;

    public UpdListPedido() {
        // Configuración básica del formulario
        setTitle("Lista de Pedidos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblPedidos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblPedidos);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Pedido", "ID Tienda", "ID Cliente", "Fecha", "Monto Bruto"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblPedidos.setModel(model);

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarPedido("1", "1", "1", "2023-07-01", "100.00");
        agregarPedido("2", "2", "2", "2023-07-02", "150.00");
        agregarPedido("3", "1", "3", "2023-07-03", "200.00");

        // Agregar listener para el clic en la tabla
        tblPedidos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblPedidos.getSelectedRow();
                if (selectedRow != -1) {
                    String idPedido = (String) tblPedidos.getValueAt(selectedRow, 0);
                    String idTienda = (String) tblPedidos.getValueAt(selectedRow, 1);
                    String idCliente = (String) tblPedidos.getValueAt(selectedRow, 2);
                    String fecha = (String) tblPedidos.getValueAt(selectedRow, 3);
                    String montoBruto = (String) tblPedidos.getValueAt(selectedRow, 4);

                    // Abrir la ventana de actualización
                    new UpdPedido(idPedido, idTienda, idCliente, fecha, montoBruto);
                }
            }
        });

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarPedido(String idPedido, String idTienda, String idCliente, String fecha, String montoBruto) {
        DefaultTableModel model = (DefaultTableModel) tblPedidos.getModel();
        model.addRow(new Object[]{idPedido, idTienda, idCliente, fecha, montoBruto});
    }

}
