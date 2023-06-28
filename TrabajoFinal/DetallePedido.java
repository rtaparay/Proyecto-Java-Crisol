package TrabajoFinal;

public class DetallePedido {
    private int id_pedido;
    private int id_producto;
    private double precio;
    private int cantidad;
    private double importe;

    public DetallePedido(int id_pedido, int id_producto, double precio, int cantidad, double importe) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void registrar() {

    }

    public double calcularImporte() {
        return 0.00;
    }
}
