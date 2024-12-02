package Service.Conductor;

import Model.Conductor.Conductor;
import Model.Conductor.csConductor;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "srvConductor")
public class srvConductor {
    @WebMethod(operationName = "insertarConductor")
    public int insertarConductor(@WebParam(name = "idLicencia") String idLicencia, @WebParam(name = "nombre") String nombre, @WebParam(name = "edad") int edad, @WebParam(name = "idVehiculo") String idVehiculo)
    {
        csConductor c = new csConductor();
        return c.insertarConductor(idLicencia, nombre, edad, idVehiculo);
    }
    @WebMethod(operationName = "actualizarConductor")
    public int actualizarConductor(@WebParam(name = "idLicencia") String idLicencia, @WebParam(name = "nombre") String nombre, @WebParam(name = "edad") int edad, @WebParam(name = "idVehiculo") String idVehiculo)
    {
        csConductor c = new csConductor();
        return c.actualizarConductor(idLicencia, nombre, edad, idVehiculo);
    }
    @WebMethod(operationName = "eliminarConductor")
    public int eliminarConductor(@WebParam(name = "idLicencia") String idLicencia)
    {
        csConductor c = new csConductor();
        return c.eliminarConductor(idLicencia);
    }
    @WebMethod(operationName = "listarConductores")
    public ArrayList<Conductor> listarConductor()
    {
        csConductor c = new csConductor();
        return c.listarConductor();
    }
    @WebMethod(operationName = "buscarConductor")
    public Conductor buscarConductor(@WebParam(name = "idLicencia") String idLicencia)
    {
        csConductor c = new csConductor();
        return c.buscarConductor(idLicencia);
    }
}
