package TrabajoFinal.GUI;

import TrabajoFinal.Cliente;
import TrabajoFinal.Libro;
import TrabajoFinal.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaPedido extends JFrame {
    private JTable tblPedidos;

    public ListaPedido(ArrayList<Pedido> listaPedido, ArrayList<Cliente> clientes) {
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
        String[] columnNames = {"ID Pedido", "ID Tienda", "ID Cliente", "Fecha del Pedido", "Monto Bruto", "IGV", "Descuento", "Importe Total","Segmento"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblPedidos.setModel(model);
        Cliente cli = new Cliente(0,"","","",0,0,0.0,0,' ');
        for(Pedido pedido : listaPedido){
            int id_pedido = pedido.getId_pedido();
            int id_tienda = pedido.getId_tienda();
            int id_cliente = pedido.getId_cliente();
            String fecha = pedido.getFecha();
            double importeBruto = pedido.getImporteBruto();

            double descuento = pedido.calcularDescuento(importeBruto);
            double igv = pedido.calcularIGV(importeBruto,descuento);
            double importeTotal = pedido.calcularImporteTotal(importeBruto,descuento,igv);
            char segmento = cli.buscaSegmento(id_cliente,clientes);
            agregarPedido(id_pedido,id_tienda,id_cliente,fecha,importeBruto,descuento,igv,importeTotal,segmento);
        }

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarPedido(int idPedido, int idTienda, int idCliente, String fechaPedido, double montoBruto, double igv, double descuento, double importeTotal,char segmento) {
        DefaultTableModel model = (DefaultTableModel) tblPedidos.getModel();
        model.addRow(new Object[]{idPedido, idTienda, idCliente, fechaPedido, montoBruto, igv, descuento, importeTotal,segmento});
    }

}
