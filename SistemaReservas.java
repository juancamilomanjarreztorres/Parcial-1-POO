import java.util.*;

public class SistemaReservas {
    private List<Reserva> reservas;

    public SistemaReservas() {
        this.reservas = new ArrayList<>();
    }

    public Reserva realizarReserva(Pasajero pasajero, Vuelo vuelo, int asiento) {
        if (!vuelo.estaAsientoDisponible(asiento)) { 
            System.out.println(" Asiento ocupado. Intente con otro número.");
            return null;
        }

        String idReserva = UUID.randomUUID().toString();
        Reserva nuevaReserva = new Reserva(idReserva, pasajero, vuelo, asiento);

        vuelo.agregarReserva(nuevaReserva);
        reservas.add(nuevaReserva);

        System.out.println(" Reserva realizada con éxito. Código de reserva: " + idReserva);
        return nuevaReserva;
    }

    public boolean cancelarReserva(String idReserva) {
        Iterator<Reserva> iterator = reservas.iterator();
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getIdReserva().equals(idReserva)) {
                iterator.remove();
                reserva.getVuelo().cancelarReserva(reserva);
                System.out.println("✅ Reserva cancelada con éxito.");
                return true;
            }
        }
        System.out.println(" Reserva no encontrada.");
        return false;
    }

    // Método para obtener todas las reservas activas
    public List<Reserva> obtenerReservas() {
        return new ArrayList<>(reservas);
    }

    // Método para buscar una reserva por ID
    public Reserva buscarReserva(String idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva().equals(idReserva)) {
                return reserva;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    // Método para editar una reserva (cambiar el número de asiento)
    public boolean editarReserva(Reserva reserva, int nuevoAsiento) {
        Vuelo vuelo = reserva.getVuelo();

        if (!vuelo.estaAsientoDisponible(nuevoAsiento)) {
            System.out.println("❌ El asiento " + nuevoAsiento + " ya está ocupado.");
            return false;
        }

        vuelo.liberarAsiento(reserva.getAsiento());
        reserva.setAsiento(nuevoAsiento);
        vuelo.reservarAsiento(nuevoAsiento);

        System.out.println(" Asiento cambiado correctamente a " + nuevoAsiento);
        return true;
    }

    // Método para mostrar todas las reservas activas
    public void mostrarReservas() {
        if (reservas.isEmpty()) {
            System.out.println(" No hay reservas activas.");
            return;
        }

        System.out.println("\n Lista de Reservas:");
        for (Reserva reserva : reservas) {
            reserva.mostrarReserva();
            System.out.println("----------------------------");
        }
    }
}


