import java.util.ArrayList;
import java.util.List;

public class Pasajero {
    private String nombre;
    private int identificacion;
    private int numeroPasaporte;
    private String correo;
    private List<Reserva> reservas;

    // Constructor principal
    public Pasajero(String nombre, int identificacion, String correo, int numeroPasaporte) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.numeroPasaporte = numeroPasaporte;
        this.correo = correo;
        this.reservas = new ArrayList<>();
    }

    // Constructor con reservas
    public Pasajero(String nombre, int identificacion, int numeroPasaporte, String correo, List<Reserva> reservas) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.numeroPasaporte = numeroPasaporte;
        this.correo = correo;
        this.reservas = (reservas != null) ? reservas : new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public int getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setNumeroPasaporte(int numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // Método para agregar una reserva
    public void agregarReserva(Reserva reserva) {
        if (reserva != null) {
            this.reservas.add(reserva);
        }
    }

    // Método para cancelar una reserva
    public void cancelarReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    // Método para mostrar información del pasajero
    public void mostrarPasajero() {
        System.out.println("🧑 Nombre: " + nombre);
        System.out.println("🆔 Identificación: " + identificacion);
        System.out.println("🛂 Pasaporte: " + numeroPasaporte);
        System.out.println("📧 Correo: " + correo);
        System.out.println("🎟 Reservas activas: " + reservas.size());
    }
}
