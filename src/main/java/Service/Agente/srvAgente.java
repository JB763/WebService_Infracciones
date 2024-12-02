package Service.Agente;

import Model.Agente.Agente;
import Model.Agente.csAgente;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "srvAgente")
public class srvAgente {
    @WebMethod(operationName = "insertarAgente")
    public int insertarAgente(@WebParam(name = "idAgente") String idAgente, @WebParam(name = "nombre") String nombre, @WebParam(name = "sector") String sector)
    {
        csAgente a = new csAgente();
        return a.insertarAgente(idAgente, nombre, sector);
    }
    @WebMethod(operationName = "actualizarAgente")
    public int actualizarAgente(@WebParam(name = "idAgente") String idAgente, @WebParam(name = "nombre") String nombre, @WebParam(name = "sector") String sector)
    {
        csAgente a = new csAgente();
        return a.actualizarAgente(idAgente, nombre, sector);
    }
    @WebMethod(operationName = "eliminarAgente")
    public int eliminarAgente(@WebParam(name = "idAgente") String idAgente)
    {
        csAgente a = new csAgente();
        return a.eliminarAgente(idAgente);
    }
    @WebMethod(operationName = "listarAgentes")
    public ArrayList<Agente> listarAgente()
    {
        csAgente a = new csAgente();
        return a.listarAgente();
    }
    @WebMethod(operationName = "buscarAgente")
    public Agente buscarAgente(@WebParam(name = "idAgente") String idAgente)
    {
        csAgente a = new csAgente();
        return a.buscarAgente(idAgente);
    }
}