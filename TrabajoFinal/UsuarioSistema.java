package TrabajoFinal;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioSistema {
    private String id_usuario;
    private String nombre;
    private String password;
    private String tipoUsuario;
    private String estado;

    public ArrayList<UsuarioSistema> getLuser() {
        return luser;
    }

    public void setLuser(ArrayList<UsuarioSistema> luser) {
        this.luser = luser;
    }

    private ArrayList<UsuarioSistema> luser;

    public UsuarioSistema(String id_usuario, String nombre, String password, String tipoUsuario, String estado) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void registrar(UsuarioSistema usuario, ArrayList<UsuarioSistema> luser) {
        this.luser.add(usuario);
        this.setLuser(luser);
    }

    public void modificar(String idUsuario, String nuevoNombre, String nuevoPassword, String nuevoTipoUsuario,
                                 String nuevoEstado, ArrayList<UsuarioSistema> listaUsuarios) {
        for (UsuarioSistema usuario : listaUsuarios) {
            if (usuario.getId_usuario().equals(idUsuario)) {
                usuario.setNombre(nuevoNombre);
                usuario.setPassword(nuevoPassword);
                usuario.setTipoUsuario(nuevoTipoUsuario);
                usuario.setEstado(nuevoEstado);

            }
        }
        this.setLuser(listaUsuarios);

    }

    public void eliminar(String idUsuario, ArrayList<UsuarioSistema> listaUsuarios) {
        Iterator<UsuarioSistema> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            UsuarioSistema usuario = iterator.next();
            if (usuario.getId_usuario().equals(idUsuario)) {
                iterator.remove(); // Eliminar el elemento de manera segura
            }
        }
        setLuser(listaUsuarios); // Actualizar el ArrayList luser
    }
    // Método imprimir
    //TODO este metodo deberiamos revisarlo ya que es para impresion en modo consola
    public void imprimir(ArrayList<UsuarioSistema> listaUsuarios) {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (UsuarioSistema usuario : listaUsuarios) {
                System.out.println("ID: " + usuario.getId_usuario());
                System.out.println("Nombre: " + usuario.getNombre());
                System.out.println("Password: " + usuario.getPassword());
                System.out.println("Tipo de usuario: " + usuario.getTipoUsuario());
                System.out.println("Estado: " + usuario.getEstado());
                System.out.println("------------------------");
            }
        }
    }

    // Método de carga inicial
    public void cargaInicial() {
        ArrayList<UsuarioSistema> listaUsuarios = new ArrayList<>();
        UsuarioSistema usuario1 = new UsuarioSistema("ID_1", "Usuario1", "password1", "Tipo1", "Activo");
        UsuarioSistema usuario2 = new UsuarioSistema("ID_2", "Usuario2", "password2", "Tipo2", "Activo");
        UsuarioSistema usuario3 = new UsuarioSistema("ID_3", "Usuario3", "password3", "Tipo3", "Inactivo");
        UsuarioSistema usuario4 = new UsuarioSistema("ID_4", "Usuario4", "password4", "Tipo1", "Activo");
        UsuarioSistema usuario5 = new UsuarioSistema("ID_5", "Usuario5", "password5", "Tipo2", "Inactivo");
        UsuarioSistema usuario6 = new UsuarioSistema("ID_6", "Usuario6", "password6", "Tipo3", "Activo");
        UsuarioSistema usuario7 = new UsuarioSistema("ID_7", "Usuario7", "password7", "Tipo1", "Activo");
        UsuarioSistema usuario8 = new UsuarioSistema("ID_8", "Usuario8", "password8", "Tipo2", "Inactivo");
        UsuarioSistema usuario9 = new UsuarioSistema("ID_9", "Usuario9", "password9", "Tipo3", "Activo");
        UsuarioSistema usuario10 = new UsuarioSistema("ID_10", "Usuario10", "password10", "Tipo1", "Activo");
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
        listaUsuarios.add(usuario4);
        listaUsuarios.add(usuario5);
        listaUsuarios.add(usuario6);
        listaUsuarios.add(usuario7);
        listaUsuarios.add(usuario8);
        listaUsuarios.add(usuario9);
        listaUsuarios.add(usuario10);
        this.setLuser(listaUsuarios);
    }
    public ArrayList<UsuarioSistema> Lista(ArrayList<UsuarioSistema> listaUsuarios) {
        listaUsuarios = this.getLuser();
        return listaUsuarios;
    }

}