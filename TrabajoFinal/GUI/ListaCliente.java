package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaCliente extends JFrame {
    private JTable tblClientes;

    public ListaCliente() {
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
        agregarCliente("1", "John", "Doe", "Smith", "10", "5", "1000", "4", "1");
        agregarCliente("2", "Jane", "Smith", "Doe", "5", "2", "500", "3", "2");
        agregarCliente("3", "David", "Johnson", "Brown", "8", "3", "800", "3", "1");

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarCliente(String idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String recency, String frequency, String monetaryValue, String rfmScore, String idSegmento) {
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.addRow(new Object[]{idCliente, nombre, apellidoPaterno, apellidoMaterno, recency, frequency, monetaryValue, rfmScore, idSegmento});
    }

}

