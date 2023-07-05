package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaTiendaEcommerce extends JFrame {
    private JTable tblTiendas;

    public ListaTiendaEcommerce() {
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

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarTienda("1", "123456789", "Tipo 1", "Tienda 1", "Alto", "Proveedor 1", "1000");
        agregarTienda("2", "987654321", "Tipo 2", "Tienda 2", "Medio", "Proveedor 2", "1500");
        agregarTienda("3", "456789123", "Tipo 3", "Tienda 3", "Bajo", "Proveedor 3", "800");

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarTienda(String idTienda, String ruc, String tipoTienda, String nombreTienda, String trafico, String proveedorCloud, String costoMantenimiento) {
        DefaultTableModel model = (DefaultTableModel) tblTiendas.getModel();
        model.addRow(new Object[]{idTienda, ruc, tipoTienda, nombreTienda, trafico, proveedorCloud, costoMantenimiento});
    }

}
