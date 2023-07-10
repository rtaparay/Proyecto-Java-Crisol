package TrabajoFinal.GUI;

import TrabajoFinal.Segmento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraSegmento extends JFrame {
    private JTextField txtIdSegmento;
    private JTextField txtNombreSegmento;
    private JTextField txtPorcentajeDescuento;

    public RegistraSegmento(Segmento segmento) {
        // Configuración básica del formulario
        setTitle("Registro de Segmento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Creación de los componentes del formulario
        JLabel lblIdSegmento = new JLabel("ID de Segmento:");
        txtIdSegmento = new JTextField();

        JLabel lblNombreSegmento = new JLabel("Nombre de Segmento:");
        txtNombreSegmento = new JTextField();

        JLabel lblPorcentajeDescuento = new JLabel("Porcentaje de Descuento:");
        txtPorcentajeDescuento = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraSegmento.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    grabarRegistro(segmento);
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdSegmento);
        add(txtIdSegmento);
        add(lblNombreSegmento);
        add(txtNombreSegmento);
        add(lblPorcentajeDescuento);
        add(txtPorcentajeDescuento);
        add(new JLabel());
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro(Segmento segmento) {
        char idSegmento = txtIdSegmento.getText().charAt(0);
        String nombreSegmento = txtNombreSegmento.getText();
        double porcentajeDescuento = Double.parseDouble(txtPorcentajeDescuento.getText());
        Segmento seg1 =  new Segmento(idSegmento,nombreSegmento,porcentajeDescuento);
        segmento.registrar(seg1,segmento.getListaSegmentos());
        // Aquí puedes realizar la lógica para grabar el registro en tu base de datos o en algún otro medio de almacenamiento
        // Por ahora, simplemente mostraremos un mensaje con los datos ingresados
        String mensaje = "Registro grabado:\n"
                + "ID de Segmento: " + idSegmento + "\n"
                + "Nombre de Segmento: " + nombreSegmento + "\n"
                + "Porcentaje de Descuento: " + porcentajeDescuento;
        JOptionPane.showMessageDialog(this, mensaje);
    }

}
