package TrabajoFinal.GUI;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import TrabajoFinal.Categoria;
public class DelCategoria extends JFrame {
    private JTable tblCategorias;
    private JButton btnEliminar;

    public DelCategoria(Categoria cat) {
        setTitle("Lista de Categorías");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        ArrayList<Categoria> lCat = new ArrayList<>();
        lCat = cat.getListaCategorias();
        int numCat = lCat.size();
        Object[][] data =  new Object[numCat][2];
        int numUsuarios = lCat.size();
        for (int i = 0; i < numUsuarios; i++) {
            Categoria cat1 = lCat.get(i);
            data[i][0] = cat1.getId_categoria();
            data[i][1] = cat1.getNombreCategoria();

        }
        // Nombres de las columnas
        String[] columnNames = {"Id Categoría", "Nombre de Categoría"};

        // Crear el modelo de tabla con los datos y los nombres de las columnas
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo de tabla
        tblCategorias = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblCategorias);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar ListSelectionListener para detectar el cambio de selección en la tabla
        tblCategorias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Habilitar o deshabilitar el botón Eliminar según si hay una fila seleccionada
                btnEliminar.setEnabled(tblCategorias.getSelectedRow() != -1);
            }
        });

        // Botón Eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(DelCategoria.this,
                        "¿Está seguro de eliminar el registro seleccionado?", "Confirmación",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Obtener el índice de la fila seleccionada
                    int selectedRow = tblCategorias.getSelectedRow()-1;
                    String idCat = tblCategorias.getValueAt(selectedRow+1, 0).toString();
                    int pIdCat = Integer.parseInt(idCat);
                    cat.eliminar(pIdCat,cat.getListaCategorias());
                    // Eliminar el registro del modelo de tabla
                    tableModel.removeRow(selectedRow+1);

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(DelCategoria.this, "Registro eliminado exitosamente");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEliminar);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
