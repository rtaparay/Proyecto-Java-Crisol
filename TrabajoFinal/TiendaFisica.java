package TrabajoFinal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TiendaFisica extends Tienda {
    private int m2;
    private String distrito;
    private String centroComercial;
    private double costoAlquiler;

    private ArrayList<TiendaFisica> listaTiendaFisica;
    public TiendaFisica() {

    }

    public TiendaFisica(int id_tienda, String RUC, String tipoTienda, String nombreTienda, int trafico, int m2, String distrito, String centroComercial, double costoAlquiler) {
        super(id_tienda, RUC, tipoTienda, nombreTienda, trafico);
        this.m2 = m2;
        this.distrito = distrito;
        this.centroComercial = centroComercial;
        this.costoAlquiler = costoAlquiler;
    }

    public ArrayList<TiendaFisica> getListaTiendaFisica() {
        return listaTiendaFisica;
    }

    public void setListaTiendaFisica(ArrayList<TiendaFisica> listaTiendaFisica) {
        this.listaTiendaFisica = listaTiendaFisica;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCentroComercial() {
        return centroComercial;
    }

    public void setCentroComercial(String centroComercial) {
        this.centroComercial = centroComercial;
    }

    public double getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setCostoAlquiler(double costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }

    public void registrar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el id de la tienda: ");
        int id_t = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el nombre de la tienda: ");
        String nombreT = sc.nextLine();

        System.out.println("Ingrese el tráfico promedio mensual que tiene la tienda física: ");
        int trafico = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese m2 de la tienda: ");
        int m2 = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el distrito de la tienda: ");
        String distrito = sc.nextLine();

        System.out.println("¿La tienda se encuentra en un centro comercial? ingrese SI/NO: ");
        String centroComercial = sc.nextLine();

        System.out.println("Ingrese el costo de alquiler de la tienda: ");
        double costoAlquiler = sc.nextDouble();

        this.setId_tienda(id_t);
        this.setRUC("20501457869");
        this.setTipoTienda("Tienda Física");
        this.setNombreTienda(nombreT);
        this.setTrafico(trafico);
        this.setM2(m2);
        this.setDistrito(distrito);
        this.setCentroComercial(centroComercial);
        this.setCostoAlquiler(costoAlquiler);

    }
/*
    public ArrayList<TiendaFisica> modificar(ArrayList<TiendaFisica> data) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el ID de la tienda física que desea MODIFICAR");
        int id = Integer.parseInt(sc.nextLine());
        boolean idExisteEnData = false;
        for (TiendaFisica p: data) {
            if (p.getId_tienda() == id) {
                idExisteEnData = true;
                System.out.println("Se encontraron los siguientes datos registrados con el ID: " + id);
                p.imprimir();
                System.out.println("");

                System.out.println("Ingrese el nombre de la tienda: ");
                String nombreT = sc.nextLine();

                System.out.println("Ingrese el tráfico promedio mensual que tiene la tienda física: ");
                int trafico = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese m2 de la tienda: ");
                int m2 = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese el distrito de la tienda: ");
                String distrito = sc.nextLine();

                System.out.println("¿La tienda se encuentra en un centro comercial? ingrese SI/NO: ");
                String centroComercial = sc.nextLine();

                System.out.println("Ingrese el costo de alquiler de la tienda: ");
                double costoAlquiler = sc.nextDouble();

                p.setNombreTienda(nombreT);
                p.setTrafico(trafico);
                p.setM2(m2);
                p.setDistrito(distrito);
                p.setCentroComercial(centroComercial);
                p.setCostoAlquiler(costoAlquiler);

                System.out.println("La modificación de los datos de la tienda física se realizaron con éxito");
            }
        }
        if (idExisteEnData == false) {
            System.out.println("El ID de la tienda física que intenta modificar no existe en la base de datos");
        }
        return data;
    }
*/
public void modificar(int idTienda, String ruc, String tipoTienda, String nombreTienda, int trafico, int metrosCuadrados,String distrito, String centroComercial, double costoAlquiler, ArrayList<TiendaFisica> tiendaFisicas) {
    for (TiendaFisica t1 : tiendaFisicas) {
        if (t1.getId_tienda() == idTienda) {
            t1.setRUC(ruc);
            t1.setTipoTienda(tipoTienda);
            t1.setNombreTienda(nombreTienda);
            t1.setTrafico(trafico);
            t1.setM2(metrosCuadrados);
            t1.setDistrito(distrito);
            t1.setCentroComercial(centroComercial);
            t1.setCostoAlquiler(costoAlquiler);
        }
    }
    this.setListaTiendaFisica(tiendaFisicas); // Actualizar la lista de segmentos
}
/*
    public ArrayList<TiendaFisica> eliminar(ArrayList<TiendaFisica> data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el ID de la tienda física que desea ELIMINAR");
        int id = Integer.parseInt(sc.nextLine());
        boolean idExisteEnData = false;
        int index = 0;

        for (TiendaFisica p: data) {
            if (p.getId_tienda() == id) {
                idExisteEnData = true;
                System.out.println("Se encontraron los siguientes datos registrados con el ID: " + id);
                p.imprimir();
                index = data.indexOf(p);
                break;
            }
        }

        if (idExisteEnData == false) {
            System.out.println("El ID de la tienda física que intenta eliminar no existe en la base de datos");
        } else {
            data.remove(index);
            System.out.println("La eliminación de la tienda física se realizó con éxito");
        }
        return data;
    }
*/
public void eliminar(int idTiendaEcommerce, ArrayList<TiendaFisica> listaTiendaFisica) {
    Iterator<TiendaFisica> iterator = listaTiendaFisica.iterator();
    while (iterator.hasNext()) {
        TiendaFisica tiendaFisica = iterator.next();
        if (tiendaFisica.getId_tienda() == idTiendaEcommerce) {
            iterator.remove(); // Eliminar el elemento de manera segura
        }
    }
    this.setListaTiendaFisica(listaTiendaFisica); // Actualizar el ArrayList listaSegmentos
}
    public void imprimir() {
        System.out.println("Id de la tienda física: " + this.getId_tienda() +
                ", RUC: " + this.getRUC() +
                ", Tipo de tienda: " + this.getTipoTienda() +
                ", Nombre de la tienda: " + this.getNombreTienda() +
                ", Tráfico promedio mensual: " + this.getTrafico() +
                ", M2: " + this.getM2() +
                ", Distrito: " + this.getDistrito() +
                ", ¿Se encuentra en un centro comercial?: " + this.getCentroComercial() +
                ", Costo de alquiler: " + this.getCostoAlquiler()
        );
    }


    public void cargaInicial() {
        ArrayList<TiendaFisica> listaTiendaFisica = new ArrayList<>();
        TiendaFisica t1 = new TiendaFisica(1,"123","ECOM","EBAY",500,512,"SAN MIGUEL","PLAZA",20.0);
        TiendaFisica t2 = new TiendaFisica(2,"456","FIS","RIPLEY",100,562,"SAN MIGUEL","PLAZA",20.0);
        TiendaFisica t3 = new TiendaFisica(3,"789","FISX","SAGA",501,502,"SAN MIGUEL","PLAZA",20.0);
        TiendaFisica t4 = new TiendaFisica(4,"0123","FOS","ZARA",520,51,"SAN MIGUEL","PLAZA",20.0);
        TiendaFisica t5 = new TiendaFisica(5,"545","E","CRISOL",503,52,"SAN MIGUEL","PLAZA",20.0);
        // Agregar más proveedores según sea necesario

        listaTiendaFisica.add(t1);
        listaTiendaFisica.add(t2);
        listaTiendaFisica.add(t3);
        listaTiendaFisica.add(t4);
        listaTiendaFisica.add(t5);
        // Agregar más proveedores según sea necesario

        this.setListaTiendaFisica(listaTiendaFisica);
    }
}