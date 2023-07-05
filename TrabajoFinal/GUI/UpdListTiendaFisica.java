package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListTiendaFisica extends JFrame {
    private JTable tblTiendas;

    public UpdListTiendaFisica() {
        setTitle("Lista de Tiendas Físicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear la tabla
        tblTiendas = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblTiendas);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"Id Tienda", "RUC", "Tipo Tienda", "Nombre Tienda", "Tráfico", "Metros Cuadrados", "Centro Comercial", "Costo Alquiler"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblTiendas.setModel(model);

        // Llenar la tabla con datos de ejemplo
        model.addRow(new Object[]{"1", "12345678", "Ropa", "Tienda1", "Alto", "100", "Mall1", "$2000"});
        model.addRow(new Object[]{"2", "87654321", "Electrónica", "Tienda2", "Medio", "80", "Mall2", "$1500"});
        model.addRow(new Object[]{"3", "98765432", "Comida", "Tienda3", "Bajo", "120", "Mall3", "$1800"});

        // Agregar listener para el clic en la tabla
        tblTiendas.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tblTiendas.getSelectedRow();
            if (selectedRow != -1) {
                String idTienda = (String) tblTiendas.getValueAt(selectedRow, 0);
                String ruc = (String) tblTiendas.getValueAt(selectedRow, 1);
                String tipoTienda = (String) tblTiendas.getValueAt(selectedRow, 2);
                String nombreTienda = (String) tblTiendas.getValueAt(selectedRow, 3);
                String trafico = (String) tblTiendas.getValueAt(selectedRow, 4);
                String metrosCuadrados = (String) tblTiendas.getValueAt(selectedRow, 5);
                String centroComercial = (String) tblTiendas.getValueAt(selectedRow, 6);
                String costoAlquiler = (String) tblTiendas.getValueAt(selectedRow, 7);

                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de actualizar el registro seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    UpdTiendaFisica updTiendaFisica = new UpdTiendaFisica(idTienda, ruc, tipoTienda, nombreTienda, trafico, metrosCuadrados, centroComercial, costoAlquiler);
                    updTiendaFisica.setVisible(true);
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
