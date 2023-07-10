package TrabajoFinal;

import java.util.ArrayList;

public class Tienda {
    private int id_tienda;
    private String RUC;
    private String tipoTienda;
    private String nombreTienda;
    private int trafico;

    public Tienda(int id_tienda, String RUC, String tipoTienda, String nombreTienda, int trafico) {
        this.id_tienda = id_tienda;
        this.RUC = RUC;
        this.tipoTienda = tipoTienda;
        this.nombreTienda = nombreTienda;
        this.trafico = trafico;
    }

    public Tienda() {

    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(String tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public int getTrafico() {
        return trafico;
    }

    public void setTrafico(int trafico) {
        this.trafico = trafico;
    }

    public void registrar() {}
    public void modificar() {}

    public void eliminar() {}
    public void imprimir() {}
}