package Model.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class csConexion {
    public String user, password;
    public String url, driver;
    public Connection cn;

    public csConexion() {
        this.user = "";
        this.password = "";
        this.url = "jdbc:sqlserver://DESKTOP-9DQV8TU\\SQLEXPRESS:1433;encrypt=true;trustServerCertificate=true;databaseName=";
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.cn = null;
    }

    public Connection conectar() {
        try {

            Class.forName(this.driver);
            cn = DriverManager.getConnection(url, user, password);
            return cn;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void desconectar() throws SQLException {
        if (cn != null && !cn.isClosed()) {
            cn.close();
        }
    }
}
