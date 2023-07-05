package TrabajoFinal.GUI;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListSegmento extends JFrame {
    private JTable table;

    public UpdListSegmento() {
        setTitle("Lista de Segmentos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        String[][] data = {
                {"1", "Segmento 1", "10%"},
                {"2", "Segmento 2", "20%"},
                {"3", "Segmento 3", "15%"}
        };

        String[] columnNames = {"Id Segmento", "Nombre Segmento", "Porcentaje de descuento"};

        table = new JTable(data, columnNames);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String idSegmento = (String) table.getValueAt(selectedRow, 0);
                    String nombreSegmento = (String) table.getValueAt(selectedRow, 1);
                    String descuento = (String) table.getValueAt(selectedRow, 2);

                    UpdSegmento updSegmento = new UpdSegmento(idSegmento, nombreSegmento, descuento);
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