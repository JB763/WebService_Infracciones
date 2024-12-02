package Model.Pago;

import java.sql.Date;


public class Pago {
    private String idPago;
    private String fecha_Pago;
    private int monto;
    private String sancion;

    public Pago() {
    }


    public Pago(String idPago, String fecha_Pago, int monto, String sancion) {
        this.idPago = idPago;
        this.fecha_Pago = fecha_Pago;
        this.monto = monto;
        this.sancion = sancion;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public String getFecha_Pago() {
        return fecha_Pago;
    }

    public void setFecha_Pago(String fecha_Pago) {
        this.fecha_Pago = fecha_Pago;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getSancion() {
        return sancion;
    }

    public void setSancion(String sancion) {
        this.sancion = sancion;
    }

}
