package TrabajoFinal.GUI;

import TrabajoFinal.Segmento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdSegmento extends JFrame {
    private JTextField txtIdSegmento;
    private JTextField txtNombreSegmento;
    private JTextField txtDescuento;
    private JButton btnActualizar;

    public UpdSegmento(char idSegmento, String nombreSegmento, double descuento, Segmento segmento) {
        setTitle("Editar Segmento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);

        txtIdSegmento = new JTextField(String.valueOf(idSegmento));
        txtIdSegmento.setEditable(false);

        txtNombreSegmento = new JTextField(nombreSegmento);

        txtDescuento = new JTextField(String.valueOf(descuento));

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(UpdSegmento.this,
                        "¿Estás seguro de actualizar el registro?",
                        "Confirmar actualización",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    char idSegmento = txtIdSegmento.getText().charAt(0);
                    String nombreSegmento = txtNombreSegmento.getText();
                    double porcentajeDescuento = Double.parseDouble(txtDescuento.getText());
                    segmento.modificar(idSegmento,nombreSegmento,porcentajeDescuento,segmento.getListaSegmentos());
                    dispose();
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Id Segmento:"));
        panel.add(txtIdSegmento);
        panel.add(new JLabel("Nombre Segmento:"));
        panel.add(txtNombreSegmento);
        panel.add(new JLabel("Porcentaje de descuento:"));
        panel.add(txtDescuento);
        panel.add(btnActualizar);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }
}