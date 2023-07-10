package TrabajoFinal;

import java.util.ArrayList;
import java.util.Iterator;
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


    private ArrayList<Pedido> listaPedidos;

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    private void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Pedido() {}

    public Pedido(int id_pedido, int id_tienda, int id_cliente, String fecha, double importeBruto, double igv, double descuento, double importeTotal) {
        this.id_pedido = id_pedido;
        this.id_tienda = id_tienda;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.importeBruto = importeBruto;
        this.igv = igv;
        this.descuento = descuento;
        this.importeTotal = importeTotal;
    }

    public void cargaInicial() {
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        double b = 100, dscto = calcularDescuento(b), igv = calcularIGV(b,dscto), total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido1 = new Pedido(1,1,1,"01/01/2023",b,igv,dscto,total);

        b = 48; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido2 = new Pedido(2,2,2,"05/01/2023",b,igv,dscto,total);

        b = 56; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido3 = new Pedido(3,5,3,"15/01/2023",b,igv,dscto,total);

        b = 86; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido4 = new Pedido(4,50,4,"22/01/2023",b,igv,dscto,total);

        b = 150; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido5 = new Pedido(5,3,5,"01/02/2023",b,igv,dscto,total);

        b = 50; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido6 = new Pedido(6,4,6,"10/02/2023",b,igv,dscto,total);

        b = 200; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido7 = new Pedido(7,5,7,"19/02/2023",b,igv,dscto,total);

        b = 256; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido8 = new Pedido(8,50,8,"27/02/2023",b,igv,dscto,total);

        b = 35; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido9 = new Pedido(9,2,9,"01/03/2023",b,igv,dscto,total);

        b = 120; dscto = calcularDescuento(b); igv = calcularIGV(b,dscto); total = calcularImporteTotal(b,dscto,igv);
        Pedido pedido10 = new Pedido(10,1,10,"15/03/2023",b,igv,dscto,total);


        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        listaPedidos.add(pedido3);
        listaPedidos.add(pedido4);
        listaPedidos.add(pedido5);
        listaPedidos.add(pedido6);
        listaPedidos.add(pedido7);
        listaPedidos.add(pedido8);
        listaPedidos.add(pedido9);
        listaPedidos.add(pedido10);

        this.setListaPedidos(listaPedidos);
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

    public void registrar(Pedido pedido, ArrayList<Pedido> listaPedidos) {
        listaPedidos.add(pedido);
        setListaPedidos(listaPedidos); // Actualizar el ArrayList listaPedidos
    }


    public void modificar(int id_pedido, int id_tienda, int id_cliente, String fecha, double importeBruto,
                          ArrayList<Pedido> listaPedidos) {
        for (Pedido pedido: listaPedidos) {
            if (pedido.getId_pedido() == id_pedido) {
                pedido.setId_tienda(id_tienda);
                pedido.setId_cliente(id_cliente);
                pedido.setFecha(fecha);
                pedido.setImporteBruto(importeBruto);

                double dscto = this.calcularDescuento(importeBruto);
                double igv = this.calcularIGV(importeBruto, dscto);
                double total = this.calcularImporteTotal(importeBruto, dscto, igv);
                pedido.setIgv(igv);
                pedido.setDescuento(dscto);
                pedido.setImporteTotal(total);
            }
        }
        setListaPedidos(listaPedidos); // Actualizar el ArrayList listaPedidos
    }

    public void eliminar(int id_pedido, ArrayList<Pedido> listaPedidos) {
        Iterator<Pedido> iterator = listaPedidos.iterator();
        while (iterator.hasNext()) {
            Pedido pedido = iterator.next();
            if (pedido.getId_pedido() == id_pedido) {
                iterator.remove(); // Eliminar el elemento de manera segura
            }
        }
        setListaPedidos(listaPedidos); // Actualizar el ArrayList listaPedidos
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