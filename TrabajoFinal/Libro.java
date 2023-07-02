package TrabajoFinal;

public class Libro extends Producto {
    private int id_libro;
    private String ISBN;
    private String NombreTitulo;
    private int id_proveedor;
    private String edicion;
    private String autor;
    private int id_categoria;


    public Libro(int id_producto, double precio, String tipoProducto,
                 int id_libro, String ISBN, String nombreTitulo, int id_proveedor, String edicion, String autor, int id_categoria) {
        super(id_producto, precio, tipoProducto);
        this.id_libro = id_libro;
        this.ISBN = ISBN;
        NombreTitulo = nombreTitulo;
        this.id_proveedor = id_proveedor;
        this.edicion = edicion;
        this.autor = autor;
        this.id_categoria = id_categoria;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombreTitulo() {
        return NombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        NombreTitulo = nombreTitulo;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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