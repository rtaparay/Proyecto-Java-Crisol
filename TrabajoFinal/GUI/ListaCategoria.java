package TrabajoFinal.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListaCategoria extends JFrame {
    private JTable tblCategorias;

    public ListaCategoria() {
        // Configuración básica del formulario
        setTitle("Lista de Categorías");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creación de la tabla
        tblCategorias = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblCategorias);

        // Agregar la tabla al formulario
        add(scrollPane, BorderLayout.CENTER);

        // Configurar los nombres de las columnas
        String[] columnNames = {"ID Categoría", "Nombre de Categoría"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tblCategorias.setModel(model);

        // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
        agregarCategoria("1", "Categoría 1");
        agregarCategoria("2", "Categoría 2");
        agregarCategoria("3", "Categoría 3");

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarCategoria(String idCategoria, String nombreCategoria) {
        DefaultTableModel model = (DefaultTableModel) tblCategorias.getModel();
        model.addRow(new Object[]{idCategoria, nombreCategoria});
    }
}
