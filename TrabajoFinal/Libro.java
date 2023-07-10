package TrabajoFinal;
import java.util.ArrayList;
import java.util.Iterator;

public class Libro extends Producto {
    private int id_libro;
    private String ISBN;
    private String NombreTitulo;
    private int id_proveedor;
    private String edicion;
    private String autor;
    private int id_categoria;

    public Libro(int id_producto, double precio, String tipoProducto, int id_libro, String ISBN, String nombreTitulo, int id_proveedor, String edicion, String autor, int id_categoria) {
        super(id_producto, precio, tipoProducto);
        this.id_libro = id_libro;
        this.ISBN = ISBN;
        this.NombreTitulo = nombreTitulo;
        this.id_proveedor = id_proveedor;
        this.edicion = edicion;
        this.autor = autor;
        this.id_categoria = id_categoria;
    }

    private ArrayList<Libro> listaLibro;

    public ArrayList<Libro> getListaLibro() {
        return listaLibro;
    }

    public void setListaLibro(ArrayList<Libro> listaLibro) {
        this.listaLibro = listaLibro;
    }

    public void modificar(int idProducto, double nuevoPrecio, String nuevoTipoProducto, int idLibro, String nuevoISBN,
                          String nuevoNombreTitulo, int idProveedor, String nuevaEdicion, String nuevoAutor,
                          int nuevoIdCategoria,ArrayList<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            if (libro.getId_producto() == idProducto) {
                libro.setPrecio(nuevoPrecio);
                libro.setTipoProducto(nuevoTipoProducto);
                libro.setId_libro(idLibro);
                libro.setISBN(nuevoISBN);
                libro.setNombreTitulo(nuevoNombreTitulo);
                libro.setId_proveedor(idProveedor);
                libro.setEdicion(nuevaEdicion);
                libro.setAutor(nuevoAutor);
                libro.setId_categoria(nuevoIdCategoria);
            }
        }
        this.setListaLibro(listaLibros);
    }
    public void cargaInicial() {
        ArrayList<Libro> listaLibros = new ArrayList<>();

        Libro libro1 = new Libro(1, 10.99, "Tipo 1", 1, "ISBN1", "Título 1", 1, "Edición 1", "Autor 1", 1);
        Libro libro2 = new Libro(2, 19.99, "Tipo 2", 2, "ISBN2", "Título 2", 2, "Edición 2", "Autor 2", 2);
        Libro libro3 = new Libro(3, 14.99, "Tipo 1", 3, "ISBN3", "Título 3", 3, "Edición 3", "Autor 3", 3);
        Libro libro4 = new Libro(4, 9.99, "Tipo 2", 4, "ISBN4", "Título 4", 1, "Edición 4", "Autor 4", 1);
        Libro libro5 = new Libro(5, 12.99, "Tipo 1", 5, "ISBN5", "Título 5", 2, "Edición 5", "Autor 5", 2);
        Libro libro6 = new Libro(6, 17.99, "Tipo 2", 6, "ISBN6", "Título 6", 3, "Edición 6", "Autor 6", 3);
        Libro libro7 = new Libro(7, 8.99, "Tipo 1", 7, "ISBN7", "Título 7", 1, "Edición 7", "Autor 7", 1);
        Libro libro8 = new Libro(8, 13.99, "Tipo 2", 8, "ISBN8", "Título 8", 2, "Edición 8", "Autor 8", 2);
        Libro libro9 = new Libro(9, 11.99, "Tipo 1", 9, "ISBN9", "Título 9", 3, "Edición 9", "Autor 9", 3);
        Libro libro10 = new Libro(10, 16.99, "Tipo 2", 10, "ISBN10", "Título 10", 1, "Edición 10", "Autor 10", 1);

        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        listaLibros.add(libro4);
        listaLibros.add(libro5);
        listaLibros.add(libro6);
        listaLibros.add(libro7);
        listaLibros.add(libro8);
        listaLibros.add(libro9);
        listaLibros.add(libro10);

        this.setListaLibro(listaLibros);
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

    @Override
    public void registrar(Libro libro, ArrayList<Libro> listaLibros) {
        listaLibros.add(libro);
        this.setListaLibro(listaLibros);
    }

       @Override
    public void modificar(int idLibro, String nuevoISBN, String nuevoNombreTitulo, int nuevoIdProveedor, String nuevaEdicion,
                          String nuevoAutor, int nuevoIdCategoria, ArrayList<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            if (libro.getId_libro() == idLibro) {
                libro.setISBN(nuevoISBN);
                libro.setNombreTitulo(nuevoNombreTitulo);
                libro.setId_proveedor(nuevoIdProveedor);
                libro.setEdicion(nuevaEdicion);
                libro.setAutor(nuevoAutor);
                libro.setId_categoria(nuevoIdCategoria);
            }
        }
        this.setListaLibro(listaLibros);
    }
    @Override
    public void eliminar(int idLibro, ArrayList<Libro> listaLibros) {
        Iterator<Libro> iterator = listaLibros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getId_libro() == idLibro) {
                iterator.remove(); // Eliminar el elemento de manera segura
            }
        }
        setListaLibro(listaLibros); // Actualizar el ArrayList listaLibros
    }
    @Override
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
