package TrabajoFinal.GUI;

import TrabajoFinal.Pedido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraPedido extends JFrame {
    private JTextField txtIdPedido;
    private JTextField txtIdTienda;
    private JTextField txtIdCliente;
    private JTextField txtFechaPedido;
    private JTextField txtMontoBruto;

    public RegistraPedido(Pedido pedido) {
        // Configuración básica del formulario
        setTitle("Registro de Pedido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Creación de los componentes del formulario
        JLabel lblIdPedido = new JLabel("ID del Pedido:");
        txtIdPedido = new JTextField();

        JLabel lblIdTienda = new JLabel("ID de la Tienda:");
        txtIdTienda = new JTextField();

        JLabel lblIdCliente = new JLabel("ID del Cliente:");
        txtIdCliente = new JTextField();

        JLabel lblFechaPedido = new JLabel("Fecha del Pedido:");
        txtFechaPedido = new JTextField();

        JLabel lblMontoBruto = new JLabel("Monto Bruto del Pedido:");
        txtMontoBruto = new JTextField();

        JButton btnGrabar = new JButton("Grabar");
        btnGrabar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(RegistraPedido.this, "¿Está seguro de grabar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {

                    grabarRegistro(pedido);
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
        add(lblFechaPedido);
        add(txtFechaPedido);
        add(lblMontoBruto);
        add(txtMontoBruto);
        add(new JLabel());
        add(btnGrabar);

        // Ajustar tamaño y hacer visible el formulario
        pack();
        setVisible(true);
    }

    private void grabarRegistro(Pedido pedido) {
        int idPedido = Integer.parseInt(txtIdPedido.getText());
        int idTienda = Integer.parseInt(txtIdTienda.getText());
        int idCliente = Integer.parseInt(txtIdCliente.getText());
        String fechaPedido = txtFechaPedido.getText();
        double montoBruto = Double.parseDouble(txtMontoBruto.getText());
        Pedido pedido1 = new Pedido(idPedido, idTienda, idCliente, fechaPedido, montoBruto, 0.0, 0.0, 0.0);
        pedido.registrar(pedido1,pedido.getListaPedidos());
        // Aquí puedes realizar la lógica para grabar el registro en tu base de datos o en algún otro medio de almacenamiento
        // Por ahora, simplemente mostraremos un mensaje con los datos ingresados
        String mensaje = "Registro grabado:\n"
                + "ID del Pedido: " + idPedido + "\n"
                + "ID de la Tienda: " + idTienda + "\n"
                + "ID del Cliente: " + idCliente + "\n"
                + "Fecha del Pedido: " + fechaPedido + "\n"
                + "Monto Bruto del Pedido: " + montoBruto;
        JOptionPane.showMessageDialog(this, mensaje);
    }

}
