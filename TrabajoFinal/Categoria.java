package TrabajoFinal;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la categoría: ");
        id_categoria = scanner.nextInt();

        System.out.println("Ingrese el nombre de la categoría: ");
        scanner.nextLine();
        nombreCategoria = scanner.nextLine();

        System.out.println("Ingrese la información de libros relacionados: ");
        libros = scanner.nextLine();

        System.out.println("Ingrese la información de productos relacionados: ");
        productos = scanner.nextLine();

        System.out.println("La categoría ha sido registrada con éxito.");

    }

    public void modificar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nuevo nombre de la categoría: ");
        nombreCategoria = scanner.nextLine();

        System.out.println("Ingrese la nueva información de libros relacionados: ");
        libros = scanner.nextLine();

        System.out.println("Ingrese la nueva información de productos relacionados: ");
        productos = scanner.nextLine();

        System.out.println("La categoría ha sido modificada con éxito.");

    }

    public void eliminar() {
        id_categoria = 0;
        nombreCategoria = "";
        libros = "";
        productos = "";

        System.out.println("La categoría ha sido eliminada.");

    }

    public void imprimir() {
        System.out.println("Detalles de la categoría:");
        System.out.println("ID: " + id_categoria);
        System.out.println("Nombre: " + nombreCategoria);
        System.out.println("Libros: " + libros);
        System.out.println("Productos: " + productos);

    }
}
