package TrabajoFinal;

import java.util.ArrayList;
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

        System.out.println("Ingrese id del proveedor: ");
        int codigo = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el nombre del proveedor: ");
        String nombre = sc.nextLine();

        this.setId_proveedor(codigo);
        this.setNombreProveedor(nombre);
    }

    public ArrayList<Proveedor> modificar(ArrayList<Proveedor> data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el ID del proveedor que desea modificar");
        int id = Integer.parseInt(sc.nextLine());
        boolean idExisteEnData = false;
        for (Proveedor p: data) {
            if (p.getId_proveedor() == id) {
                idExisteEnData = true;
                System.out.println("Se encontraron los siguientes datos registrados con el ID: " + id);
                p.imprimir();
                System.out.println("");
                System.out.println("Ingrese el nuevo nombre del proveedor que reemplazará al actual: ");
                String nuevoNombreProveedor = sc.nextLine();
                p.setNombreProveedor(nuevoNombreProveedor);
                System.out.println("La modificación del nombre del proveedor se realizó con éxito");
            }
        }
        if (idExisteEnData == false) {
            System.out.println("El ID de proveedor que intenta modificar no existe en la base de datos");
        }
        return data;
    }

    public ArrayList<Proveedor> eliminar(ArrayList<Proveedor> data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el ID del proveedor que desea ELIMINAR");
        int id = Integer.parseInt(sc.nextLine());
        boolean idExisteEnData = false;
        int index = 0;

        for (Proveedor p: data) {
            if (p.getId_proveedor() == id) {
                idExisteEnData = true;
                System.out.println("Se encontraron los siguientes datos registrados con el ID: " + id);
                p.imprimir();
                index = data.indexOf(p);
                break;
            }
        }

        if (idExisteEnData == false) {
            System.out.println("El ID de proveedor que intenta eliminar no existe en la base de datos");
        } else {
            data.remove(index);
            System.out.println("La eliminación del proveedor se realizó con éxito");
        }
        return data;
    }

    public void imprimir() {
        System.out.println("Id proveedor: " + this.getId_proveedor() +
                ", Nombre del proveedor: " + this.getNombreProveedor()
        );
    }
}