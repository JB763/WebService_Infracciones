package Model.Sancion;

import java.sql.Date;

public class Sancion {
    private String idSancion, idInfraccion, idLicencia, idAgente;
    private String fecha_impuesta;

    public Sancion() {
    }

    public Sancion(String idSancion, String idInfraccion, String idLicencia, String idAgente, String fecha_impuesta) {
        this.idSancion = idSancion;
        this.idInfraccion = idInfraccion;
        this.idLicencia = idLicencia;
        this.idAgente = idAgente;
        this.fecha_impuesta = fecha_impuesta;
    }

    public String getIdSancion() {
        return idSancion;
    }

    public void setIdSancion(String idSancion) {
        this.idSancion = idSancion;
    }

    public String getIdInfraccion() {
        return idInfraccion;
    }

    public void setIdInfraccion(String idInfraccion) {
        this.idInfraccion = idInfraccion;
    }

    public String getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(String idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public String getFecha_impuesta() {
        return fecha_impuesta;
    }

    public void setFecha_impuesta(String fecha_impuesta) {
        this.fecha_impuesta = fecha_impuesta;
    }


}
