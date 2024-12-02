package Service.Vehiculo;

import Model.Vehiculo.Vehiculo;
import Model.Vehiculo.csVehiculo;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import java.util.ArrayList;

@WebService(serviceName = "srvVehiculo")
public class srvVehiculo {

    @WebMethod(operationName = "insertarVehiculo")
    public int insertarVehiculo(@WebParam(name = "idVehiculo") String idVehiculo, @WebParam(name = "placa") String placa, @WebParam(name = "marca") String marca, @WebParam(name = "modelo") String modelo)
    {
        csVehiculo v = new csVehiculo();
        return v.insertarVehiculo(idVehiculo, placa, marca, modelo);
    }
    @WebMethod(operationName = "actualizarVehiculo")
    public int actualizarVehiculo(@WebParam(name = "idVehiculo") String idVehiculo, @WebParam(name = "placa") String placa, @WebParam(name = "marca") String marca, @WebParam(name = "modelo") String modelo)
    {
        csVehiculo v = new csVehiculo();
        return v.actualizarVehiculo(idVehiculo, placa, marca, modelo);
    }
    @WebMethod(operationName = "eliminarVehiculo")
    public int eliminarVehiculo(@WebParam(name = "placa") String placa)
    {
        csVehiculo v = new csVehiculo();
        return v.eliminarVehiculo(placa);
    }
    @WebMethod(operationName = "listarVehiculos")
    public ArrayList<Vehiculo> listarVehiculo()
    {
        csVehiculo v = new csVehiculo();
        return v.listarVehiculo();
    }
    @WebMethod(operationName = "buscarVehiculo")
    public Vehiculo buscarVehiculo(@WebParam(name = "placa") String placa)
    {
        csVehiculo v = new csVehiculo();
        return v.buscarVehiculo(placa);
    }

}
