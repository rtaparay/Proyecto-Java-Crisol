package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaSegmento extends JFrame {
    private JTable tblSegmentos;

    public ListaSegmento() {
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

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarSegmento("1", "Segmento 1", "10%");
        agregarSegmento("2", "Segmento 2", "15%");
        agregarSegmento("3", "Segmento 3", "20%");

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarSegmento(String idSegmento, String nombreSegmento, String porcentajeDescuento) {
        DefaultTableModel model = (DefaultTableModel) tblSegmentos.getModel();
        model.addRow(new Object[]{idSegmento, nombreSegmento, porcentajeDescuento});
    }

}
