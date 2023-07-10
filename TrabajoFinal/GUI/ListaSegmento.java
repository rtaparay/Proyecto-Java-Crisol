package TrabajoFinal.GUI;

import TrabajoFinal.Proveedor;
import TrabajoFinal.Segmento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaSegmento extends JFrame {
    private JTable tblSegmentos;

    public ListaSegmento(ArrayList<Segmento> listaSegmentos) {
        // Configuración básica del formulario
        setTitle("Lista de Segmentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblSegmentos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblSegmentos);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Segmento", "Nombre Segmento", "Porcentaje de descuento"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblSegmentos.setModel(model);

        for (Segmento seg : listaSegmentos) {
            char idSegmento = seg.getId_segmento();
            String nombrSegmento= seg.getNombre_segmento();
            double porcentajeDescuento = seg.getPorcentaje_descuento();
            agregarSegmento(idSegmento,nombrSegmento,porcentajeDescuento);
        }

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarSegmento(char idSegmento, String nombreSegmento, double porcentajeDescuento) {
        DefaultTableModel model = (DefaultTableModel) tblSegmentos.getModel();
        model.addRow(new Object[]{idSegmento, nombreSegmento, porcentajeDescuento});
    }

}
