package TrabajoFinal.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdSegmento extends JFrame {
    private JTextField txtIdSegmento;
    private JTextField txtNombreSegmento;
    private JTextField txtDescuento;
    private JButton btnActualizar;

    public UpdSegmento(String idSegmento, String nombreSegmento, String descuento) {
        setTitle("Editar Segmento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);

        txtIdSegmento = new JTextField(idSegmento);
        txtIdSegmento.setEditable(false);

        txtNombreSegmento = new JTextField(nombreSegmento);

        txtDescuento = new JTextField(descuento);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(UpdSegmento.this,
                        "¿Estás seguro de actualizar el registro?",
                        "Confirmar actualización",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Lógica de actualización del registro
                    // Aquí puedes obtener los valores de los campos de texto y realizar la actualización
                    // ...
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