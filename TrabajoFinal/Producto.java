package TrabajoFinal;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del producto: ");
        id_producto = scanner.nextInt();

        System.out.println("Ingrese el precio del producto: ");
        precio = scanner.nextDouble();

        System.out.println("Ingrese el tipo de producto: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        tipoProducto = scanner.nextLine();

        System.out.println("El producto ha sido registrado con éxito.");
    }

    public void modificar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nuevo precio del producto: ");
        precio = scanner.nextDouble();

        System.out.println("Ingrese el nuevo tipo de producto: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        tipoProducto = scanner.nextLine();

        System.out.println("El producto ha sido modificado con éxito.");
    }

    public void eliminar() {
        id_producto = 0;
        precio = 0.0;
        tipoProducto = "";

        System.out.println("El producto ha sido eliminado.");
    }

    public void imprimir() {
        System.out.println("Detalles del producto:");
        System.out.println("ID: " + id_producto);
        System.out.println("Precio: " + precio);
        System.out.println("Tipo de producto: " + tipoProducto);
    }
}
