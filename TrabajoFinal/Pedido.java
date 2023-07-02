package TrabajoFinal;

public class Pedido {
    private int id_pedido;
    private int id_tienda;
    private int id_cliente;
    private String fecha;
    private double importeBruto;
    private double igv;
    private double descuento;
    private double importeTotal;

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

    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void imprimir() {

    }

    public double calcularIGV() {

        return 0.00;

    }

    public double calcularDescuento() {
        return 0.00;
    }

    public double calcularImporteTotal() {

        return 0.00;
    }
}