package TrabajoFinal;

import java.util.ArrayList;
import java.util.Iterator;

public class Segmento {
    private char id_segmento;
    private String nombre_segmento;
    private double porcentaje_descuento;

    private ArrayList<Segmento> listaSegmentos = new ArrayList<>();

    public Segmento(char id_segmento, String nombre_segmento, double porcentaje_descuento) {
        this.id_segmento = id_segmento;
        this.nombre_segmento = nombre_segmento;
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public ArrayList<Segmento> getListaSegmentos() {
        return listaSegmentos;
    }

    public void setListaSegmentos(ArrayList<Segmento> listaSegmentos) {
        this.listaSegmentos = listaSegmentos;
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

    /*
    public void registrar() {
        System.out.println("Segmento registrado correctamente.");
    }
*/
    public void registrar(Segmento segmento, ArrayList<Segmento> listaSegmentos) {
        listaSegmentos.add(segmento);
        setListaSegmentos(listaSegmentos);
    }
    /*
    public void modificar() {
        System.out.println("Segmento modificado correctamente.");
    }*/
    public void modificar(char idSegmento, String nuevoNombreSegmento, double nuevoPorcentajeDescuento, ArrayList<Segmento> listaSegmentos) {
        for (Segmento segmento : listaSegmentos) {
            if (segmento.getId_segmento() == idSegmento) {
                segmento.setNombre_segmento(nuevoNombreSegmento);
                segmento.setPorcentaje_descuento(nuevoPorcentajeDescuento);
            }
        }
        this.setListaSegmentos(listaSegmentos); // Actualizar la lista de segmentos
    }

    /*
    public void eliminar(ArrayList<Segmento> data) {
        System.out.println("Segmento eliminado correctamente.");
    }
*/
    public void eliminar(char idSegmento, ArrayList<Segmento> listaSegmentos) {
        Iterator<Segmento> iterator = listaSegmentos.iterator();
        while (iterator.hasNext()) {
            Segmento segmento = iterator.next();
            if (segmento.getId_segmento() == idSegmento) {
                iterator.remove(); // Eliminar el elemento de manera segura
            }
        }
        setListaSegmentos(listaSegmentos); // Actualizar el ArrayList listaSegmentos
    }

    public void imprimir() {
        System.out.println("ID Segmento: " + id_segmento);
        System.out.println("Nombre Segmento: " + nombre_segmento);
        System.out.println("Porcentaje de Descuento: " + porcentaje_descuento);
    }

    public ArrayList<Segmento> modificar(ArrayList<Segmento> data) {
        return null;
    }

    public void cargaInicial() {
        ArrayList<Segmento> listaSegmentos = new ArrayList<>();

        Segmento segmento1 = new Segmento('A', "Segmento 1", 0.1);
        Segmento segmento2 = new Segmento('B', "Segmento 2", 0.2);
        Segmento segmento3 = new Segmento('C', "Segmento 3", 0.3);
        Segmento segmento4 = new Segmento('D', "Segmento 4", 0.4);
        Segmento segmento5 = new Segmento('E', "Segmento 5", 0.5);
        Segmento segmento6 = new Segmento('F', "Segmento 6", 0.6);
        Segmento segmento7 = new Segmento('G', "Segmento 7", 0.7);
        Segmento segmento8 = new Segmento('H', "Segmento 8", 0.8);
        Segmento segmento9 = new Segmento('I', "Segmento 9", 0.9);
        Segmento segmento10 = new Segmento('J', "Segmento 10", 1.0);

        listaSegmentos.add(segmento1);
        listaSegmentos.add(segmento2);
        listaSegmentos.add(segmento3);
        listaSegmentos.add(segmento4);
        listaSegmentos.add(segmento5);
        listaSegmentos.add(segmento6);
        listaSegmentos.add(segmento7);
        listaSegmentos.add(segmento8);
        listaSegmentos.add(segmento9);
        listaSegmentos.add(segmento10);

        this.setListaSegmentos(listaSegmentos);
    }

}
