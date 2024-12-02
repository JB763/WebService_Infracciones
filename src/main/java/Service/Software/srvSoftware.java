package Service.Software;

import Model.Software.csSoftware;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "srvSoftware")
public class srvSoftware {
    @WebMethod(operationName = "insertarSoftware")
    public int insertarSoftware(@WebParam(name = "idSoftware") String idSoftware, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio") int precio, @WebParam(name = "stock") int stock){
        csSoftware s = new csSoftware();
        return s.insertarSoftware(idSoftware, nombre, descripcion, precio, stock);
    }
}