public class EscalaTecnica {
    private String idEscala;
    private String idVuelo;
    private Aeropuerto aeropuerto;
    private int numeroOrden;

    // Constructor principal con todos los datos
    public EscalaTecnica(String idEscala, String idVuelo, Aeropuerto aeropuerto, int numeroOrden) {
        this.idEscala = idEscala;
        this.idVuelo = idVuelo;
        this.aeropuerto = aeropuerto;
        this.numeroOrden = numeroOrden;
    }

    // Constructor simplificado (si solo se conoce el número de orden y el aeropuerto)
    public EscalaTecnica(int numeroOrden, Aeropuerto aeropuerto) {
        this.numeroOrden = numeroOrden;
        this.aeropuerto = aeropuerto;
    }

    // Getters
    public String getIdEscala() {
        return idEscala;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    // Setters
    public void setIdEscala(String idEscala) {
        this.idEscala = idEscala;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    // Método mejorado para mostrar detalles de la escala técnica
    public String getDetalleEscalaTecnica() {
        return "🔹 Escala Técnica #" + numeroOrden + " en " + aeropuerto.getNombre() +
               " (Ciudad: " + aeropuerto.getCiudad() + ", País: " + aeropuerto.getPais() + ")";
    }
}
