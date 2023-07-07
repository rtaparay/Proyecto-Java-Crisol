package TrabajoFinal;

import java.util.ArrayList;

public class Tienda {
    protected int id_tienda;
    protected String RUC;
    protected String tipoTienda;
    protected String nombreTienda;
    protected int trafico;

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