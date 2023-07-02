package TrabajoFinal;

public class Producto {
    private int id_producto;
    private double precio;
    private String tipoProducto;

    public Producto(int id_producto, double precio, String tipoProducto) {
        this.id_producto = id_producto;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
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

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void registrar() {

    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void imprimir() {


    }
}
