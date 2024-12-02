package Model.Infraccion;

import Model.Conexion.csConexion;

import java.sql.*;
import java.util.ArrayList;

public class csInfraccion {
    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public csInfraccion() {
        this.con = null;
        this.stm = null;
        this.rs = null;
    }

    public int insertarInfraccion(String idInfraccion, String descripcion, int multa) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    respuesta = stm.executeUpdate("insert into dbo.infraccion(idInfraccion, descripcion, multa)"
                            + "values('" + idInfraccion + "', '" + descripcion + "', " + multa + ")");
                    stm.close(); // Cerramos el Statement
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close(); // Cerramos la conexión
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

        return respuesta;
    }

    public int actualizarInfraccion(String idInfraccion, String descripcion, int multa) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    respuesta = stm.executeUpdate("update dbo.infraccion set descripcion = '" + descripcion + "', multa = " + multa + " where idInfraccion = '" + idInfraccion + "'");
                    stm.close(); // Cerramos el Statement
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close(); // Cerramos la conexión
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

        return respuesta;
    }

    public int eliminarInfraccion(String idInfraccion) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    respuesta = stm.executeUpdate("delete from dbo.infraccion where idInfraccion = '" + idInfraccion + "'");
                    stm.close(); // Cerramos el Statement
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close(); // Cerramos la conexión
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

        return respuesta;
    }

    public ArrayList<Infraccion> listarInfraccion() {
        Infraccion i;
        ArrayList<Infraccion> lista = new ArrayList<>();
        csConexion c1 = new csConexion();

        con = c1.conectar();
        rs = null;

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    rs = stm.executeQuery("select * from dbo.infraccion");

                    while (rs != null && rs.next()) {
                        i = new Infraccion(rs.getString("idInfraccion"), rs.getString("descripcion"), rs.getInt("multa"));
                        lista.add(i);
                    }
                    stm.close(); // Cerramos el Statement
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close(); // Cerramos la conexión
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return lista;
    }

    public Infraccion buscarInfraccion(String idInfraccion) {
        Infraccion i = null;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    rs = stm.executeQuery("select * from dbo.infraccion where idInfraccion = '" + idInfraccion + "'");

                    if (rs != null && rs.next()) {
                        i = new Infraccion(rs.getString("idInfraccion"), rs.getString("descripcion"), rs.getInt("multa"));
                    }
                    stm.close(); // Cerramos el Statement
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close(); // Cerramos la conexión
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return i;
    }
}