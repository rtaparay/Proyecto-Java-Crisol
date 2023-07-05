package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaPedido extends JFrame {
    private JTable tblPedidos;

    public ListaPedido() {
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
        String[] columnNames = {"ID Pedido", "ID Tienda", "ID Cliente", "Fecha del Pedido", "Monto Bruto", "IGV", "Descuento", "Importe Total"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblPedidos.setModel(model);

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarPedido("1", "1001", "2001", "01/01/2022", "100.00", "18.00", "10.00", "108.00");
        agregarPedido("2", "1002", "2002", "02/01/2022", "200.00", "36.00", "20.00", "216.00");
        agregarPedido("3", "1003", "2003", "03/01/2022", "150.00", "27.00", "15.00", "162.00");

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarPedido(String idPedido, String idTienda, String idCliente, String fechaPedido, String montoBruto, String igv, String descuento, String importeTotal) {
        DefaultTableModel model = (DefaultTableModel) tblPedidos.getModel();
        model.addRow(new Object[]{idPedido, idTienda, idCliente, fechaPedido, montoBruto, igv, descuento, importeTotal});
    }

}
