package TrabajoFinal;

import java.util.ArrayList;
import java.util.Scanner;

public class TiendaFisica extends Tienda {
    private int m2;
    private String distrito;
    private String centroComercial;
    private double costoAlquiler;

    public TiendaFisica() {

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
}