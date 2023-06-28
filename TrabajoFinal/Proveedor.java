package TrabajoFinal;

public class Proveedor {
    private int id_proveedor;
    private String nombreProveedor;

    public Proveedor(int id_proveedor, String nombreProveedor) {
        this.id_proveedor = id_proveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void registrar() {

    }

    public void imprimir() {
        System.out.println("Id proveedor: " + Integer.toString(this.getId_proveedor()));
        System.out.println("Nombre proveedor: " + this.getNombreProveedor());
    }
}