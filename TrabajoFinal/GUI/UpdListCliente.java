package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import TrabajoFinal.Cliente;
import java.util.ArrayList;
public class UpdListCliente extends JFrame {
    private JTable tblClientes;

    public UpdListCliente(Cliente cliente) {
        // Configuración básica del formulario
        setTitle("Lista de Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblClientes = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblClientes);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Cliente", "Nombre", "Apellido Paterno", "Apellido Materno", "Recency", "Frequency", "Monetary Value", "RFM Score", "ID Segmento"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblClientes.setModel(model);

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes = cliente.getListaClientes();
        int numClientes = listaClientes.size();
        Object[][] data = new Object[numClientes][9];
        for (int i = 0; i < numClientes; i++) {
            Cliente cliente1 = listaClientes.get(i);
            data[i][0] = cliente1.getId_cliente();
            data[i][1] = cliente1.getNombre();
            data[i][2] = cliente1.getApellidoPaterno();
            data[i][3] = cliente1.getApellidoMaterno();
            data[i][4] = cliente1.getRecency();
            data[i][5] = cliente1.getFrecuency();
            data[i][6] = cliente1.getMonetaryValue();
            data[i][7] = cliente1.getRFM_score();
            data[i][8] = cliente1.getId_segmento();
            agregarCliente(cliente1.getId_cliente(),cliente1.getNombre(),cliente1.getApellidoPaterno(),
                    cliente1.getApellidoMaterno(),cliente1.getRecency(),cliente1.getFrecuency(),
                    cliente1.getMonetaryValue(),cliente1.getRFM_score(),cliente1.getId_segmento());
        }
        // Agregar listener para el clic en la tabla
        tblClientes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblClientes.getSelectedRow();
                if (selectedRow != -1) {
                    int idCliente = (int) tblClientes.getValueAt(selectedRow, 0);
                    String nombre = (String) tblClientes.getValueAt(selectedRow, 1);
                    String apellidoPaterno = (String) tblClientes.getValueAt(selectedRow, 2);
                    String apellidoMaterno = (String) tblClientes.getValueAt(selectedRow, 3);
                    int recency = (int) tblClientes.getValueAt(selectedRow, 4);
                    int frequency = (int) tblClientes.getValueAt(selectedRow, 5);
                    double monetaryValue = (double) tblClientes.getValueAt(selectedRow, 6);
                    int rfmScore = (int) tblClientes.getValueAt(selectedRow, 7);
                    char idSegmento = (char) tblClientes.getValueAt(selectedRow, 8);

                    // Abrir la ventana de actualización
                    new UpdCliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, recency, frequency, monetaryValue, rfmScore, idSegmento,cliente);
                }
            }
        });

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarCliente(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, int recency, int frequency, double monetaryValue, int rfmScore, char idSegmento) {
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.addRow(new Object[]{idCliente, nombre, apellidoPaterno, apellidoMaterno, recency, frequency, monetaryValue, rfmScore, idSegmento});
    }

}
