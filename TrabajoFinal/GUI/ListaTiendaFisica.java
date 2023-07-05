package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaTiendaFisica extends JFrame {
    private JTable tblTiendas;

    public ListaTiendaFisica() {
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
        String[] columnNames = {"ID Tienda", "RUC", "Tipo Tienda", "Nombre Tienda", "Tráfico", "Metros Cuadrados", "Centro Comercial", "Costo Alquiler"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblTiendas.setModel(model);

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarTienda("1", "123456789", "Tipo 1", "Tienda 1", "Alto", "100", "Centro Comercial 1", "2000");
        agregarTienda("2", "987654321", "Tipo 2", "Tienda 2", "Medio", "150", "Centro Comercial 2", "2500");
        agregarTienda("3", "456789123", "Tipo 3", "Tienda 3", "Bajo", "120", "Centro Comercial 3", "1800");

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarTienda(String idTienda, String ruc, String tipoTienda, String nombreTienda, String trafico, String metrosCuadrados, String centroComercial, String costoAlquiler) {
        DefaultTableModel model = (DefaultTableModel) tblTiendas.getModel();
        model.addRow(new Object[]{idTienda, ruc, tipoTienda, nombreTienda, trafico, metrosCuadrados, centroComercial, costoAlquiler});
    }

}
