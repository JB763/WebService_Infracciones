package Model.Usuario;

import Model.Conexion.csConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class csUsuario {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    public csUsuario() {
        con = null;
        pst = null;
        rs = null;
    }

    public int insertarUsuario(String idUsuario, String usuario, String password, String correo, String idAgente) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "INSERT INTO Usuario (idUsuario, usuario, contraseña, correo, idAgente) VALUES (?, ?, ?, ?, ?)";

        try {
            pst = con.prepareStatement(query);
            if (con != null) {
                pst.setString(1, idUsuario);
                pst.setString(2, usuario);
                pst.setString(3, password);
                pst.setString(4, correo);
                pst.setString(5, idAgente);

                respuesta = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public int actualizarUsuario(String idUsuario, String usuario, String password, String correo, String idAgente) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "UPDATE Usuario SET usuario = ?, contraseña = ?, correo = ?, idAgente = ? WHERE idUsuario = ?";

        try {
            pst = con.prepareStatement(query);
            if (con != null) {
                pst.setString(1, usuario);
                pst.setString(2, password);
                pst.setString(3, correo);
                pst.setString(4, idAgente);
                pst.setString(5, idUsuario);

                respuesta = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public int eliminarUsuario(String idUsuario) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "DELETE FROM Usuario WHERE idUsuario = ?";

        try {
            pst = con.prepareStatement(query);
            if (con != null) {
                pst.setString(1, idUsuario);

                respuesta = pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public ArrayList<Usuario> listarUsuario() {
        Usuario u;
        ArrayList<Usuario> lista = new ArrayList<>();
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "SELECT * FROM Usuario";

        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getString("idUsuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setpassword(rs.getString("contraseña"));
                u.setCorreo(rs.getString("correo"));
                u.setIdAgente(rs.getString("idAgente"));

                lista.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Usuario buscarUsuario(String idUsuario) {
        Usuario u = null;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "SELECT * FROM Usuario WHERE idUsuario = ?";

        try {
            pst = con.prepareStatement(query);
            pst.setString(1, idUsuario);
            rs = pst.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setIdUsuario(rs.getString("idUsuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setpassword(rs.getString("contraseña"));
                u.setCorreo(rs.getString("correo"));
                u.setIdAgente(rs.getString("idAgente"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return u;
    }
    public Login autenticarUsuario(String usuario, String password){
        Login u = null;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;
        String query = "SELECT a.idAgente, a.nombre, u.idUsuario, u.usuario " +
                "FROM agente a INNER JOIN usuario u ON a.idAgente = u.idAgente " +
                "WHERE u.usuario = ? AND u.contraseña = ?";

        try {
            pst = con.prepareStatement(query);
            pst.setString(1, usuario);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                u = new Login();
                u.setIdUsuario(rs.getString("idUsuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setIdAgente(rs.getString("idAgente"));
                u.setNombre(rs.getString("nombre"));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return u;
    }
}