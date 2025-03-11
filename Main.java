import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static SistemaReservas gestorReservas = new SistemaReservas();
    private static List<Aeropuerto> aeropuertos = new ArrayList<>();
    private static List<Vuelo> vuelos = new ArrayList<>();

    public static void main(String[] args) {
        inicializarDatos();
        mostrarMenu();
    }

    private static void inicializarDatos() {
        // Crear aeropuertos
        Aeropuerto madrid = new Aeropuerto("MAD", "Aeropuerto de Barajas", "Madrid", "España");
        Aeropuerto sydney = new Aeropuerto("SYD", "Aeropuerto de Caudell", "Sydney", "Australia");
        Aeropuerto saoPaulo = new Aeropuerto("GRU", "Los Pradiños", "Sao Paulo", "Brasil");

        aeropuertos.add(madrid);
        aeropuertos.add(sydney);
        aeropuertos.add(saoPaulo);

        // Crear modelo de avión
        ModeloAvion boeing777 = new ModeloAvion("Boeing 777", 350);

        // Crear programa de vuelo
        ProgramaDeVuelo vuelo555 = new ProgramaDeVuelo("555", "Iberia", "Lunes, Jueves", madrid, sydney);
        vuelo555.agregarEscala(new EscalaTecnica(1, saoPaulo));

        // Crear un vuelo específico
        Vuelo vuelo = new Vuelo(vuelo555, new Date(), boeing777);
        vuelos.add(vuelo);
    }

    private static void mostrarMenu() {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("\n  Bienvenido al Sistema de Control de Vuelos ");
            System.out.println("1 Ver vuelos disponibles");
            System.out.println("2  Reservar un vuelo");
            System.out.println("3 Cancelar una reserva");
            System.out.println("4  Mostrar reservas");
            System.out.println("5  Editar una reserva");
            System.out.println("6  Salir");
            System.out.print("Seleccione una opción: ");
            opcion = obtenerEntero();

            switch (opcion) {
                case 1:
                    mostrarVuelos();
                    pausar();
                    break;
                case 2:
                    reservarVuelo();
                    pausar();
                    break;
                case 3:
                    cancelarReserva();
                    pausar();
                    break;
                case 4:
                    mostrarReservas();
                    pausar();
                    break;
                case 5:
                    editarReserva();
                    pausar();
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema. ¡Buen viaje! ");
                    break;
                default:
                    System.out.println(" Opción no válida. Intente de nuevo.");
                    pausar();
            }
        } while (opcion != 6);
    }

    private static void mostrarVuelos() {
        System.out.println("\n Lista de Vuelos Disponibles:");
        for (Vuelo vuelo : vuelos) {
            System.out.println("Vuelo " + vuelo.getProgramaVuelo().getNumeroDeVuelo() +
                    " - " + vuelo.getProgramaVuelo().getAerolinea() +
                    " | Origen: " + vuelo.getProgramaVuelo().getAeropuertoOrigen().getNombre() +
                    " | Destino: " + vuelo.getProgramaVuelo().getAeropuertoDestino().getNombre() +
                    " | Plazas disponibles: " + vuelo.getCantidadPlazasVacias());
        }
    }

    private static void mostrarReservas() {
        System.out.println("\n Lista de Reservas:");
        List<Reserva> reservas = gestorReservas.obtenerReservas();
        if (reservas.isEmpty()) {
            System.out.println(" No hay reservas registradas.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println("Reserva ID: " + reserva.getIdReserva() +
                        " | Pasajero: " + reserva.getPasajero().getNombre() +
                        " | Vuelo: " + reserva.getVuelo().getProgramaVuelo().getNumeroDeVuelo() +
                        " | Asiento: " + reserva.getAsiento());
            }
        }
    }

    private static void reservarVuelo() {
        System.out.println("\n Realizar una Reserva");

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Ingrese su número de pasaporte: ");
        int numeroPasaporte = obtenerEntero();

        Pasajero pasajero = new Pasajero(nombre, numeroPasaporte, "email@ejemplo.com", numeroPasaporte);

        mostrarVuelos();
        System.out.print("Ingrese el número de vuelo que desea reservar: ");
        String numVuelo = scanner.nextLine().trim();

        Vuelo vueloSeleccionado = null;
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getProgramaVuelo().getNumeroDeVuelo().equalsIgnoreCase(numVuelo)) {
                vueloSeleccionado = vuelo;
                break;
            }
        }

        if (vueloSeleccionado == null) {
            System.out.println(" Vuelo no encontrado.");
            return;
        }

        System.out.print("Ingrese el número de asiento: ");
        int asiento = obtenerEntero();

        Reserva reserva = gestorReservas.realizarReserva(pasajero, vueloSeleccionado, asiento);
        if (reserva != null) {
            System.out.println(" Reserva confirmada: " + reserva.getIdReserva());
        } else {
            System.out.println(" No se pudo realizar la reserva asiento ocupado.");
        }
    }

    private static void cancelarReserva() {
        System.out.println("\n Cancelar Reserva");
        System.out.print("Ingrese el código de su reserva: ");
        String codigoReserva = scanner.nextLine();

        boolean resultado = gestorReservas.cancelarReserva(codigoReserva);
        if (resultado) {
            System.out.println(" Reserva cancelada correctamente.");
        } else {
            System.out.println(" No se encontró la reserva.");
        }
    }

    private static void editarReserva() {
        System.out.println("\n Editar Reserva");
        System.out.print("Ingrese el código de su reserva: ");
        String codigoReserva = scanner.nextLine();

        Reserva reserva = gestorReservas.buscarReserva(codigoReserva);
        if (reserva == null) {
            System.out.println(" No se encontró la reserva.");
            return;
        }

        System.out.println("Reserva encontrada: Pasajero " + reserva.getPasajero().getNombre() +
                " | Vuelo: " + reserva.getVuelo().getProgramaVuelo().getNumeroDeVuelo() +
                " | Asiento actual: " + reserva.getAsiento());

        System.out.print("Ingrese el nuevo número de asiento: ");
        int nuevoAsiento = obtenerEntero();

        boolean cambioExitoso = gestorReservas.editarReserva(reserva, nuevoAsiento);
        if (cambioExitoso) {
            System.out.println(" Asiento cambiado correctamente a " + nuevoAsiento);
        } else {
            System.out.println(" No se pudo cambiar el asiento.");
        }
    }

    private static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("No se pudo limpiar la pantalla.");
        }
    }

    private static void pausar() {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }

    private static int obtenerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Ingrese un número.");
            }
        }
    }
}


