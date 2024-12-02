package Model.Usuario;

public class Login {
    private String idUsuario;
    private String idAgente;
    private String usuario;
    private String nombre;

    public Login() {
    }

    public Login(String idUsuario, String idAgente, String usuario, String nombre) {
        this.idUsuario = idUsuario;
        this.idAgente = idAgente;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
