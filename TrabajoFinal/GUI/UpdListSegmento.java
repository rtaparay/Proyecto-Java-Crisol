package TrabajoFinal.GUI;
import TrabajoFinal.Segmento;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdListSegmento extends JFrame {
    private JTable table;

    public UpdListSegmento(Segmento segmento) {
        setTitle("Lista de Segmentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        ArrayList<Segmento> listaSegmento = new ArrayList<>();
        listaSegmento = segmento.getListaSegmentos();
        int numSegmentos = listaSegmento.size();
        Object[][] data = new Object[numSegmentos][3];
        for (int i = 0; i < numSegmentos; i++) {
            Segmento seg1 = listaSegmento.get(i);
            data[i][0] = seg1.getId_segmento();
            data[i][1] = seg1.getNombre_segmento();
            data[i][2] = seg1.getPorcentaje_descuento();
            //agregarDescuento(seg1.getId_segmento(),seg1.getNombre_segmento(),seg1.getPorcentaje_descuento());
        }


        String[] columnNames = {"Id Segmento", "Nombre Segmento", "Porcentaje de descuento"};

        table = new JTable(data, columnNames);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    char idSegmento =  table.getValueAt(selectedRow, 0).toString().charAt(0);
                    String nombreSegmento = (String) table.getValueAt(selectedRow, 1);
                    double descuento = Double.parseDouble(table.getValueAt(selectedRow, 2).toString());

                    UpdSegmento updSegmento = new UpdSegmento(idSegmento, nombreSegmento, descuento,segmento);
                    updSegmento.setVisible(true);
                    dispose();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

}