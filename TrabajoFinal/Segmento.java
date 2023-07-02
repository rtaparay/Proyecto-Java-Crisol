package TrabajoFinal;

public class Segmento {
    private char id_segmento;
    private String nombre_segmento;
    private double porcentaje_descuento;

    public Segmento(char id_segmento, String nombre_segmento, double porcentaje_descuento) {
        this.id_segmento = id_segmento;
        this.nombre_segmento = nombre_segmento;
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public char getId_segmento() {
        return id_segmento;
    }

    public void setId_segmento(char id_segmento) {
        this.id_segmento = id_segmento;
    }

    public String getNombre_segmento() {
        return nombre_segmento;
    }

    public void setNombre_segmento(String nombre_segmento) {
        this.nombre_segmento = nombre_segmento;
    }

    public double getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(double porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public void registrar() {

    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void imprimir() {

    }

}
