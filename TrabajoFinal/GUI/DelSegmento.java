package TrabajoFinal.GUI;

import TrabajoFinal.Proveedor;
import TrabajoFinal.Segmento;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DelSegmento extends JFrame {
    private JTable tblSegmentos;
    private JButton btnEliminar;

    public DelSegmento(Segmento segmento) {
        setTitle("Lista de Segmentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());


        ArrayList<Segmento> listaSegmentos = segmento.getListaSegmentos();
        int numSegmento = listaSegmentos.size();
        Object[][] data = new Object[numSegmento][3];
        for (int i = 0; i < numSegmento; i++) {
            Segmento seg1 = listaSegmentos.get(i);
            data[i][0] = seg1.getId_segmento();
            data[i][1] = seg1.getNombre_segmento();
            data[i][2] = seg1.getPorcentaje_descuento();
        }

        // Nombres de las columnas
        String[] columnNames = {"Id Segmento", "Nombre Segmento", "Porcentaje de descuento"};

        // Crear el modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo de tabla
        tblSegmentos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblSegmentos);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ListSelectionListener para detectar el cambio de selección en la tabla
        tblSegmentos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Habilitar o deshabilitar el botón Eliminar según si hay una fila seleccionada
                btnEliminar.setEnabled(tblSegmentos.getSelectedRow() != -1);
            }
        });

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(DelSegmento.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblSegmentos.getSelectedRow();

                    char idSegmento = tblSegmentos.getValueAt(selectedRow, 0).toString().charAt(0);
                    segmento.eliminar(idSegmento,segmento.getListaSegmentos());
                    // Eliminar el registro del modelo de tabla
                    tableModel.removeRow(selectedRow);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(DelSegmento.this, "El registro ha sido eliminado exitosamente.");

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
