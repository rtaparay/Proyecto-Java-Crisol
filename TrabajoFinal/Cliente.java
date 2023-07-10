package TrabajoFinal;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {
    private int id_cliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int recency;
    private int frecuency;
    private double monetaryValue;
    private int RFM_score;
    private char id_segmento;

    private ArrayList<Cliente> listaClientes;

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente(int id_cliente, String nombre, String apellidoPaterno, String apellidoMaterno, int recency, int frecuency, double monetaryValue, int RFM_score, char id_segmento) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.recency = recency;
        this.frecuency = frecuency;
        this.monetaryValue = monetaryValue;
        this.RFM_score = RFM_score;
        this.id_segmento = id_segmento;
    }

    public Cliente() {

    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getRecency() {
        return recency;
    }

    public void setRecency(int recency) {
        this.recency = recency;
    }

    public int getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
    }

    public double getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(double monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    public int getRFM_score() {
        return RFM_score;
    }

    public void setRFM_score(int RFM_score) {
        this.RFM_score = RFM_score;
    }

    public char getId_segmento() {
        return id_segmento;
    }

    public void setId_segmento(char id_segmento) {
        this.id_segmento = id_segmento;
    }

    public void registrar(Cliente cliente, ArrayList<Cliente> listaClientes) {
        listaClientes.add(cliente);
        this.setListaClientes(listaClientes);
    }
    public void modificar(int idCliente, String nuevoNombre, String nuevoApellidoPaterno, String nuevoApellidoMaterno,
                          int nuevaRecency, int nuevaFrecency, double nuevoMonetaryValue, int nuevoRFM_score,
                          char nuevoIdSegmento,ArrayList<Cliente> listaClientes) {
        for (Cliente cliente1 : listaClientes) {
            if (cliente1.getId_cliente() == idCliente) {
                cliente1.setNombre(nuevoNombre);
                cliente1.setApellidoPaterno(nuevoApellidoPaterno);
                cliente1.setApellidoMaterno(nuevoApellidoMaterno);
                cliente1.setRecency(nuevaRecency);
                cliente1.setFrecuency(nuevaFrecency);
                cliente1.setMonetaryValue(nuevoMonetaryValue);
                cliente1.setRFM_score(nuevoRFM_score);
                cliente1.setId_segmento(nuevoIdSegmento);
            }
        }
        this.setListaClientes(listaClientes);
    }
    public void eliminar(int idCliente, ArrayList<Cliente> listaClientes) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getId_cliente() == idCliente) {
                iterator.remove(); // Eliminar el elemento de manera segura
            }
        }
        setListaClientes(listaClientes); // Actualizar la lista de clientes
    }

    public void imprimir() {
        System.out.println("ID Cliente: " + id_cliente);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido Paterno: " + apellidoPaterno);
        System.out.println("Apellido Materno: " + apellidoMaterno);
        System.out.println("Recency: " + recency);
        System.out.println("Frecuency: " + frecuency);
        System.out.println("Monetary Value: " + monetaryValue);
        System.out.println("RFM Score: " + RFM_score);
        System.out.println("ID Segmento: " + id_segmento);
    }

    public ArrayList<Cliente> modificar(ArrayList<Cliente> data) {
        return null;
    }

    public void cargaInicial() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente1 = new Cliente(1, "Cliente1", "Apellido1", "Apellido2", 10, 5, 100.0, 5, 'A');
        Cliente cliente2 = new Cliente(2, "Cliente2", "Apellido1", "Apellido2", 5, 3, 50.0, 3, 'B');
        Cliente cliente3 = new Cliente(3, "Cliente3", "Apellido1", "Apellido2", 2, 1, 10.0, 1, 'C');
        Cliente cliente4 = new Cliente(4, "Cliente4", "Apellido1", "Apellido2", 8, 4, 80.0, 4, 'A');
        Cliente cliente5 = new Cliente(5, "Cliente5", "Apellido1", "Apellido2", 6, 2, 60.0, 2, 'B');
        Cliente cliente6 = new Cliente(6, "Cliente6", "Apellido1", "Apellido2", 4, 1, 40.0, 1, 'C');
        Cliente cliente7 = new Cliente(7, "Cliente7", "Apellido1", "Apellido2", 9, 5, 90.0, 5, 'A');
        Cliente cliente8 = new Cliente(8, "Cliente8", "Apellido1", "Apellido2", 7, 3, 70.0, 3, 'B');
        Cliente cliente9 = new Cliente(9, "Cliente9", "Apellido1", "Apellido2", 3, 2, 30.0, 2, 'C');
        Cliente cliente10 = new Cliente(10, "Cliente10", "Apellido1", "Apellido2", 10, 4, 100.0, 4, 'A');
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        listaClientes.add(cliente4);
        listaClientes.add(cliente5);
        listaClientes.add(cliente6);
        listaClientes.add(cliente7);
        listaClientes.add(cliente8);
        listaClientes.add(cliente9);
        listaClientes.add(cliente10);
        this.setListaClientes(listaClientes);
    }
}
