package Model.Agente;

public class Agente {
    private String idAgente, nombre, sector;

    public Agente(String idAgente, String nombre, String sector) {
        this.idAgente = idAgente;
        this.nombre = nombre;
        this.sector = sector;
    }

    public String getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(String idAgente) {
        this.idAgente = idAgente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
