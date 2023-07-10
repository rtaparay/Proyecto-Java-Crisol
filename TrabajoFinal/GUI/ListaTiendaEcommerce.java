package TrabajoFinal.GUI;

import TrabajoFinal.Segmento;
import TrabajoFinal.TiendaEcommerce;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaTiendaEcommerce extends JFrame {
    private JTable tblTiendas;

    public ListaTiendaEcommerce(ArrayList<TiendaEcommerce> listaTiendaEcommerce) {
        // Configuración básica del formulario
        setTitle("Lista de Tiendas de E-commerce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblTiendas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblTiendas);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Tienda", "RUC", "Tipo Tienda", "Nombre Tienda", "Tráfico", "Proveedor Cloud", "Costo Mantenimiento"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblTiendas.setModel(model);

        for (TiendaEcommerce tiendaEcommerce : listaTiendaEcommerce) {
            int id_tienda = tiendaEcommerce.getId_tienda();
            String ruc = tiendaEcommerce.getRUC();
            String tipoTienda = tiendaEcommerce.getTipoTienda();
            String nombreTienda = tiendaEcommerce.getNombreTienda();
            int trafico = tiendaEcommerce.getTrafico();
            String proveedorCloud = tiendaEcommerce.getProveedorCloud();
            double costoMantenimiento = tiendaEcommerce.getCostoMantenimiento();
            agregarTienda(id_tienda,ruc,tipoTienda,nombreTienda,trafico,proveedorCloud,costoMantenimiento);
        }
        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarTienda(int idTienda, String ruc, String tipoTienda, String nombreTienda, int trafico, String proveedorCloud, double costoMantenimiento) {
        DefaultTableModel model = (DefaultTableModel) tblTiendas.getModel();
        model.addRow(new Object[]{idTienda, ruc, tipoTienda, nombreTienda, trafico, proveedorCloud, costoMantenimiento});
    }

}
