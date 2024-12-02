package Service.Sancion;

import Model.Sancion.Sancion;
import Model.Sancion.csSancion;
import javax.jws.WebMethod;
import javax.jws.WebService;

import java.sql.Date;
import java.util.ArrayList;

@WebService(serviceName = "srvSancion")
public class srvSancion {

    @WebMethod(operationName = "insertarSancion")
    public int insertarSancion(String idSancion, String fecha_impuesta, String idInfraccion, String idLicencia, String idAgente) {
        Date Fecha_Impuesta = null;
        try {
            Fecha_Impuesta = Date.valueOf(fecha_impuesta);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }
        csSancion s = new csSancion();
        return s.insertarSancion(idSancion, Fecha_Impuesta, idInfraccion, idLicencia, idAgente);
    }

    @WebMethod(operationName = "actualizarSancion")
    public int actualizarSancion(String idSancion, String fecha_impuesta, String idInfraccion, String idLicencia, String idAgente) {
        Date Fecha_Impuesta = null;
        try {
            Fecha_Impuesta = Date.valueOf(fecha_impuesta);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }
        csSancion s = new csSancion();
        return s.actualizarSancion(idSancion, Fecha_Impuesta, idInfraccion, idLicencia, idAgente);
    }

    @WebMethod(operationName = "eliminarSancion")
    public int eliminarSancion(String idSancion) {
        csSancion s = new csSancion();
        return s.eliminarSancion(idSancion);
    }

    @WebMethod(operationName = "listarSanciones")
    public ArrayList<Sancion> listarSancion() {
        csSancion s = new csSancion();
        return s.listarSancion();
    }

    @WebMethod(operationName = "buscarSancion")
    public Sancion buscarSancion(String idSancion) {
        csSancion s = new csSancion();
        return s.buscarSancion(idSancion);
    }

}
