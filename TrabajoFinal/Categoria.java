package TrabajoFinal;

public class Categoria {
    private int id_categoria;
    private String nombreCategoria;

    public Categoria(int id_categoria, String nombreCategoria) {
        this.id_categoria = id_categoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void registrar() {

    }

    public void imprimir() {
        System.out.println("Id categoría: " + Integer.toString(this.getId_categoria()));
        System.out.println("Nombre categoría: " + this.getNombreCategoria());
    }
}
