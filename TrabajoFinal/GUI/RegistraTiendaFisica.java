package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraTiendaFisica extends JFrame {
    private JTextField txtIdTienda;
    private JTextField txtRUC;
    private JTextField txtTipoTienda;
    private JTextField txtNombreTienda;
    private JTextField txtTrafico;
    private JTextField txtMetrosCuadrados;
    private JTextField txtCentroComercial;
    private JTextField txtCostoAlquiler;

    public RegistraTiendaFisica() {
        // Configuración básica del formulario
        setTitle("Registro de Tienda Física");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

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

        JLabel lblMetrosCuadrados = new JLabel("Metros Cuadrados:");
        txtMetrosCuadrados = new JTextField();

        JLabel lblCentroComercial = new JLabel("Centro Comercial:");
        txtCentroComercial = new JTextField();

        JLabel lblCostoAlquiler = new JLabel("Costo de Alquiler:");
        txtCostoAlquiler = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraTiendaFisica.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    grabarRegistro();
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
        add(lblMetrosCuadrados);
        add(txtMetrosCuadrados);
        add(lblCentroComercial);
        add(txtCentroComercial);
        add(lblCostoAlquiler);
        add(txtCostoAlquiler);
        add(new JLabel());
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro() {
        String idTienda = txtIdTienda.getText();
        String ruc = txtRUC.getText();
        String tipoTienda = txtTipoTienda.getText();
        String nombreTienda = txtNombreTienda.getText();
        String trafico = txtTrafico.getText();
        String metrosCuadrados = txtMetrosCuadrados.getText();
        String centroComercial = txtCentroComercial.getText();
        String costoAlquiler = txtCostoAlquiler.getText();

        // Aquí puedes realizar la lógica de grabación del registro en la base de datos o en otro medio
        // Por ahora, solo mostraremos un mensaje con los datos ingresados
        String mensaje = "Registro grabado:\n"
                + "ID de Tienda: " + idTienda + "\n"
                + "RUC: " + ruc + "\n"
                + "Tipo de Tienda: " + tipoTienda + "\n"
                + "Nombre de Tienda: " + nombreTienda + "\n"
                + "Tráfico: " + trafico + "\n"
                + "Metros Cuadrados: " + metrosCuadrados + "\n"
                + "Centro Comercial: " + centroComercial + "\n"
                + "Costo de Alquiler: " + costoAlquiler + "\n";
        JOptionPane.showMessageDialog(this, mensaje);
    }

}
