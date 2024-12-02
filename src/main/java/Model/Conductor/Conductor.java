package Model.Conductor;

public class Conductor {
    private String idLicencia;
    private String nombre;
    private int edad;
    private String idVehiculo;

    public Conductor() {
    }

    public Conductor(String idLicencia, String nombre, int edad, String idVehiculo) {
        this.idLicencia = idLicencia;
        this.nombre = nombre;
        this.edad = edad;
        this.idVehiculo = idVehiculo;
    }

    public String getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(String idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
}
