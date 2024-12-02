package Service.Usuario;

import Model.Usuario.Login;
import Model.Usuario.Usuario;
import Model.Usuario.csUsuario;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "srvUsuario")
public class srvUsuario {
    @WebMethod(operationName = "insertarUsuario")
    public int insertarUsuario(String idUsuario, String nombre, String password, String correo, String idAgente) {
        csUsuario u = new csUsuario();
        return u.insertarUsuario(idUsuario, nombre, password, correo, idAgente);
    }

    @WebMethod(operationName = "actualizarUsuario")
    public int actualizarUsuario(String idUsuario, String nombre, String password, String correo, String idAgente) {
        csUsuario u = new csUsuario();
        return u.actualizarUsuario(idUsuario, nombre, password, correo, idAgente);
    }

    @WebMethod(operationName = "eliminarUsuario")
    public int eliminarUsuario(String idUsuario) {
        csUsuario u = new csUsuario();
        return u.eliminarUsuario(idUsuario);
    }

    @WebMethod(operationName = "listarUsuarios")
    public ArrayList<Usuario> listarUsuarios() {
        csUsuario u = new csUsuario();
        return u.listarUsuario();
    }

    @WebMethod(operationName = "buscarUsuario")
    public Usuario buscarUsuario(String idUsuario) {
        csUsuario u = new csUsuario();
        return u.buscarUsuario(idUsuario);
    }
    @WebMethod(operationName = "autenticarUsuario")
    public Login autenticarUsuario(String usuario, String password) {
        csUsuario u = new csUsuario();
        return u.autenticarUsuario(usuario, password);
    }
}
