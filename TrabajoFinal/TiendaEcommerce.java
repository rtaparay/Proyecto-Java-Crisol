package TrabajoFinal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TiendaEcommerce extends Tienda {
    private String proveedorCloud;
    private double costoMantenimiento;

    private ArrayList<TiendaEcommerce> listaTiendaEcommerce;
    public TiendaEcommerce() {

    }

    public TiendaEcommerce(int id_tienda, String RUC, String tipoTienda, String nombreTienda, int trafico, String proveedorCloud, double costoMantenimiento) {
        super(id_tienda, RUC, tipoTienda, nombreTienda, trafico);
        this.proveedorCloud = proveedorCloud;
        this.costoMantenimiento = costoMantenimiento;
    }

    public ArrayList<TiendaEcommerce> getListaTiendaEcommerce() {
        return listaTiendaEcommerce;
    }

    public void setListaTiendaEcommerce(ArrayList<TiendaEcommerce> listaTiendaEcommerce) {
        this.listaTiendaEcommerce = listaTiendaEcommerce;
    }

    public String getProveedorCloud() {
        return proveedorCloud;
    }

    public void setProveedorCloud(String proveedorCloud) {
        this.proveedorCloud = proveedorCloud;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    public void registrar(TiendaEcommerce tiendaEcommerce, ArrayList<TiendaEcommerce> tiendaEcommerces) {
        tiendaEcommerces.add(tiendaEcommerce);
        this.setListaTiendaEcommerce(tiendaEcommerces);
    }
    /*
    public void registrar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el id de la tienda: ");
        int id_t = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el nombre de la tienda: ");
        String nombreT = sc.nextLine();

        System.out.println("Ingrese el tráfico promedio mensual que tiene la tienda virtual: ");
        int trafico = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el proveedor Cloud: ");
        String proveedorCloud = sc.nextLine();

        System.out.println("Ingrese el costo de mantenimiento mensual: ");
        double costoMant = sc.nextDouble();

        this.setId_tienda(id_t);
        this.setRUC("20501457869");
        this.setTipoTienda("Tienda E-Commerce");
        this.setNombreTienda(nombreT);
        this.setTrafico(trafico);
        this.setProveedorCloud(proveedorCloud);
        this.setCostoMantenimiento(costoMant);
    }
*/
    /*
    public ArrayList<TiendaEcommerce> modificar(ArrayList<TiendaEcommerce> data) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el ID de la tienda e-commerce que desea MODIFICAR");
        int id = Integer.parseInt(sc.nextLine());
        boolean idExisteEnData = false;
        for (TiendaEcommerce p: data) {
            if (p.getId_tienda() == id) {
                idExisteEnData = true;
                System.out.println("Se encontraron los siguientes datos registrados con el ID: " + id);
                p.imprimir();
                System.out.println("");

                System.out.println("Ingrese el nombre de la tienda: ");
                String nombreT = sc.nextLine();

                System.out.println("Ingrese el tráfico promedio mensual que tiene la tienda virtual: ");
                int trafico = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese el proveedor Cloud: ");
                String proveedorCloud = sc.nextLine();

                System.out.println("Ingrese el costo de mantenimiento mensual: ");
                double costoMant = sc.nextDouble();

                p.setNombreTienda(nombreT);
                p.setTrafico(trafico);
                p.setProveedorCloud(proveedorCloud);
                p.setCostoMantenimiento(costoMant);

                System.out.println("La modificación de los datos de la tienda virtual se realizaron con éxito");
            }
        }
        if (idExisteEnData == false) {
            System.out.println("El ID de la tienda virtual que intenta modificar no existe en la base de datos");
        }
        return data;
    }

     */
    public void modificar(int id_tienda, String RUC, String tipoTienda, String nombreTienda, int trafico, String proveedorCloud, double costoMantenimiento, ArrayList<TiendaEcommerce> tiendaEcommerces) {
        for (TiendaEcommerce t1 : tiendaEcommerces) {
            if (t1.getId_tienda() == id_tienda) {
                t1.setRUC(RUC);
                t1.setTipoTienda(tipoTienda);
                t1.setNombreTienda(nombreTienda);
                t1.setTrafico(trafico);
                t1.setProveedorCloud(proveedorCloud);
                t1.setCostoMantenimiento(costoMantenimiento);
            }
        }
        this.setListaTiendaEcommerce(tiendaEcommerces); // Actualizar la lista de segmentos
    }
/*
    public ArrayList<TiendaEcommerce> eliminar(ArrayList<TiendaEcommerce> data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el ID de la tienda e-commerce que desea ELIMINAR");
        int id = Integer.parseInt(sc.nextLine());
        boolean idExisteEnData = false;
        int index = 0;

        for (TiendaEcommerce p: data) {
            if (p.getId_tienda() == id) {
                idExisteEnData = true;
                System.out.println("Se encontraron los siguientes datos registrados con el ID: " + id);
                p.imprimir();
                index = data.indexOf(p);
                break;
            }
        }

        if (idExisteEnData == false) {
            System.out.println("El ID de la tienda e-commerce que intenta eliminar no existe en la base de datos");
        } else {
            data.remove(index);
            System.out.println("La eliminación de la tienda e-commerce se realizó con éxito");
        }
        return data;
    }
*/
public void eliminar(int idTiendaEcommerce, ArrayList<TiendaEcommerce> listaTiendaEcommerce) {
    Iterator<TiendaEcommerce> iterator = listaTiendaEcommerce.iterator();
    while (iterator.hasNext()) {
        TiendaEcommerce tiendaEcommerce = iterator.next();
        if (tiendaEcommerce.getId_tienda() == idTiendaEcommerce) {
            iterator.remove(); // Eliminar el elemento de manera segura
        }
    }
    this.setListaTiendaEcommerce(listaTiendaEcommerce); // Actualizar el ArrayList listaSegmentos
}
    public void imprimir() {
        System.out.println("Id de la tienda e-commerce: " + this.getId_tienda() +
                ", RUC: " + this.getRUC() +
                ", Tipo de tienda: " + this.getTipoTienda() +
                ", Nombre de la tienda: " + this.getNombreTienda() +
                ", Tráfico promedio mensual: " + this.getTrafico() +
                ", Proveedor Cloud: " + this.getProveedorCloud() +
                ", Costo de mantenimiento: " + this.getCostoMantenimiento()
        );
    }

    public void cargaInicial() {
        ArrayList<TiendaEcommerce> listaTiendaEcommerce = new ArrayList<>();
        TiendaEcommerce t1 = new TiendaEcommerce(50,"20501457869","ECOM","E-COMMERCE DE LIBRERIAS CRISOL",112,"AWA",145.50);

        listaTiendaEcommerce.add(t1);

        this.setListaTiendaEcommerce(listaTiendaEcommerce);
    }
}
