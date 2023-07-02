package TrabajoFinal;

public class TiendaFisica extends Tienda {
    private double m2;
    private String distrito;
    private boolean centroComercial;
    private double costoAlquiler;

    public TiendaFisica(int id_tienda, String RUC, String tipoTienda, String nombreTienda, int trafico,
                        double m2, String distrito, boolean centroComercial, double costoAlquiler) {
        super(id_tienda, RUC, tipoTienda, nombreTienda, trafico);
        this.m2 = m2;
        this.distrito = distrito;
        this.centroComercial = centroComercial;
        this.costoAlquiler = costoAlquiler;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public boolean isCentroComercial() {
        return centroComercial;
    }

    public void setCentroComercial(boolean centroComercial) {
        this.centroComercial = centroComercial;
    }

    public double getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setCostoAlquiler(double costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
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