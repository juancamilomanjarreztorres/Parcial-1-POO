import java.text.SimpleDateFormat;
import java.util.Date;

public class AterrizajeDespegue {
    private String idOperacion;
    private String tipo;
    private Date fechaHora;
    private Aeropuerto aeropuerto; // Antes era String
    private String idVuelo;

    // Constructor
    public AterrizajeDespegue(String idOperacion, String tipo, Date fechaHora, Aeropuerto aeropuerto, String idVuelo) {
        this.idOperacion = idOperacion;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.aeropuerto = aeropuerto;
        this.idVuelo = idVuelo;
    }

    // Getters
    public String getIdOperacion() {
        return idOperacion;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    // Setters
    public void setIdOperacion(String idOperacion) {
        this.idOperacion = idOperacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    // Método para mostrar información del aterrizaje/despegue
    public void mostrarAterrizajeDespegue() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(" ID Operación: " + getIdOperacion());
        System.out.println(" Tipo: " + getTipo());
        System.out.println(" Fecha/Hora: " + dateFormat.format(getFechaHora()));
        System.out.println(" Aeropuerto: " + aeropuerto.getNombre() + " (" + aeropuerto.getCodigo() + ")");
        System.out.println(" Vuelo: " + getIdVuelo());
    }
}
