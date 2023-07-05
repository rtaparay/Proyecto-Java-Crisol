package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdTiendaFisica extends JFrame {
    private JTextField txtIdTienda;
    private JTextField txtRUC;
    private JTextField txtTipoTienda;
    private JTextField txtNombreTienda;
    private JTextField txtTrafico;
    private JTextField txtMetrosCuadrados;
    private JTextField txtCentroComercial;
    private JTextField txtCostoAlquiler;

    public UpdTiendaFisica(String idTienda, String ruc, String tipoTienda, String nombreTienda, String trafico, String metrosCuadrados, String centroComercial, String costoAlquiler) {
        setTitle("Actualizar Tienda Física");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblIdTienda = new JLabel("Id Tienda:");
        txtIdTienda = new JTextField(idTienda);
        txtIdTienda.setEditable(false);
        panel.add(lblIdTienda);
        panel.add(txtIdTienda);

        JLabel lblRUC = new JLabel("RUC:");
        txtRUC = new JTextField(ruc);
        panel.add(lblRUC);
        panel.add(txtRUC);

        JLabel lblTipoTienda = new JLabel("Tipo Tienda:");
        txtTipoTienda = new JTextField(tipoTienda);
        panel.add(lblTipoTienda);
        panel.add(txtTipoTienda);

        JLabel lblNombreTienda = new JLabel("Nombre Tienda:");
        txtNombreTienda = new JTextField(nombreTienda);
        panel.add(lblNombreTienda);
        panel.add(txtNombreTienda);

        JLabel lblTrafico = new JLabel("Tráfico:");
        txtTrafico = new JTextField(trafico);
        panel.add(lblTrafico);
        panel.add(txtTrafico);

        JLabel lblMetrosCuadrados = new JLabel("Metros Cuadrados:");
        txtMetrosCuadrados = new JTextField(metrosCuadrados);
        panel.add(lblMetrosCuadrados);
        panel.add(txtMetrosCuadrados);

        JLabel lblCentroComercial = new JLabel("Centro Comercial:");
        txtCentroComercial = new JTextField(centroComercial);
        panel.add(lblCentroComercial);
        panel.add(txtCentroComercial);

        JLabel lblCostoAlquiler = new JLabel("Costo Alquiler:");
        txtCostoAlquiler = new JTextField(costoAlquiler);
        panel.add(lblCostoAlquiler);
        panel.add(txtCostoAlquiler);

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
                    String metrosCuadrados = txtMetrosCuadrados.getText();
                    String centroComercial = txtCentroComercial.getText();
                    String costoAlquiler = txtCostoAlquiler.getText();
                int confirm = JOptionPane.showConfirmDialog(UpdTiendaFisica.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
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
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        }
    }