package TrabajoFinal.GUI;

import TrabajoFinal.TiendaFisica;

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
    private JTextField txtDistrito;

    public UpdTiendaFisica(int idTienda, String ruc, String tipoTienda, String nombreTienda, int trafico, int metrosCuadrados, String distrito, String centroComercial, double costoAlquiler, TiendaFisica tiendaFisica) {
        setTitle("Actualizar Tienda Física");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblIdTienda = new JLabel("Id Tienda:");
        txtIdTienda = new JTextField(String.valueOf(idTienda));
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
        txtTrafico = new JTextField(String.valueOf(trafico));
        panel.add(lblTrafico);
        panel.add(txtTrafico);

        JLabel lblMetrosCuadrados = new JLabel("Metros Cuadrados:");
        txtMetrosCuadrados = new JTextField(String.valueOf(metrosCuadrados));
        panel.add(lblMetrosCuadrados);
        panel.add(txtMetrosCuadrados);

        JLabel lblDistrito = new JLabel("Distrito:");
        txtDistrito = new JTextField(String.valueOf(distrito));
        panel.add(lblDistrito);
        panel.add(txtDistrito);

        JLabel lblCentroComercial = new JLabel("Centro Comercial:");
        txtCentroComercial = new JTextField(centroComercial);
        panel.add(lblCentroComercial);
        panel.add(txtCentroComercial);

        JLabel lblCostoAlquiler = new JLabel("Costo Alquiler:");
        txtCostoAlquiler = new JTextField(String.valueOf(costoAlquiler));
        panel.add(lblCostoAlquiler);
        panel.add(txtCostoAlquiler);

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
                    int metrosCuadrados = Integer.parseInt(txtMetrosCuadrados.getText());
                    String distrito = txtDistrito.getText();
                    String centroComercial = txtCentroComercial.getText();
                    double costoAlquiler = Double.parseDouble(txtCostoAlquiler.getText());
                int confirm = JOptionPane.showConfirmDialog(UpdTiendaFisica.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    tiendaFisica.modificar(idTienda,ruc,tipoTienda,nombreTienda,trafico,metrosCuadrados,distrito,centroComercial,costoAlquiler,tiendaFisica.getListaTiendaFisica());
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