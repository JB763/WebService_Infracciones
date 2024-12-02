package Model.Agente;

import Model.Conexion.csConexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class csAgente {
    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public csAgente() {
        this.con = null;
        this.stm = null;
        this.rs = null;
    }

    public int insertarAgente(String idAgente, String nombre, String sector){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    respuesta = stm.executeUpdate("insert into dbo.agente(idAgente, nombre, sector)"
                            + "values('" + idAgente + "', '" + nombre + "', '" + sector + "')");
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
    public int actualizarAgente(String idAgente, String nombre, String sector){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    respuesta = stm.executeUpdate("update dbo.agente set nombre = '" + nombre + "', sector = '" + sector + "' where idAgente = '" + idAgente + "'");
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
    public int eliminarAgente(String idAgente){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    respuesta = stm.executeUpdate("delete from dbo.agente where idAgente = '" + idAgente + "'");
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
    public ArrayList<Agente> listarAgente(){
        Agente A;
        ArrayList<Agente> lista = new ArrayList<>();
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;
        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    rs = stm.executeQuery("select * from dbo.agente");

                    while (rs != null && rs.next()) {
                        A = new Agente(rs.getString("idAgente"), rs.getString("nombre"), rs.getString("sector"));
                        lista.add(A);
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
    public Agente buscarAgente(String idAgente){
        Agente A = null;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;

        try {
            if (con != null) { // Verificamos si la conexión no es null
                stm = con.createStatement();
                if (stm != null) { // Verificamos si el Statement no es null
                    rs = stm.executeQuery("select * from dbo.agente where idAgente = '" + idAgente + "'");

                    while (rs != null && rs.next()) {
                        A = new Agente(rs.getString("idAgente"), rs.getString("nombre"), rs.getString("sector"));
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
        return A;
    }
}
