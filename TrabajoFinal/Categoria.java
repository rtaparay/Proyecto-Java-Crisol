package TrabajoFinal;
import java.util.ArrayList;
import java.util.Iterator;

public class Categoria {
    private int id_categoria;
    private String nombreCategoria;

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    private ArrayList<Categoria> listaCategorias;


    public Categoria(int id_categoria, String nombreCategoria) {
        this.id_categoria = id_categoria;
        this.nombreCategoria = nombreCategoria;
    }
    public void cargaInicial() {
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        Categoria categoria1 = new Categoria(1, "LITERATURA");
        Categoria categoria2 = new Categoria(2, "NEGOCIOS Y EMPRENDIMIENTO");
        Categoria categoria3 = new Categoria(3, "INFANTIL");
        Categoria categoria4 = new Categoria(4, "PSICOLOGIA");
        Categoria categoria5 = new Categoria(5, "SALUD, BIENESTAR Y AUTOAYUDA");
        Categoria categoria6 = new Categoria(6, "MARKETING Y ADMINISTRACIÓN");
        Categoria categoria7 = new Categoria(7, "TECNOLOGÍA");
        Categoria categoria8 = new Categoria(8, "Categoría8");
        Categoria categoria9 = new Categoria(9, "Categoría9");
        Categoria categoria10 = new Categoria(10, "Categoría10");
        listaCategorias.add(categoria1);
        listaCategorias.add(categoria2);
        listaCategorias.add(categoria3);
        listaCategorias.add(categoria4);
        listaCategorias.add(categoria5);
        listaCategorias.add(categoria6);
        listaCategorias.add(categoria7);
        listaCategorias.add(categoria8);
        listaCategorias.add(categoria9);
        listaCategorias.add(categoria10);
        this.setListaCategorias(listaCategorias);
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

    
 public void registrar(Categoria categoria, ArrayList<Categoria> listaCategorias) {
        listaCategorias.add(categoria);
        setListaCategorias(listaCategorias); // Actualizar el ArrayList listaCategorias
    }

    public void modificar(int idCategoria, String nuevoNombre, ArrayList<Categoria> listaCategorias) {
        for (Categoria categoria : listaCategorias) {
            if (categoria.getId_categoria() == idCategoria) {
                categoria.setNombreCategoria(nuevoNombre);
            }
        }
        this.setListaCategorias(listaCategorias); // Actualizar el ArrayList listaCategorias
    }

    public void eliminar(int idCategoria, ArrayList<Categoria> listaCategorias) {
        Iterator<Categoria> iterator = listaCategorias.iterator();
        while (iterator.hasNext()) {
            Categoria categoria = iterator.next();
            if (categoria.getId_categoria() == idCategoria) {
                iterator.remove(); // Eliminar el elemento de manera segura
            }
        }
        setListaCategorias(listaCategorias); // Actualizar el ArrayList listaCategorias
    }

    public void imprimir() {
        System.out.println("Detalles de la categoría:");
        System.out.println("ID: " + id_categoria);
        System.out.println("Nombre: " + nombreCategoria);

    }
}
