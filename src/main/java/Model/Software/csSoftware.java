package Model.Software;

import Model.Conexion.csConexion;

import java.sql.Connection;
import java.sql.Statement;

public class csSoftware {
    private Connection con;
    private Statement stm;

    public csSoftware() {
        this.con = null;
        this.stm = null;
    }

    public int insertarSoftware(String idSoftware, String nombre, String descripcion, int precio, int stock) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try {
            if (con != null) {
                stm = con.createStatement();
                if (stm != null) {
                    respuesta = stm.executeUpdate("insert into dbo.software(idSoftware, nombre, descripcion, precio, stock)"
                            + "values('" + idSoftware + "', '" + nombre + "', '" + descripcion + "', " + precio + ", " + stock + ")");
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
}