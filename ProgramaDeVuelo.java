import java.util.ArrayList;
import java.util.List;

public class ProgramaDeVuelo {
    private String numeroDeVuelo;
    private String aerolinea;
    private String diasQueOpera;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private List<EscalaTecnica> escalas;

    // Constructor sin escalas
    public ProgramaDeVuelo(String numeroDeVuelo, String aerolinea, String diasQueOpera, 
                            Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino) {
        this.numeroDeVuelo = numeroDeVuelo;
        this.aerolinea = aerolinea;
        this.diasQueOpera = diasQueOpera;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.escalas = new ArrayList<>();
    }

    // Constructor con escalas
    public ProgramaDeVuelo(String numeroDeVuelo, String aerolinea, String diasQueOpera, 
                            Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, List<EscalaTecnica> escalas) {
        this.numeroDeVuelo = numeroDeVuelo;
        this.aerolinea = aerolinea;
        this.diasQueOpera = diasQueOpera;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.escalas = (escalas != null) ? escalas : new ArrayList<>();
    }

    // Getters
    public String getNumeroDeVuelo() {
        return numeroDeVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public String getDiasQueOpera() {
        return diasQueOpera;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public List<EscalaTecnica> getEscalas() {
        return escalas;
    }

    // Setters
    public void setNumeroDeVuelo(String numeroDeVuelo) {
        this.numeroDeVuelo = numeroDeVuelo;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void setDiasQueOpera(String diasQueOpera) {
        this.diasQueOpera = diasQueOpera;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public void setEscalas(List<EscalaTecnica> escalas) {
        this.escalas = escalas;
    }

    // Método corregido para agregar una escala técnica
    public void agregarEscala(EscalaTecnica escalaTecnica) {
        if (escalaTecnica != null) {
            this.escalas.add(escalaTecnica);
        }
    }

    // Método mejorado para mostrar información del programa de vuelo
    public String mostrarProgramaDeVuelo() {
        StringBuilder info = new StringBuilder();
        info.append("✈ Programa de Vuelo: ").append(numeroDeVuelo)
            .append("\n🏢 Aerolínea: ").append(aerolinea)
            .append("\n📅 Días de operación: ").append(diasQueOpera)
            .append("\n🛫 Origen: ").append(aeropuertoOrigen.getNombre()).append(" (").append(aeropuertoOrigen.getCiudad()).append(")")
            .append("\n🛬 Destino: ").append(aeropuertoDestino.getNombre()).append(" (").append(aeropuertoDestino.getCiudad()).append(")");

        if (!escalas.isEmpty()) {
            info.append("\n⏳ Escalas técnicas:");
            for (EscalaTecnica escala : escalas) {
                info.append("\n  🔹 ").append(escala.getDetalleEscalaTecnica());
            }
        } else {
            info.append("\n✅ Vuelo directo (sin escalas).");
        }

        return info.toString();
    }
}
