package TrabajoFinal.GUI;

import TrabajoFinal.Segmento;
import TrabajoFinal.TiendaEcommerce;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DelTiendaVirtual extends JFrame {
    private JTable tblTiendas;
    private JButton btnEliminar;

    public DelTiendaVirtual(TiendaEcommerce tiendaEcommerce) {
        setTitle("Lista de Tiendas Virtuales");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        ArrayList<TiendaEcommerce> t1 = tiendaEcommerce.getListaTiendaEcommerce();
        int numTEcomm = t1.size();
        Object[][] data = new Object[numTEcomm][7];

        for (int i = 0; i < numTEcomm; i++) {
            TiendaEcommerce tiendaEcommerce1 = t1.get(i);
            data[i][0] = tiendaEcommerce1.getId_tienda();
            data[i][1] = tiendaEcommerce1.getRUC();
            data[i][2] = tiendaEcommerce1.getTipoTienda();
            data[i][3] = tiendaEcommerce1.getNombreTienda();
            data[i][4] = tiendaEcommerce1.getTrafico();
            data[i][5] = tiendaEcommerce1.getProveedorCloud();
            data[i][6] = tiendaEcommerce1.getCostoMantenimiento();
        }

        // Nombres de las columnas
        String[] columnNames = {"Id Tienda", "RUC", "Tipo Tienda", "Nombre Tienda", "Tráfico", "Proveedor Cloud", "Costo Mantenimiento"};

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
                int confirm = JOptionPane.showConfirmDialog(DelTiendaVirtual.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblTiendas.getSelectedRow();

                    int id_tienda = (int)tblTiendas.getValueAt(selectedRow, 0);

                    tiendaEcommerce.eliminar(id_tienda,tiendaEcommerce.getListaTiendaEcommerce());
                    // Eliminar el registro del modelo de tabla
                    tableModel.removeRow(selectedRow);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(DelTiendaVirtual.this, "El registro ha sido eliminado exitosamente.");

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
