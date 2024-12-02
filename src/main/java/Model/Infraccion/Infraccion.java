package Model.Infraccion;

public class Infraccion {
    private String idInfraccion, descripcion;
    private int multa;
    public Infraccion(String idInfraccion, String descripcion, int multa) {
        this.idInfraccion = idInfraccion;
        this.descripcion = descripcion;
        this.multa = multa;
    }

    public String getIdInfraccion() {
        return idInfraccion;
    }

    public void setIdInfraccion(String idInfraccion) {
        this.idInfraccion = idInfraccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }
}
