package TrabajoFinal.GUI;

import TrabajoFinal.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdListPedido extends JFrame {
    private JTable tblPedidos;

    public UpdListPedido(Pedido pedido) {
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

        ArrayList<Pedido> listaPedido = pedido.getListaPedidos();
        for(Pedido pedido1 : listaPedido) {
            int id_pedido = pedido1.getId_pedido();
            int id_tienda = pedido1.getId_tienda();
            int id_cliente = pedido1.getId_cliente();
            String fecha = pedido1.getFecha();
            double importeBruto = pedido1.getImporteBruto();
            agregarPedido(id_pedido,id_tienda,id_cliente,fecha,importeBruto);
        }

        // Agregar listener para el clic en la tabla
        tblPedidos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblPedidos.getSelectedRow();
                if (selectedRow != -1) {
                    int idPedido = Integer.parseInt(tblPedidos.getValueAt(selectedRow, 0).toString());
                    int idTienda = (int) tblPedidos.getValueAt(selectedRow, 1);
                    int idCliente = (int) tblPedidos.getValueAt(selectedRow, 2);
                    String fecha = (String) tblPedidos.getValueAt(selectedRow, 3);
                    double montoBruto = (Double) tblPedidos.getValueAt(selectedRow, 4);

                    // Abrir la ventana de actualización
                    new UpdPedido(idPedido, idTienda, idCliente, fecha, montoBruto, pedido);
                }
            }
        });

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarPedido(int idPedido, int idTienda, int idCliente, String fecha, double montoBruto) {
        DefaultTableModel model = (DefaultTableModel) tblPedidos.getModel();
        model.addRow(new Object[]{idPedido, idTienda, idCliente, fecha, montoBruto});
    }

}
