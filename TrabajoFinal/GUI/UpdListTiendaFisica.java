package TrabajoFinal.GUI;

import TrabajoFinal.TiendaEcommerce;
import TrabajoFinal.TiendaFisica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdListTiendaFisica extends JFrame {
    private JTable tblTiendas;

    public UpdListTiendaFisica(TiendaFisica tiendaFisica) {
        setTitle("Lista de Tiendas Físicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear la tabla
        tblTiendas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblTiendas);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"Id Tienda", "RUC", "Tipo Tienda", "Nombre Tienda", "Tráfico", "Metros Cuadrados","Distrito", "Centro Comercial", "Costo Alquiler"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblTiendas.setModel(model);


        ArrayList<TiendaFisica> listaTiendaFisica = tiendaFisica.getListaTiendaFisica();
        for (TiendaFisica tiendaFisica1 : listaTiendaFisica) {
            int id_tienda = tiendaFisica1.getId_tienda();
            String ruc = tiendaFisica1.getRUC();
            String tipoTienda = tiendaFisica1.getTipoTienda();
            String nombreTienda = tiendaFisica1.getNombreTienda();
            int trafico = tiendaFisica1.getTrafico();
            int m2 = tiendaFisica1.getM2();
            String distrito = tiendaFisica1.getDistrito();
            String centroComercial = tiendaFisica1.getCentroComercial();
            double costoAlquiler = tiendaFisica1.getCostoAlquiler();
            model.addRow(new Object[]{id_tienda,ruc, tipoTienda, nombreTienda, trafico, m2, distrito,centroComercial,costoAlquiler});
        }
        // Agregar listener para el clic en la tabla
        tblTiendas.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tblTiendas.getSelectedRow();
            if (selectedRow != -1) {
                int idTienda = Integer.parseInt(tblTiendas.getValueAt(selectedRow, 0).toString());
                String ruc1 = (String) tblTiendas.getValueAt(selectedRow, 1);
                String tipoTienda1 = (String) tblTiendas.getValueAt(selectedRow, 2);
                String nombreTienda1 = (String) tblTiendas.getValueAt(selectedRow, 3);
                int trafico1 = Integer.parseInt(tblTiendas.getValueAt(selectedRow, 4).toString());
                int  metrosCuadrados =  Integer.parseInt(tblTiendas.getValueAt(selectedRow, 5).toString());
                String distrito1 = (String) tblTiendas.getValueAt(selectedRow, 6);
                String centroComercial1 = (String) tblTiendas.getValueAt(selectedRow, 7);
                double costoAlquiler1 = Double.parseDouble(tblTiendas.getValueAt(selectedRow, 8).toString());

                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de actualizar el registro seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    UpdTiendaFisica updTiendaFisica = new UpdTiendaFisica(idTienda, ruc1, tipoTienda1, nombreTienda1, trafico1, metrosCuadrados, distrito1, centroComercial1, costoAlquiler1, tiendaFisica);
                    updTiendaFisica.setVisible(true);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
