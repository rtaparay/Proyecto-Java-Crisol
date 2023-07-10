package TrabajoFinal.GUI;

import TrabajoFinal.Pedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdPedido extends JFrame {
    private JTextField txtIdPedido;
    private JTextField txtIdTienda;
    private JTextField txtIdCliente;
    private JTextField txtFecha;
    private JTextField txtMontoBruto;

    public UpdPedido(int idPedido, int idTienda, int idCliente, String fecha, double montoBruto, Pedido pedido) {
        // Configuración básica del formulario
        setTitle("Actualizar Pedido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Crear los componentes del formulario
        JLabel lblIdPedido = new JLabel("ID Pedido:");
        txtIdPedido = new JTextField(String.valueOf(idPedido));
        JLabel lblIdTienda = new JLabel("ID Tienda:");
        txtIdTienda = new JTextField(String.valueOf(idTienda));
        JLabel lblIdCliente = new JLabel("ID Cliente:");
        txtIdCliente = new JTextField(String.valueOf(idCliente));
        JLabel lblFecha = new JLabel("Fecha:");
        txtFecha = new JTextField(fecha);
        JLabel lblMontoBruto = new JLabel("Monto Bruto:");
        txtMontoBruto = new JTextField(String.valueOf(montoBruto));

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes escribir el código para actualizar los datos del pedido
                int idPedido = Integer.parseInt(txtIdPedido.getText());
                int idTienda = Integer.parseInt(txtIdTienda.getText());
                int idCliente = Integer.parseInt(txtIdCliente.getText());
                String fechaPedido = txtFecha.getText();
                double montoBruto = Double.parseDouble(txtMontoBruto.getText());
                // Mostrar un mensaje de confirmación
                int respuesta = JOptionPane.showConfirmDialog(UpdPedido.this, "¿Estás seguro de actualizar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    // Aquí puedes escribir el código para realizar la actualización del registro
                    pedido.modificar(idPedido,idTienda,idCliente,fechaPedido,montoBruto,pedido.getListaPedidos());
                    // Cerrar la ventana de actualización
                    dispose();
                }
            }
        });

        // Agregar los componentes al formulario
        add(lblIdPedido);
        add(txtIdPedido);
        add(lblIdTienda);
        add(txtIdTienda);
        add(lblIdCliente);
        add(txtIdCliente);
        add(lblFecha);
        add(txtFecha);
        add(lblMontoBruto);
        add(txtMontoBruto);
        add(new JLabel());
        add(btnActualizar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

}
