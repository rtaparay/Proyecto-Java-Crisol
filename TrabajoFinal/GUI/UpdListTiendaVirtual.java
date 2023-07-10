package TrabajoFinal.GUI;

import TrabajoFinal.TiendaEcommerce;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdListTiendaVirtual extends JFrame {
    private JTable tblTiendas;

    public UpdListTiendaVirtual(TiendaEcommerce tiendaEcommerce) {
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

        ArrayList<TiendaEcommerce> listaTiendaEcommerce = tiendaEcommerce.getListaTiendaEcommerce();
        for (TiendaEcommerce tiendaEcommerce1 : listaTiendaEcommerce) {
            int id_tienda = tiendaEcommerce1.getId_tienda();
            String ruc = tiendaEcommerce1.getRUC();
            String tipoTienda = tiendaEcommerce1.getTipoTienda();
            String nombreTienda = tiendaEcommerce1.getNombreTienda();
            int trafico = tiendaEcommerce1.getTrafico();
            String proveedorCloud = tiendaEcommerce1.getProveedorCloud();
            double costoMantenimiento = tiendaEcommerce1.getCostoMantenimiento();
            model.addRow(new Object[]{id_tienda,ruc, tipoTienda, nombreTienda, trafico, proveedorCloud, costoMantenimiento});
        }

        // Llenar la tabla con datos de ejemplo
        //model.addRow(new Object[]{"1", "12345678", "Electrónica", "Tienda1", "Alto", "Amazon", "$1000"});
        // Agregar listener para el clic en la tabla
        tblTiendas.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tblTiendas.getSelectedRow();
            if (selectedRow != -1) {
                int idTienda = Integer.parseInt(tblTiendas.getValueAt(selectedRow, 0).toString());
                String ruc = (String) tblTiendas.getValueAt(selectedRow, 1);
                String tipoTienda = (String) tblTiendas.getValueAt(selectedRow, 2);
                String nombreTienda = (String) tblTiendas.getValueAt(selectedRow, 3);
                int trafico = Integer.parseInt(tblTiendas.getValueAt(selectedRow, 4).toString());
                String proveedorCloud = (String) tblTiendas.getValueAt(selectedRow, 5);
                double costoMantenimiento = Double.parseDouble(tblTiendas.getValueAt(selectedRow, 6).toString());

                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de actualizar el registro seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    UpdTiendaVirtual updTiendaVirtual = new UpdTiendaVirtual(idTienda, ruc, tipoTienda, nombreTienda, trafico, proveedorCloud, costoMantenimiento,tiendaEcommerce);
                    updTiendaVirtual.setVisible(true);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
