package TrabajoFinal;

public class Cliente {
    private int id_cliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int recency;
    private int frecuency;
    private double monetaryValue;
    private int RFM_score;
    private char id_segmento;

    public Cliente(int id_cliente, String nombre, String apellidoPaterno, String apellidoMaterno, int recency, int frecuency, double monetaryValue, int RFM_score, char id_segmento) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.recency = recency;
        this.frecuency = frecuency;
        this.monetaryValue = monetaryValue;
        this.RFM_score = RFM_score;
        this.id_segmento = id_segmento;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getRecency() {
        return recency;
    }

    public void setRecency(int recency) {
        this.recency = recency;
    }

    public int getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
    }

    public double getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(double monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    public int getRFM_score() {
        return RFM_score;
    }

    public void setRFM_score(int RFM_score) {
        this.RFM_score = RFM_score;
    }

    public char getId_segmento() {
        return id_segmento;
    }

    public void setId_segmento(char id_segmento) {
        this.id_segmento = id_segmento;
    }

    public void registrar() {
        System.out.println("Cliente registrado correctamente.");
    }

    public void modificar() {
        System.out.println("Cliente modificado correctamente.");
    }

    public void eliminar() {
        System.out.println("Cliente eliminado correctamente.");
    }

    public void imprimir() {
        System.out.println("ID Cliente: " + id_cliente);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido Paterno: " + apellidoPaterno);
        System.out.println("Apellido Materno: " + apellidoMaterno);
        System.out.println("Recency: " + recency);
        System.out.println("Frecuency: " + frecuency);
        System.out.println("Monetary Value: " + monetaryValue);
        System.out.println("RFM Score: " + RFM_score);
        System.out.println("ID Segmento: " + id_segmento);
    }
}
