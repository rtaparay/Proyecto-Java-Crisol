package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListTiendaVirtual extends JFrame {
    private JTable tblTiendas;

    public UpdListTiendaVirtual() {
        setTitle("Lista de Tiendas Virtuales");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear la tabla
        tblTiendas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblTiendas);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"Id Tienda", "RUC", "Tipo Tienda", "Nombre Tienda", "Tráfico", "Proveedor Cloud", "Costo Mantenimiento"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblTiendas.setModel(model);

        // Llenar la tabla con datos de ejemplo
        model.addRow(new Object[]{"1", "12345678", "Electrónica", "Tienda1", "Alto", "Amazon", "$1000"});
        model.addRow(new Object[]{"2", "87654321", "Ropa", "Tienda2", "Medio", "Shopify", "$800"});
        model.addRow(new Object[]{"3", "98765432", "Libros", "Tienda3", "Bajo", "WooCommerce", "$600"});

        // Agregar listener para el clic en la tabla
        tblTiendas.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tblTiendas.getSelectedRow();
            if (selectedRow != -1) {
                String idTienda = (String) tblTiendas.getValueAt(selectedRow, 0);
                String ruc = (String) tblTiendas.getValueAt(selectedRow, 1);
                String tipoTienda = (String) tblTiendas.getValueAt(selectedRow, 2);
                String nombreTienda = (String) tblTiendas.getValueAt(selectedRow, 3);
                String trafico = (String) tblTiendas.getValueAt(selectedRow, 4);
                String proveedorCloud = (String) tblTiendas.getValueAt(selectedRow, 5);
                String costoMantenimiento = (String) tblTiendas.getValueAt(selectedRow, 6);

                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de actualizar el registro seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    UpdTiendaVirtual updTiendaVirtual = new UpdTiendaVirtual(idTienda, ruc, tipoTienda, nombreTienda, trafico, proveedorCloud, costoMantenimiento);
                    updTiendaVirtual.setVisible(true);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
