package TrabajoFinal;

import java.util.Scanner;

public class Proveedor {
    //Sergio Ayesta
    private int id_proveedor;
    private String nombreProveedor;

    public Proveedor() {

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
        Scanner sc = new Scanner(System.in);
        int codigo;
        String nombre;

        System.out.println("Ingrese id del proveedor: ");
        codigo = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el nombre del proveedor: ");
        nombre = sc.nextLine();

        this.setId_proveedor(codigo);
        this.setNombreProveedor(nombre);
    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void imprimir() {
        System.out.println("Id proveedor: " + this.getId_proveedor() +
                ", Nombre del proveedor: " + this.getNombreProveedor()
        );
    }
}