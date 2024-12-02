package Model.Conductor;

import Model.Conexion.csConexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class csConductor {
    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public csConductor() {
        this.con = null;
        this.stm = null;
        this.rs = null;
    }

    public int insertarConductor(String idLicencia, String nombre, int edad, String idVehiculo){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    respuesta = stm.executeUpdate("insert into dbo.conductor(idLicencia, nombre, edad, idVehiculo)"
                            + "values('" + idLicencia + "', '" + nombre + "', '" + edad + "', '" + idVehiculo + "')");
                    stm.close();
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

        return respuesta;
    }
    public int actualizarConductor(String idLicencia, String nombre, int edad, String idVehiculo){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    respuesta = stm.executeUpdate("update dbo.conductor set nombre = '" + nombre + "', edad = '" + edad + "', idVehiculo = '" + idVehiculo + "' where idLicencia = '" + idLicencia + "'");
                    stm.close();
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

        return respuesta;
    }
    public int eliminarConductor(String idLicencia){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    respuesta = stm.executeUpdate("delete from dbo.conductor where idLicencia = '" + idLicencia + "'");
                    stm.close();
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

        return respuesta;
    }
    public ArrayList<Conductor> listarConductor(){
        Conductor C;
        ArrayList<Conductor> lista = new ArrayList<>();
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    rs = stm.executeQuery("select * from dbo.conductor");
                    while (rs.next()) {
                        C = new Conductor();
                        C.setIdLicencia(rs.getString("idLicencia"));
                        C.setNombre(rs.getString("nombre"));
                        C.setEdad(rs.getInt("edad"));
                        C.setIdVehiculo(rs.getString("idVehiculo"));
                        lista.add(C);
                    }
                    rs.close();
                    stm.close();
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;
    }
    public Conductor buscarConductor(String idLicencia){
        Conductor C = null;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    rs = stm.executeQuery("select * from dbo.conductor where idLicencia = '" + idLicencia + "'");
                    if (rs.next()) {
                        C = new Conductor();
                        C.setIdLicencia(rs.getString("idLicencia"));
                        C.setNombre(rs.getString("nombre"));
                        C.setEdad(rs.getInt("edad"));
                        C.setIdVehiculo(rs.getString("idVehiculo"));
                    }
                    rs.close();
                    stm.close();
                }
            }
            c1.desconectar();
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return C;
    }
}
