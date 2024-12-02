package Model.Pago;

import Model.Conexion.csConexion;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class csPago {
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    private SimpleDateFormat dateFormat; // Formateador de fecha

    public csPago() {
        this.con = null;
        this.stm = null;
        this.rs = null;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Define el formato deseado
    }

    public int insertarPago(String idPago, Date Fecha_Pago, int monto, String idSancion) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "INSERT INTO Pago (idPago, Fecha_Pago, monto, idSancion) VALUES (?, ?, ?, ?)";

        try {
            stm = con.prepareStatement(query);
            stm.setString(1, idPago);
            stm.setDate(2, Fecha_Pago);
            stm.setInt(3, monto);
            stm.setString(4, idSancion);

            respuesta = stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public int actualizarPago(String idPago, Date Fecha_Pago, int monto, String idSancion) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "UPDATE Pago SET Fecha_Pago = ?, monto = ?, idSancion = ? WHERE idPago = ?";

        try {
            stm = con.prepareStatement(query);
            stm.setDate(1, Fecha_Pago);
            stm.setInt(2, monto);
            stm.setString(3, idSancion);
            stm.setString(4, idPago);

            respuesta = stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public int eliminarPago(String idPago) {
        int respuesta = 0;
        csConexion c1 = new csConexion();
        con = c1.conectar();
        String query = "DELETE FROM Pago WHERE idPago = ?";

        try {
            stm = con.prepareStatement(query);
            stm.setString(1, idPago);

            respuesta = stm.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
        return respuesta;
    }

    public ArrayList<Pago> listarPago() {
        Pago p;
        ArrayList<Pago> lista = new ArrayList<>();
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try (Statement stm = con.createStatement()) {
            if (con != null) {
                rs = stm.executeQuery("SELECT * FROM Pago");
                while (rs.next()) {
                    p = new Pago();
                    p.setIdPago(rs.getString("idPago"));
                    // Convertir Date a String
                    p.setFecha_Pago(dateFormat.format(rs.getDate("Fecha_Pago")));
                    p.setMonto(rs.getInt("monto"));
                    p.setSancion(rs.getString("idSancion"));
                    lista.add(p);
                }
                return lista;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            // Cerrar la conexión si está abierta
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Pago buscarPago(String idPago) {
        Pago p = null;
        csConexion c1 = new csConexion();
        con = c1.conectar();

        try (PreparedStatement stm = con.prepareStatement("SELECT * FROM Pago WHERE idPago = ?")) {
            if (con != null) {
                stm.setString(1, idPago);
                rs = stm.executeQuery();
                if (rs.next()) {
                    p = new Pago();
                    p.setIdPago(rs.getString("idPago"));
                    // Convertir Date a String
                    p.setFecha_Pago(dateFormat.format(rs.getDate("Fecha_Pago")));
                    p.setMonto(rs.getInt("monto"));
                    p.setSancion(rs.getString("idSancion"));
                    return p;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            // Cerrar la conexión si está abierta
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
