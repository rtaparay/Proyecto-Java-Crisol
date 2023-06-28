package TrabajoFinal;

public class TiendaEcommerce extends Tienda {
    private String proveedorCloud;
    private double costoMantenimiento;

    public TiendaEcommerce(int id_tienda, String RUC, String tipoTienda, String nombreTienda, int trafico,
                           String proveedorCloud, double costoMantenimiento) {
        super(id_tienda, RUC, tipoTienda, nombreTienda, trafico);
        this.proveedorCloud = proveedorCloud;
        this.costoMantenimiento = costoMantenimiento;
    }

    public String getProveedorCloud() {
        return proveedorCloud;
    }

    public void setProveedorCloud(String proveedorCloud) {
        this.proveedorCloud = proveedorCloud;
    }

    public double getCostoMantenimiento() {
        return costoMantenimiento;
    }

    public void setCostoMantenimiento(double costoMantenimiento) {
        this.costoMantenimiento = costoMantenimiento;
    }

    public void registrar() {

    }

    public void imprimir() {
        super.imprimir();

        System.out.println("Proveedor Cloud: " +  this.getProveedorCloud());
        System.out.println("Costo de mantenimiento: S/. " +  this.getCostoMantenimiento());
    }

}
