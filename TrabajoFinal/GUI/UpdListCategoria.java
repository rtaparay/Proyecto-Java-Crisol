package TrabajoFinal.GUI;

import TrabajoFinal.Categoria;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdListCategoria extends JFrame {
    private JTable tblCategorias;
    private JButton btnActualizar;

    public UpdListCategoria(Categoria categoria) {
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
        ArrayList<Categoria> listaCategorias = categoria.getListaCategorias();
        for(Categoria cat : listaCategorias) {
            int idCategoria = cat.getId_categoria();
            String nombreCategoria = cat.getNombreCategoria();
            agregarCategoria(idCategoria, nombreCategoria);
            // Llenar la tabla con datos de ejemplo (puedes reemplazar esto con tus datos reales)
            //agregarCategoria("1", "Categoría 1");
            //agregarCategoria("2", "Categoría 2");
            //agregarCategoria("3", "Categoría 3");
        }
        // Agregar listener para el evento de selección de la tabla
        tblCategorias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                btnActualizar.setEnabled(tblCategorias.getSelectedRow() != -1);
            }
        });

        // Crear el botón de actualización
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tblCategorias.getSelectedRow();
                int idCategoria = (Integer) tblCategorias.getValueAt(filaSeleccionada, 0);
                String nombreCategoria = (String) tblCategorias.getValueAt(filaSeleccionada, 1);

                UpdCategoria updCategoria = new UpdCategoria(idCategoria, nombreCategoria,categoria);
                updCategoria.mostrarFormulario();

                // Actualizar la fila en la tabla si el registro fue actualizado
                if (updCategoria.isRegistroActualizado()) {
                    tblCategorias.setValueAt(updCategoria.getIdCategoria(), filaSeleccionada, 0);
                    tblCategorias.setValueAt(updCategoria.getNombreCategoria(), filaSeleccionada, 1);
                    JOptionPane.showMessageDialog(UpdListCategoria.this, "Registro actualizado");
                }
            }
        });

        // Crear el panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);

        // Agregar el panel de botones al formulario
        add(panelBotones, BorderLayout.SOUTH);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void agregarCategoria(int idCategoria, String nombreCategoria) {
        DefaultTableModel model = (DefaultTableModel) tblCategorias.getModel();
        model.addRow(new Object[]{idCategoria, nombreCategoria});
    }

}
