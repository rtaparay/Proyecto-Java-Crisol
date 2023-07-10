package TrabajoFinal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Proveedor {
    //Sergio Ayesta
    private int id_proveedor;
    private String nombreProveedor;

    private ArrayList<Proveedor> proveedores = new ArrayList<>();

    public Proveedor(int id_proveedor, String nombreProveedor) {
        this.id_proveedor = id_proveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public Proveedor() {

    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
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

    /*
    public void registrar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese id del proveedor: ");
        int codigo = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el nombre del proveedor: ");
        String nombre = sc.nextLine();

        this.setId_proveedor(codigo);
        this.setNombreProveedor(nombre);
    }
*/
    public void registrar(Proveedor proveedor, ArrayList<Proveedor> listaProveedores) {
        listaProveedores.add(proveedor);
        setProveedores(listaProveedores);
    }

    public void modificar(int idProveedor, String nuevoNombreProveedor, ArrayList<Proveedor> listaProveedores) {
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getId_proveedor() == idProveedor) {
                proveedor.setNombreProveedor(nuevoNombreProveedor);
            }
        }
        this.setProveedores(listaProveedores); // Actualizar la lista de proveedores
    }

    /*
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
*/
    /*
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
    }*/
    public void eliminar(int idProveedor, ArrayList<Proveedor> listaProveedores) {
        Iterator<Proveedor> iterator = listaProveedores.iterator();
        while (iterator.hasNext()) {
            Proveedor proveedor = iterator.next();
            if (proveedor.getId_proveedor() == idProveedor) {
                iterator.remove(); // Eliminar el elemento de manera segura
            }
        }
        setProveedores(listaProveedores); // Actualizar el ArrayList listaProveedores
    }


    public void imprimir() {
        System.out.println("Id proveedor: " + this.getId_proveedor() +
                ", Nombre del proveedor: " + this.getNombreProveedor()
        );
    }

    public void cargaInicial() {
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        Proveedor proveedor1 = new Proveedor(1, "Proveedor 1");
        Proveedor proveedor2 = new Proveedor(2, "Proveedor 2");
        Proveedor proveedor3 = new Proveedor(3, "Proveedor 3");
        Proveedor proveedor4 = new Proveedor(4, "Proveedor 4");
        Proveedor proveedor5 = new Proveedor(5, "Proveedor 5");
        // Agregar más proveedores según sea necesario

        listaProveedores.add(proveedor1);
        listaProveedores.add(proveedor2);
        listaProveedores.add(proveedor3);
        listaProveedores.add(proveedor4);
        listaProveedores.add(proveedor5);
        // Agregar más proveedores según sea necesario

        this.setProveedores(listaProveedores);
    }
}