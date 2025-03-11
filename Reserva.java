public class Reserva {
    private String idReserva;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private int asiento;
    private ProgramaDeVuelo programaVuelo;

    // Constructor sin programa de vuelo
    public Reserva(String idReserva, Pasajero pasajero, Vuelo vuelo, int asiento) {
        this.idReserva = idReserva;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.programaVuelo = vuelo.getProgramaVuelo(); // Se asigna automáticamente el programa del vuelo
    }

    // Constructor con programa de vuelo explícito
    public Reserva(String idReserva, Pasajero pasajero, Vuelo vuelo, int asiento, ProgramaDeVuelo programaVuelo) {
        this.idReserva = idReserva;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
        this.programaVuelo = programaVuelo;
    }

    // Getters
    public String getIdReserva() {
        return idReserva;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public int getAsiento() {
        return asiento;
    }

    public ProgramaDeVuelo getProgramaVuelo() { // Nombre corregido
        return programaVuelo;
    }

    // Setters
    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public void setProgramaVuelo(ProgramaDeVuelo programaVuelo) {
        this.programaVuelo = programaVuelo;
    }

    // Método mejorado para mostrar la información de la reserva
    public void mostrarReserva() {
        System.out.println(" ID Reserva: " + idReserva);
        System.out.println(" Pasajero: " + pasajero.getNombre());
        System.out.println(" Vuelo: " + vuelo.getProgramaVuelo().getNumeroDeVuelo() + " - " + vuelo.getProgramaVuelo().getAerolinea());
        System.out.println(" Origen: " + vuelo.getProgramaVuelo().getAeropuertoOrigen().getNombre());
        System.out.println(" Destino: " + vuelo.getProgramaVuelo().getAeropuertoDestino().getNombre());
        System.out.println(" Asiento: " + asiento);
    }
}

