package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdListCliente extends JFrame {
    private JTable tblClientes;

    public UpdListCliente() {
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

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarCliente("1", "John", "Doe", "Smith", "10", "5", "1000", "A", "1");
        agregarCliente("2", "Jane", "Smith", "Doe", "8", "3", "500", "B", "2");
        agregarCliente("3", "Mike", "Johnson", "Brown", "12", "6", "1500", "A", "1");

        // Agregar listener para el clic en la tabla
        tblClientes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblClientes.getSelectedRow();
                if (selectedRow != -1) {
                    String idCliente = (String) tblClientes.getValueAt(selectedRow, 0);
                    String nombre = (String) tblClientes.getValueAt(selectedRow, 1);
                    String apellidoPaterno = (String) tblClientes.getValueAt(selectedRow, 2);
                    String apellidoMaterno = (String) tblClientes.getValueAt(selectedRow, 3);
                    String recency = (String) tblClientes.getValueAt(selectedRow, 4);
                    String frequency = (String) tblClientes.getValueAt(selectedRow, 5);
                    String monetaryValue = (String) tblClientes.getValueAt(selectedRow, 6);
                    String rfmScore = (String) tblClientes.getValueAt(selectedRow, 7);
                    String idSegmento = (String) tblClientes.getValueAt(selectedRow, 8);

                    // Abrir la ventana de actualización
                    new UpdCliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, recency, frequency, monetaryValue, rfmScore, idSegmento);
                }
            }
        });

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarCliente(String idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String recency, String frequency, String monetaryValue, String rfmScore, String idSegmento) {
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.addRow(new Object[]{idCliente, nombre, apellidoPaterno, apellidoMaterno, recency, frequency, monetaryValue, rfmScore, idSegmento});
    }

}
