package Model.Usuario;

public class Usuario {
    private String idUsuario;
    private String usuario;
    private String password;
    private String correo;
    private String idAgente;

    public Usuario() {

    }
    public Usuario(String idUsuario, String usuario, String password, String correo, String idAgente) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.idAgente = idAgente;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

}
