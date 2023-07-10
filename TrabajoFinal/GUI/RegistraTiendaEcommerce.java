package TrabajoFinal.GUI;

import TrabajoFinal.TiendaEcommerce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraTiendaEcommerce extends JFrame {
    private JTextField txtIdTienda;
    private JTextField txtRUC;
    private JTextField txtTipoTienda;
    private JTextField txtNombreTienda;
    private JTextField txtTrafico;
    private JTextField txtProveedorCloud;
    private JTextField txtCostoMantenimiento;

    public RegistraTiendaEcommerce(TiendaEcommerce tiendaEcommerce) {
        // Configuración básica del formulario
        setTitle("Registro de Tienda eCommerce");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Creación de los componentes del formulario
        JLabel lblIdTienda = new JLabel("ID de Tienda:");
        txtIdTienda = new JTextField();

        JLabel lblRUC = new JLabel("RUC:");
        txtRUC = new JTextField();

        JLabel lblTipoTienda = new JLabel("Tipo de Tienda:");
        txtTipoTienda = new JTextField();

        JLabel lblNombreTienda = new JLabel("Nombre de Tienda:");
        txtNombreTienda = new JTextField();

        JLabel lblTrafico = new JLabel("Tráfico:");
        txtTrafico = new JTextField();

        JLabel lblProveedorCloud = new JLabel("Proveedor Cloud:");
        txtProveedorCloud = new JTextField();

        JLabel lblCostoMantenimiento = new JLabel("Costo de Mantenimiento:");
        txtCostoMantenimiento = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraTiendaEcommerce.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    grabarRegistro(tiendaEcommerce);
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdTienda);
        add(txtIdTienda);
        add(lblRUC);
        add(txtRUC);
        add(lblTipoTienda);
        add(txtTipoTienda);
        add(lblNombreTienda);
        add(txtNombreTienda);
        add(lblTrafico);
        add(txtTrafico);
        add(lblProveedorCloud);
        add(txtProveedorCloud);
        add(lblCostoMantenimiento);
        add(txtCostoMantenimiento);
        add(new JLabel());
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro(TiendaEcommerce tiendaEcommerce) {
        int idTienda = Integer.parseInt(txtIdTienda.getText());
        String ruc = txtRUC.getText();
        String tipoTienda = txtTipoTienda.getText();
        String nombreTienda = txtNombreTienda.getText();
        int trafico = Integer.parseInt(txtTrafico.getText());
        String proveedorCloud = txtProveedorCloud.getText();
        double costoMantenimiento = Double.parseDouble(txtCostoMantenimiento.getText());
        TiendaEcommerce t1 = new TiendaEcommerce(idTienda,ruc,tipoTienda,nombreTienda,trafico,proveedorCloud,costoMantenimiento);
        tiendaEcommerce.registrar(t1,tiendaEcommerce.getListaTiendaEcommerce());
        // Aquí puedes realizar la lógica para grabar el registro en tu base de datos o en algún otro medio de almacenamiento
        // Por ahora, simplemente mostraremos un mensaje con los datos ingresados
        String mensaje = "Registro grabado:\n"
                + "ID de Tienda: " + idTienda + "\n"
                + "RUC: " + ruc + "\n"
                + "Tipo de Tienda: " + tipoTienda + "\n"
                + "Nombre de Tienda: " + nombreTienda + "\n"
                + "Tráfico: " + trafico + "\n"
                + "Proveedor Cloud: " + proveedorCloud + "\n"
                + "Costo de Mantenimiento: " + costoMantenimiento + "\n";
        JOptionPane.showMessageDialog(this, mensaje);
    }

}
