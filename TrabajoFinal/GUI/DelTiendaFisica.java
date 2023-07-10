package TrabajoFinal.GUI;

import TrabajoFinal.TiendaEcommerce;
import TrabajoFinal.TiendaFisica;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DelTiendaFisica extends JFrame {
    private JTable tblTiendas;
    private JButton btnEliminar;

    public DelTiendaFisica(TiendaFisica tiendaFisica) {
        setTitle("Lista de Tiendas Físicas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());


        ArrayList<TiendaFisica> t1 = tiendaFisica.getListaTiendaFisica();
        int numTEcomm = t1.size();
        Object[][] data = new Object[numTEcomm][9];

        for (int i = 0; i < numTEcomm; i++) {
            TiendaFisica tiendaFisica1 = t1.get(i);
            data[i][0] = tiendaFisica1.getId_tienda();
            data[i][1] = tiendaFisica1.getRUC();
            data[i][2] = tiendaFisica1.getTipoTienda();
            data[i][3] = tiendaFisica1.getNombreTienda();
            data[i][4] = tiendaFisica1.getTrafico();
            data[i][5] = tiendaFisica1.getM2();
            data[i][6] = tiendaFisica1.getDistrito();
            data[i][7] = tiendaFisica1.getCentroComercial();
            data[i][8] = tiendaFisica1.getCostoAlquiler();
        }


        // Nombres de las columnas
        String[] columnNames = {"Id Tienda", "RUC", "Tipo Tienda", "Nombre Tienda", "Tráfico", "Metros Cuadrados","Distrito",  "Centro Comercial", "Costo Alquiler"};

        // Crear el modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo de tabla
        tblTiendas = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblTiendas);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ListSelectionListener para detectar el cambio de selección en la tabla
        tblTiendas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Habilitar o deshabilitar el botón Eliminar según si hay una fila seleccionada
                btnEliminar.setEnabled(tblTiendas.getSelectedRow() != -1);
            }
        });

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(DelTiendaFisica.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblTiendas.getSelectedRow();


                    int id_tienda = (int)tblTiendas.getValueAt(selectedRow, 0);
                    tiendaFisica.eliminar(id_tienda,tiendaFisica.getListaTiendaFisica());
                    // Eliminar el registro del modelo de tabla
                    tableModel.removeRow(selectedRow);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(DelTiendaFisica.this, "El registro ha sido eliminado exitosamente.");

                    // Desactivar el botón Eliminar
                    btnEliminar.setEnabled(false);
                }
            }
        });

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEliminar);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}