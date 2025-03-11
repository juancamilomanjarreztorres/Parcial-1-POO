import java.util.ArrayList;
import java.util.List;

public class ModeloAvion {
    private String idModelo;
    private int capacidad;
    private List<Aeropuerto> aeropuertosPermitidos;

    // Constructor principal
    public ModeloAvion(String idModelo, int capacidad) {
        this.idModelo = idModelo;
        this.capacidad = capacidad;
        this.aeropuertosPermitidos = new ArrayList<>();
    }

    // Constructor con lista de aeropuertos permitidos
    public ModeloAvion(String idModelo, int capacidad, List<Aeropuerto> aeropuertosPermitidos) {
        this.idModelo = idModelo;
        this.capacidad = capacidad;
        this.aeropuertosPermitidos = (aeropuertosPermitidos != null) ? aeropuertosPermitidos : new ArrayList<>();
    }

    // Getters
    public String getIdModelo() {
        return idModelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<Aeropuerto> getAeropuertosPermitidos() {
        return aeropuertosPermitidos;
    }

    // Setters
    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setAeropuertosPermitidos(List<Aeropuerto> aeropuertosPermitidos) {
        this.aeropuertosPermitidos = aeropuertosPermitidos;
    }

    // Método para agregar aeropuertos permitidos para este modelo
    public void agregarAeropuertoPermitido(Aeropuerto aeropuerto) {
        if (aeropuerto != null) {
            this.aeropuertosPermitidos.add(aeropuerto);
        }
    }

    // Método para mostrar información del modelo de avión
    public void mostrarModeloAvion() {
        System.out.println(" Modelo: " + getIdModelo());
        System.out.println(" Capacidad: " + getCapacidad() + " pasajeros");
    }
}

