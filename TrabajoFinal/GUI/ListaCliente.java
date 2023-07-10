package TrabajoFinal.GUI;

import TrabajoFinal.Cliente;
import TrabajoFinal.UsuarioSistema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaCliente extends JFrame {
    private JTable tblClientes;

    public ListaCliente(ArrayList<Cliente> lClientes) {
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

        for (Cliente cliente : lClientes) {
            int idCliente = cliente.getId_cliente();
            String nombre = cliente.getNombre();
            String apellidoPaterno = cliente.getApellidoPaterno();
            String apellidoMaterno = cliente.getApellidoMaterno();
            int recency = cliente.getRecency();
            int frecency = cliente.getFrecuency();
            double monetaryValue = cliente.getMonetaryValue();
            int RFM_score = cliente.getRFM_score();
            char idSegmento = cliente.getId_segmento();

            agregarCliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, recency, frecency, monetaryValue, RFM_score, idSegmento);
        }

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarCliente(int idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, int recency, int frequency, double monetaryValue, int rfmScore, char idSegmento) {
        DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
        model.addRow(new Object[]{idCliente, nombre, apellidoPaterno, apellidoMaterno, recency, frequency, monetaryValue, rfmScore, idSegmento});
    }

}

