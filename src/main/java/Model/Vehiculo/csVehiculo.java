package Model.Vehiculo;

import Model.Conexion.csConexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class csVehiculo{
    private Connection con;
    private Statement stm;
    private ResultSet rs;

    public csVehiculo() {
        this.con = null;
        this.stm = null;
        this.rs = null;
    }

    public int insertarVehiculo(String idVehiculo, String placa, String marca, String modelo){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    respuesta = stm.executeUpdate("insert into dbo.vehiculo(idVehiculo, placa, marca, modelo)"
                            + "values('" + idVehiculo + "', '" + placa + "', '" + marca + "', '" + modelo + "')");
                    stm.close(); // Cerramos el Statement
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
    public int actualizarVehiculo(String idVehiculo, String placa, String marca, String modelo){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    respuesta = stm.executeUpdate("update dbo.vehiculo set placa = '" + placa + "', marca = '" + marca + "', modelo = '" + modelo + "' where idVehiculo = '" + idVehiculo + "'");
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

    public int eliminarVehiculo(String idVehiculo){
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    respuesta = stm.executeUpdate("delete from dbo.vehiculo where idVehiculo = '" + idVehiculo + "'");
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
    public ArrayList<Vehiculo> listarVehiculo(){
        Vehiculo v;
        ArrayList<Vehiculo> lista = new ArrayList<>();
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    rs = stm.executeQuery("select * from dbo.vehiculo");
                    while (rs != null && rs.next()) {
                        v = new Vehiculo(rs.getString("idVehiculo"), rs.getString("placa"), rs.getString("marca"), rs.getString("modelo")  );
                        lista.add(v);
                    }
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

    public Vehiculo buscarVehiculo(String idVehiculo){
        Vehiculo v = null;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        rs = null;

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    rs = stm.executeQuery("select * from dbo.vehiculo where idVehiculo = '" + idVehiculo + "'");
                    if (rs != null && rs.next()) {
                        v = new Vehiculo(rs.getString("idVehiculo"), rs.getString("placa"), rs.getString("marca"), rs.getString("modelo")  );
                    }
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

        return v;
    }
}
