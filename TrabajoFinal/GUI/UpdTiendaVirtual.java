package TrabajoFinal.GUI;

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

    public UpdTiendaVirtual(String idTienda, String ruc, String tipoTienda, String nombreTienda, String trafico, String proveedorCloud, String costoMantenimiento) {
        setTitle("Actualizar Tienda Virtual");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear los campos de texto
        txtIdTienda = new JTextField(idTienda);
        txtRUC = new JTextField(ruc);
        txtTipoTienda = new JTextField(tipoTienda);
        txtNombreTienda = new JTextField(nombreTienda);
        txtTrafico = new JTextField(trafico);
        txtProveedorCloud = new JTextField(proveedorCloud);
        txtCostoMantenimiento = new JTextField(costoMantenimiento);

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
                String idTienda = txtIdTienda.getText();
                String ruc = txtRUC.getText();
                String tipoTienda = txtTipoTienda.getText();
                String nombreTienda = txtNombreTienda.getText();
                String trafico = txtTrafico.getText();
                String proveedorCloud = txtProveedorCloud.getText();
                String costoMantenimiento = txtCostoMantenimiento.getText();

                int confirm = JOptionPane.showConfirmDialog(UpdTiendaVirtual.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Aquí puedes realizar la actualización del registro en tu fuente de datos
                    // Por ejemplo, puedes llamar a un método de actualización de la base de datos
                    // updateTienda(idTienda, ruc, tipoTienda, nombreTienda, trafico, proveedorCloud, costoMantenimiento);

                    // Luego, cierra la ventana
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
