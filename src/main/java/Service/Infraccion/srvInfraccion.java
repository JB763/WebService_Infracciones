package Service.Infraccion;

import Model.Infraccion.Infraccion;
import Model.Infraccion.csInfraccion;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "srvInfraccion")
public class srvInfraccion {

    @WebMethod(operationName = "insertarInfraccion")
    public int insertarInfraccion(@WebParam(name = "idInfraccion") String idInfraccion, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "multa") int multa)
    {
        csInfraccion i = new csInfraccion();
        return i.insertarInfraccion(idInfraccion, descripcion, multa);
    }
    @WebMethod(operationName = "actualizarInfraccion")
    public int actualizarInfraccion(@WebParam(name = "idInfraccion") String idInfraccion, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "multa") int multa)
    {
        csInfraccion i = new csInfraccion();
        return i.actualizarInfraccion(idInfraccion, descripcion, multa);
    }
    @WebMethod(operationName = "eliminarInfraccion")
    public int eliminarInfraccion(@WebParam(name = "idInfraccion") String idInfraccion)
    {
        csInfraccion i = new csInfraccion();
        return i.eliminarInfraccion(idInfraccion);
    }
    @WebMethod(operationName = "listarInfracciones")
    public ArrayList<Infraccion> listarInfraccion()
    {
        csInfraccion i = new csInfraccion();
        return i.listarInfraccion();
    }
    @WebMethod(operationName = "buscarInfraccion")
    public Infraccion buscarInfraccion(@WebParam(name = "idInfraccion") String idInfraccion)
    {
        csInfraccion i = new csInfraccion();
        return i.buscarInfraccion(idInfraccion);
    }
}
