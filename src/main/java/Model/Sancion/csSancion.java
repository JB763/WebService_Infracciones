package Model.Sancion;

import Model.Conexion.csConexion;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class csSancion {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private SimpleDateFormat dateFormat; // Formateador de fecha

    public csSancion() {
        con = null;
        ps = null;
        rs = null;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Define el formato deseado
    }

    public int insertarSancion(String idSancion, Date fecha_impuesta, String idInfraccion, String idLicencia, String idAgente) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "INSERT INTO Sancion (idSancion, fecha_impuesta, idInfraccion, idLicencia, idAgente) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(query);
            if (con != null) {
                ps.setString(1, idSancion);
                ps.setDate(2, fecha_impuesta);
                ps.setString(3, idInfraccion);
                ps.setString(4, idLicencia);
                ps.setString(5, idAgente);

                respuesta = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public int actualizarSancion(String idSancion, Date fecha_impuesta, String idInfraccion, String idLicencia, String idAgente) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "UPDATE Sancion SET fecha_impuesta = ?, idInfraccion = ?, idLicencia = ?, idAgente = ? WHERE idSancion = ?";

        try {
            ps = con.prepareStatement(query);
            if (con != null) {
                ps.setDate(1, fecha_impuesta);
                ps.setString(2, idInfraccion);
                ps.setString(3, idLicencia);
                ps.setString(4, idAgente);
                ps.setString(5, idSancion);

                respuesta = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public int eliminarSancion(String idSancion) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "DELETE FROM Sancion WHERE idSancion = ?";

        try {
            ps = con.prepareStatement(query);
            if (con != null) {
                ps.setString(1, idSancion);

                respuesta = ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public ArrayList<Sancion> listarSancion() {
        Sancion s;
        ArrayList<Sancion> lista = new ArrayList<>();
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "SELECT * FROM Sancion";

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Sancion();
                s.setIdSancion(rs.getString("idSancion"));
                // Convertir Date a String
                s.setFecha_impuesta(dateFormat.format(rs.getDate("fecha_impuesta")));
                s.setIdInfraccion(rs.getString("idInfraccion"));
                s.setIdLicencia(rs.getString("idLicencia"));
                s.setIdAgente(rs.getString("idAgente"));
                lista.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    public Sancion buscarSancion(String idSancion) {
        Sancion s = null;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "SELECT * FROM Sancion WHERE idSancion = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, idSancion);
            rs = ps.executeQuery();
            if (rs.next()) {
                s = new Sancion();
                s.setIdSancion(rs.getString("idSancion"));
                // Convertir Date a String
                s.setFecha_impuesta(dateFormat.format(rs.getDate("fecha_impuesta")));
                s.setIdInfraccion(rs.getString("idInfraccion"));
                s.setIdLicencia(rs.getString("idLicencia"));
                s.setIdAgente(rs.getString("idAgente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return s;
    }
}
