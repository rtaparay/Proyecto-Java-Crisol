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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del libro: ");
        id_libro = scanner.nextInt();

        System.out.println("Ingrese el ISBN del libro: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        ISBN = scanner.nextLine();

        System.out.println("Ingrese el nombre/título del libro: ");
        NombreTitulo = scanner.nextLine();

        System.out.println("Ingrese el ID del proveedor del libro: ");
        id_proveedor = scanner.nextInt();

        System.out.println("Ingrese la edición del libro: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        edicion = scanner.nextLine();

        System.out.println("Ingrese el autor del libro: ");
        autor = scanner.nextLine();

        System.out.println("Ingrese el ID de la categoría del libro: ");
        id_categoria = scanner.nextInt();

        System.out.println("El libro ha sido registrado con éxito.");
    }

    public void modificar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nuevo ISBN del libro: ");
        ISBN = scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre/título del libro: ");
        NombreTitulo = scanner.nextLine();

        System.out.println("Ingrese el nuevo ID del proveedor del libro: ");
        id_proveedor = scanner.nextInt();

        System.out.println("Ingrese la nueva edición del libro: ");
        scanner.nextLine(); // Limpiar el buffer de entrada
        edicion = scanner.nextLine();

        System.out.println("Ingrese el nuevo autor del libro: ");
        autor = scanner.nextLine();

        System.out.println("Ingrese el nuevo ID de la categoría del libro: ");
        id_categoria = scanner.nextInt();

        System.out.println("El libro ha sido modificado con éxito.");
    }

    public void eliminar() {
        id_libro = 0;
        ISBN = "";
        NombreTitulo = "";
        id_proveedor = 0;
        edicion = "";
        autor = "";
        id_categoria = 0;

        System.out.println("El libro ha sido eliminado.");
    }

    public void imprimir() {
        System.out.println("Detalles del libro:");
        System.out.println("ID: " + id_libro);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Nombre/Título: " + NombreTitulo);
        System.out.println("ID del proveedor: " + id_proveedor);
        System.out.println("Edición: " + edicion);
        System.out.println("Autor: " + autor);
        System.out.println("ID de la categoría: " + id_categoria);
    }
    
}
