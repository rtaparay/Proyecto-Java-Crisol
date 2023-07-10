package TrabajoFinal.GUI;

import TrabajoFinal.TiendaEcommerce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdTiendaVirtual extends JFrame {
    private JTextField txtIdTienda;
    private JTextField txtRUC;
    private JTextField txtTipoTienda;
    private JTextField txtNombreTienda;
    private JTextField txtTrafico;
    private JTextField txtProveedorCloud;
    private JTextField txtCostoMantenimiento;

    public UpdTiendaVirtual(int idTienda, String ruc, String tipoTienda, String nombreTienda, int trafico, String proveedorCloud, double costoMantenimiento, TiendaEcommerce tiendaEcommerce) {
        setTitle("Actualizar Tienda Virtual");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear los campos de texto
        txtIdTienda = new JTextField(String.valueOf(idTienda));
        txtRUC = new JTextField(ruc);
        txtTipoTienda = new JTextField(tipoTienda);
        txtNombreTienda = new JTextField(nombreTienda);
        txtTrafico = new JTextField(String.valueOf(trafico));
        txtProveedorCloud = new JTextField(proveedorCloud);
        txtCostoMantenimiento = new JTextField(String.valueOf(costoMantenimiento));

        // Crear el panel de contenido
        JPanel contentPanel = new JPanel(new GridLayout(7, 2));
        contentPanel.add(new JLabel("ID Tienda:"));
        contentPanel.add(txtIdTienda);
        contentPanel.add(new JLabel("RUC:"));
        contentPanel.add(txtRUC);
        contentPanel.add(new JLabel("Tipo Tienda:"));
        contentPanel.add(txtTipoTienda);
        contentPanel.add(new JLabel("Nombre Tienda:"));
        contentPanel.add(txtNombreTienda);
        contentPanel.add(new JLabel("Tráfico:"));
        contentPanel.add(txtTrafico);
        contentPanel.add(new JLabel("Proveedor Cloud:"));
        contentPanel.add(txtProveedorCloud);
        contentPanel.add(new JLabel("Costo Mantenimiento:"));
        contentPanel.add(txtCostoMantenimiento);

        // Crear el botón de actualización
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idTienda = Integer.parseInt(txtIdTienda.getText());
                String ruc = txtRUC.getText();
                String tipoTienda = txtTipoTienda.getText();
                String nombreTienda = txtNombreTienda.getText();
                int trafico = Integer.parseInt(txtTrafico.getText());
                String proveedorCloud = txtProveedorCloud.getText();
                double costoMantenimiento = Double.parseDouble(txtCostoMantenimiento.getText());

                int confirm = JOptionPane.showConfirmDialog(UpdTiendaVirtual.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    tiendaEcommerce.modificar(idTienda,ruc,tipoTienda,nombreTienda,trafico,proveedorCloud,costoMantenimiento,tiendaEcommerce.getListaTiendaEcommerce());
                    dispose();
                }
            }
        });

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnActualizar);

        // Agregar los paneles al formulario
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}
