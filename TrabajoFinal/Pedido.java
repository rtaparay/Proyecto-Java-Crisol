package TrabajoFinal;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    //Sergio Ayesta
    private int id_pedido;
    private int id_tienda;
    private int id_cliente;
    private String fecha;
    private double importeBruto;
    private double igv;
    private double descuento;
    private double importeTotal;

    public Pedido() {

    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporteBruto() {
        return importeBruto;
    }

    public void setImporteBruto(double importeBruto) {
        this.importeBruto = importeBruto;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public void registrar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese id del pedido: ");
        int id_p = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el id de la tienda: ");
        int id_t = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el id del cliente: ");
        int id_c = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese la fecha del pedido: ");
        String f = sc.nextLine();

        System.out.println("Ingrese el monto bruto del pedido: ");
        double b = sc.nextDouble();

        double dscto = calcularDescuento(b);
        double igv = calcularIGV(b,dscto);
        double total = calcularImporteTotal(b,dscto,igv);

        this.setId_pedido(id_p);
        this.setId_tienda(id_t);
        this.setId_cliente(id_c);
        this.setFecha(f);
        this.setImporteBruto(b);
        this.setDescuento(dscto);
        this.setIgv(igv);
        this.setImporteTotal(total);
    }

    public ArrayList<Pedido> modificar(ArrayList<Pedido> data) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indique el ID del pedido que desea modificar");
        int id = Integer.parseInt(sc.nextLine());
        boolean idExisteEnData = false;
        for (Pedido p: data) {
            if (p.getId_pedido() == id) {
                idExisteEnData = true;
                System.out.println("Se encontraron los siguientes datos registrados con el ID: " + id);
                p.imprimir();
                System.out.println("");

                System.out.println("Ingrese el ID de tienda del pedido: ");
                int id_t = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese el ID del cliente del pedido: ");
                int id_c = Integer.parseInt(sc.nextLine());

                System.out.println("Ingrese la FECHA del pedido: ");
                String f = sc.nextLine();

                System.out.println("Ingrese el MONTO BRUTO del pedido: ");
                double b = sc.nextDouble();

                double dscto = calcularDescuento(b);
                double igv = calcularIGV(b,dscto);
                double total = calcularImporteTotal(b,dscto,igv);

                p.setId_tienda(id_t);
                p.setId_cliente(id_c);
                p.setFecha(f);
                p.setImporteBruto(b);
                p.setDescuento(dscto);
                p.setIgv(igv);
                p.setImporteTotal(total);
                System.out.println("La modificación de los datos del pedido se realizaron con éxito");
            }
        }
        if (idExisteEnData == false) {
            System.out.println("El ID del pedido que intenta modificar no existe en la base de datos");
        }
        return data;
    }

    public ArrayList<Pedido> eliminar(ArrayList<Pedido> data) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique el ID del pedido que desea ELIMINAR");
        int id = Integer.parseInt(sc.nextLine());
        boolean idExisteEnData = false;
        int index = 0;

        for (Pedido p: data) {
            if (p.getId_pedido() == id) {
                idExisteEnData = true;
                System.out.println("Se encontraron los siguientes datos registrados con el ID: " + id);
                p.imprimir();
                index = data.indexOf(p);
                break;
            }
        }

        if (idExisteEnData == false) {
            System.out.println("El ID del pedido que intenta eliminar no existe en la base de datos");
        } else {
            data.remove(index);
            System.out.println("La eliminación del pedido se realizó con éxito");
        }
        return data;
    }

    public void imprimir() {
        System.out.println("Id pedido: " + this.getId_pedido() +
                ", Id tienda: " + this.getId_tienda() +
                ", Id cliente: " + this.getId_cliente() +
                ", fecha del pedido: " + this.getFecha() +
                ", importe bruto: " + this.getImporteBruto() +
                ", descuento: " + this.getDescuento() +
                ", IGV: " + this.getIgv() +
                ", importe neto + IGV: " + this.getImporteTotal()
        );
    }

    public double calcularIGV(double bruto, double dscto) {
        return (bruto - dscto) * 0.18;
    }

    public double calcularDescuento(double bruto) {

        //Luego de que se implemente las clases Cliente y Segmento, agregar búsqueda
        // de segmento al cual pertenece el cliente

        char segmento = 'A';
        double dscto = 0.0;

        switch (segmento) {
            case 'A':
                dscto = 0.2;
                break;
            case 'B':
                dscto = 0.1;
                break;
            case 'C':
                dscto = 0.05;
                break;
            default:
                dscto = 0.0;
        }
        return bruto * dscto;
    }

    public double calcularImporteTotal(double b, double dscto, double igv) {

        return (b - dscto) + igv;
    }
}