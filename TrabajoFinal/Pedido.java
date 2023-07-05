package TrabajoFinal;

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
        int id_p;
        int id_t;
        int id_c;
        String f;
        double b;
        double dscto;
        double igv;
        double total;

        System.out.println("Ingrese id del pedido: ");
        id_p = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el id de la tienda: ");
        id_t = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el id del cliente: ");
        id_c = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese la fecha del pedido: ");
        f = sc.nextLine();

        System.out.println("Ingrese el monto bruto del pedido: ");
        b = sc.nextDouble();

        dscto = calcularDescuento(b);
        igv = calcularIGV(b,dscto);
        total = calcularImporteTotal(b,dscto,igv);

        this.setId_pedido(id_p);
        this.setId_tienda(id_t);
        this.setId_cliente(id_c);
        this.setFecha(f);
        this.setImporteBruto(b);
        this.setDescuento(dscto);
        this.setIgv(igv);
        this.setImporteTotal(total);
    }

    public void modificar() {}

    public void eliminar() {}

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