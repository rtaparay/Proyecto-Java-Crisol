package TrabajoFinal;

import java.util.ArrayList;

public class Segmento {
    private char id_segmento;
    private String nombre_segmento;
    private double porcentaje_descuento;

    public Segmento(char id_segmento, String nombre_segmento, double porcentaje_descuento) {
        this.id_segmento = id_segmento;
        this.nombre_segmento = nombre_segmento;
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public Segmento() {

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
        System.out.println("Segmento registrado correctamente.");
    }

    public void modificar() {
        System.out.println("Segmento modificado correctamente.");
    }

    public void eliminar(ArrayList<Segmento> data) {
        System.out.println("Segmento eliminado correctamente.");
    }

    public void imprimir() {
        System.out.println("ID Segmento: " + id_segmento);
        System.out.println("Nombre Segmento: " + nombre_segmento);
        System.out.println("Porcentaje de Descuento: " + porcentaje_descuento);
    }

    public ArrayList<Segmento> modificar(ArrayList<Segmento> data) {
        return null;
    }
}
