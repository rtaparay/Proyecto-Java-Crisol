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

    public ArrayList<Cliente> modificar(ArrayList<Cliente> data) {
        return null;
    }

    public void cargaInicial() {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Cliente cliente1 = new Cliente(1, "SERGIO", "AYESTA", "RAMOS", 3, 1, 350.0, 0, ' ');
        Cliente cliente2 = new Cliente(2, "HUBERT", "GUERRERO", " ", 10, 4, 250.0, 0, ' ');
        Cliente cliente3 = new Cliente(3, "RAUL", "TAPARA", " ", 8, 5, 170.0, 0, ' ');
        Cliente cliente4 = new Cliente(4, "ALBERTO", "PRADO", " ", 15, 6, 80.0, 0, ' ');
        Cliente cliente5 = new Cliente(5, "JAMES", "HUIZA", " ", 8, 3, 30.0, 0, ' ');
        Cliente cliente6 = new Cliente(6, "JOAN", "SERRATO", " ", 5, 2, 40.0, 0, ' ');
        Cliente cliente7 = new Cliente(7, "Cliente7", "Apellido1", "Apellido2", 3, 3, 70.0, 0, ' ');
        Cliente cliente8 = new Cliente(8, "Cliente8", "Apellido1", "Apellido2", 2, 1, 180.0, 0, ' ');
        Cliente cliente9 = new Cliente(9, "Cliente9", "Apellido1", "Apellido2", 1, 2, 290.0, 0, ' ');
        Cliente cliente10 = new Cliente(10, "Cliente10", "Apellido1", "Apellido2", 1, 8, 400.0, 0, ' ');
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

    public void actualizarScoreRFM(ArrayList<Cliente> listaClientes) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        int puntajeR = 0;
        int puntajeF = 0;
        int puntajeM = 0;
        String puntajeConcatenado;
        int puntajeRFM = 0;

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();

            //Puntaje R
            if (cliente.getRecency() == 1) {
                puntajeR = 5;
            } else if (cliente.getRecency() >= 2 && cliente.getRecency() <= 3) {
                puntajeR = 4;
            } else if (cliente.getRecency() >= 4 && cliente.getRecency() <= 6) {
                puntajeR = 3;
            } else if (cliente.getRecency() >= 7 && cliente.getRecency() <= 12) {
                puntajeR = 2;
            } else if (cliente.getRecency() > 12) {
                puntajeR = 1;
            }

            //Puntaje F
            if (cliente.getFrecuency() == 1) {
                puntajeF = 5;
            } else if (cliente.getFrecuency() == 2) {
                puntajeF = 4;
            } else if (cliente.getFrecuency() == 3) {
                puntajeF = 3;
            } else if (cliente.getFrecuency() >= 4 && cliente.getFrecuency() <= 6) {
                puntajeF = 2;
            } else if (cliente.getFrecuency() >= 7) {
                puntajeF = 1;
            }

            //Puntaje M
            if (cliente.getMonetaryValue() > 300) {
                puntajeM = 5;
            } else if (cliente.getMonetaryValue() >= 200 && cliente.getMonetaryValue() <= 300) {
                puntajeM = 4;
            } else if (cliente.getMonetaryValue() >= 100 && cliente.getMonetaryValue() <= 199) {
                puntajeM = 3;
            } else if (cliente.getMonetaryValue() >= 50 && cliente.getMonetaryValue() <= 99) {
                puntajeM = 2;
            } else if (cliente.getMonetaryValue() < 50) {
                puntajeM = 1;
            }

            puntajeConcatenado = Integer.toString(puntajeR) + Integer.toString(puntajeF) + Integer.toString(puntajeM);
            puntajeRFM =  Integer.valueOf(puntajeConcatenado);
            cliente.setRFM_score(puntajeRFM);
        }
        setListaClientes(listaClientes); // Actualizar la lista de clientes masivamente con su SCORE RFM

    }

    public void actualizarSegmento(ArrayList<Cliente> listaClientes) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        char segmento = 'X';

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();

            if (cliente.getRFM_score() >= 500 && cliente.getRFM_score() <= 555) {
                segmento = 'A';
            } else if (cliente.getRFM_score() >= 400 && cliente.getRFM_score() <= 499) {
                segmento = 'B';
            } else {
                segmento = 'C';
            }

            cliente.setId_segmento(segmento);
        }
        setListaClientes(listaClientes); // Actualizar la lista de clientes masivamente con su SEGMENTO
    }
    public char buscaSegmento(int id_cliente, ArrayList<Cliente> clientes){
        char id_segmento= ' ';
        for (Cliente cliente1 : clientes) {
            if (cliente1.getId_cliente() == id_cliente) {
                id_segmento = cliente1.getId_segmento();
            }
        }
        return id_segmento;
    }
}
