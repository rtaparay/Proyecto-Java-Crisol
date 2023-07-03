package TrabajoFinal;

public class Categoria {
    private int id_categoria;
    private String nombreCategoria;
    private String libros;
    private String productos;

    public Categoria(int id_categoria, String nombreCategoria, String libros, String productos) {
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
    public String getLibros() {
        return libros;
    }

    public void setLibros(String libros) {
        this.libros = libros;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
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
