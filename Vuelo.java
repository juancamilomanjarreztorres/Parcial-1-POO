import java.util.*;

public class Vuelo {
    private String idVuelo;
    private Date fechaVuelo;
    private int cantidadAsientos;
    private ModeloAvion modeloAvion;
    private ProgramaDeVuelo programaVuelo;
    private List<Reserva> reservas;

    // Constructor sin ID (genera uno automáticamente)
    public Vuelo(ProgramaDeVuelo programaVuelo, Date fechaVuelo, ModeloAvion modeloAvion) {
        this.idVuelo = UUID.randomUUID().toString(); 
        this.fechaVuelo = fechaVuelo;
        this.modeloAvion = modeloAvion;
        this.programaVuelo = programaVuelo;
        this.cantidadAsientos = modeloAvion.getCapacidad();
        this.reservas = new ArrayList<>();
    }

    // Constructor con ID
    public Vuelo(String idVuelo, ProgramaDeVuelo programaVuelo, Date fechaVuelo, int cantidadAsientos, ModeloAvion modeloAvion) {
        this.idVuelo = idVuelo;
        this.fechaVuelo = fechaVuelo;
        this.cantidadAsientos = cantidadAsientos;
        this.modeloAvion = modeloAvion;
        this.programaVuelo = programaVuelo;
        this.reservas = new ArrayList<>();
    }

    // Getters
    public String getIdVuelo() {
        return idVuelo;
    }

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public int getCantidadAsientos() {
        return cantidadAsientos;
    }

    public ModeloAvion getModeloAvion() {
        return modeloAvion;
    }

    public ProgramaDeVuelo getProgramaVuelo() {
        return programaVuelo;
    }

    public List<Reserva> getReservas() {
        return new ArrayList<>(reservas); // Retorna una copia para evitar modificaciones externas
    }

    // Método para obtener la cantidad de plazas vacías
    public int getCantidadPlazasVacias() {
        return cantidadAsientos - reservas.size();
    }

    // Método para verificar si un asiento está disponible
    public boolean estaAsientoDisponible(int asiento) {
        return reservas.stream().noneMatch(reserva -> reserva.getAsiento() == asiento);
    }

    // Método para agregar una reserva al vuelo
    public void agregarReserva(Reserva reserva) {
        if (estaAsientoDisponible(reserva.getAsiento())) {
            reservas.add(reserva);
            System.out.println("✅ Reserva agregada al vuelo: " + idVuelo);
        } else {
            System.out.println("❌ No se pudo agregar la reserva. Asiento ocupado.");
        }
    }

    // Método para cancelar una reserva
    public void cancelarReserva(Reserva reserva) {
        if (reservas.remove(reserva)) {
            System.out.println("✅ Reserva cancelada para el asiento: " + reserva.getAsiento());
        } else {
            System.out.println("❌ No se encontró la reserva.");
        }
    }

    // Método para liberar un asiento (nuevo)
    public void liberarAsiento(int asiento) {
        reservas.removeIf(reserva -> reserva.getAsiento() == asiento);
        System.out.println("✅ Asiento " + asiento + " liberado.");
    }

    // Método para reservar un asiento (nuevo)
    public void reservarAsiento(int asiento) {
        if (!estaAsientoDisponible(asiento)) {
            System.out.println("❌ El asiento " + asiento + " ya está ocupado.");
        } else {
            System.out.println("✅ Asiento " + asiento + " reservado.");
        }
    }

    // Método para mostrar detalles del vuelo
    public String mostrarDetallesVuelo() {
        return "✈️ ID del vuelo: " + idVuelo +
                "\n📅 Fecha: " + fechaVuelo +
                "\n🏢 Aerolínea: " + (programaVuelo != null ? programaVuelo.getAerolinea() : "Desconocida") +
                "\n🛫 Origen: " + (programaVuelo != null && programaVuelo.getAeropuertoOrigen() != null ? programaVuelo.getAeropuertoOrigen().getNombre() : "Desconocido") +
                "\n🛬 Destino: " + (programaVuelo != null && programaVuelo.getAeropuertoDestino() != null ? programaVuelo.getAeropuertoDestino().getNombre() : "Desconocido") +
                "\n🪑 Plazas disponibles: " + getCantidadPlazasVacias();
    }
}
