package Service.Pago;

import Model.Pago.Pago;
import Model.Pago.csPago;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.Date;
import java.util.ArrayList;

@WebService(serviceName = "srvPago")
public class srvPago {

    @WebMethod(operationName = "insertarPago")
    public int insertarPago(String idPago, String fechaPago, int monto, String idSancion) {
        // Convertir String a java.sql.Date
        Date Fecha_Pago = null;
        try {
            Fecha_Pago = Date.valueOf(fechaPago); // Convierte el String a Date
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0; // Retorna 0 si la fecha es inválida
        }

        csPago p = new csPago();
        return p.insertarPago(idPago, Fecha_Pago, monto, idSancion);
    }
    @WebMethod(operationName = "actualizarPago")
    public int actualizarPago(String idPago, String fechaPago, int monto, String idSancion) {
        // Convertir String a java.sql.Date
        Date Fecha_Pago = null;
        try {
            Fecha_Pago = Date.valueOf(fechaPago); // Convierte el String a Date
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0; // Retorna 0 si la fecha es inválida
        }

        csPago p = new csPago();
        return p.actualizarPago(idPago, Fecha_Pago, monto, idSancion);
    }
    @WebMethod(operationName = "eliminarPago")
    public int eliminarPago(String idPago) {
        csPago p = new csPago();
        return p.eliminarPago(idPago);
    }
    @WebMethod(operationName = "listarPago")
    public ArrayList<Pago> listarPago() {
        csPago p = new csPago();
        return p.listarPago();
    }
    @WebMethod(operationName = "buscarPago")
    public Pago buscarPago(String idPago) {
        csPago p = new csPago();
        return p.buscarPago(idPago);
    }
}
