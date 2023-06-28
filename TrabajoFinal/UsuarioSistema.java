package TrabajoFinal;

public class UsuarioSistema {
    private String id_usuario;
    private String nombre;
    private String password;
    private String tipoUsuario;
    private String estado;

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
}
