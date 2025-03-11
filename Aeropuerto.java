import java.util.ArrayList;
import java.util.List;

public class Aeropuerto {
    private String codigo;
    private String nombre;
    private String ciudad;
    private String pais;
    private List<ModeloAvion> modelosPermitidos;
    private List<ProgramaDeVuelo> programasVuelo;
    private List<AterrizajeDespegue> operaciones;

    // Constructor principal
    public Aeropuerto(String codigo, String nombre, String ciudad, String pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.modelosPermitidos = new ArrayList<>();
        this.programasVuelo = new ArrayList<>();
        this.operaciones = new ArrayList<>();
    }

    // Constructor con listas
    public Aeropuerto(String codigo, String nombre, String ciudad, String pais,
                      List<ModeloAvion> modelosPermitidos,
                      List<ProgramaDeVuelo> programasVuelo,
                      List<AterrizajeDespegue> operaciones) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.modelosPermitidos = (modelosPermitidos != null) ? modelosPermitidos : new ArrayList<>();
        this.programasVuelo = (programasVuelo != null) ? programasVuelo : new ArrayList<>();
        this.operaciones = (operaciones != null) ? operaciones : new ArrayList<>();
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<ModeloAvion> getModelosPermitidos() {
        return modelosPermitidos;
    }

    public void setModelosPermitidos(List<ModeloAvion> modelosPermitidos) {
        this.modelosPermitidos = modelosPermitidos;
    }

    public List<ProgramaDeVuelo> getProgramasVuelo() {
        return programasVuelo;
    }

    public void setProgramasVuelo(List<ProgramaDeVuelo> programasVuelo) {
        this.programasVuelo = programasVuelo;
    }

    public List<AterrizajeDespegue> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<AterrizajeDespegue> operaciones) {
        this.operaciones = operaciones;
    }

    // Método para mostrar información del aeropuerto
    public String mostrarAeropuerto() {
        return " Aeropuerto: " + nombre + " (" + codigo + ")\n" +
               " Ubicación: " + ciudad + ", " + pais;
    }

    // Método para agregar modelos de avión permitidos en este aeropuerto
    public void agregarModeloPermitido(ModeloAvion modelo) {
        if (modelo != null) {
            this.modelosPermitidos.add(modelo);
        }
    }
}
