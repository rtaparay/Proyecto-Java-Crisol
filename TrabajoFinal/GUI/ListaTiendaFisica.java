package TrabajoFinal.GUI;

import TrabajoFinal.TiendaEcommerce;
import TrabajoFinal.TiendaFisica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaTiendaFisica extends JFrame {
    private JTable tblTiendas;

    public ListaTiendaFisica(ArrayList<TiendaFisica> tiendaFisicas) {
        // Configuración básica del formulario
        setTitle("Lista de Tiendas Físicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblTiendas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblTiendas);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Tienda", "RUC", "Tipo Tienda", "Nombre Tienda", "Tráfico", "Metros Cuadrados", "Distrito", "Centro Comercial", "Costo Alquiler"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblTiendas.setModel(model);


        for (TiendaFisica tiendaFisica : tiendaFisicas) {
            int id_tienda = tiendaFisica.getId_tienda();
            String ruc = tiendaFisica.getRUC();
            String tipoTienda = tiendaFisica.getTipoTienda();
            String nombreTienda = tiendaFisica.getNombreTienda();
            int trafico = tiendaFisica.getTrafico();
            int m2 = tiendaFisica.getM2();
            String distrito = tiendaFisica.getDistrito();
            String centroComercial = tiendaFisica.getCentroComercial();
            double costoAquiler = tiendaFisica.getCostoAlquiler();
            agregarTienda(id_tienda,ruc,tipoTienda,nombreTienda,trafico,m2,distrito,centroComercial,costoAquiler);
        }

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarTienda(int idTienda, String ruc, String tipoTienda, String nombreTienda, int trafico, int metrosCuadrados,String distrito, String centroComercial, double costoAlquiler) {
        DefaultTableModel model = (DefaultTableModel) tblTiendas.getModel();
        model.addRow(new Object[]{idTienda, ruc, tipoTienda, nombreTienda, trafico, metrosCuadrados,distrito, centroComercial, costoAlquiler});
    }

}
