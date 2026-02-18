package com.reservavuelos.servicios;

import com.reservavuelos.modelos.Pasajero;
import com.reservavuelos.modelos.Reserva;
import com.reservavuelos.modelos.Vuelo;
import com.reservavuelos.notificaciones.IServicioNotificacion;
import com.reservavuelos.pagos.IProcesadorPago;
import com.reservavuelos.repositorios.IRepositorioVuelos;
import java.util.UUID;

// SRP: Coordina el proceso de reserva (delega pago y notificación a otras clases)
// DIP: Depende únicamente de abstracciones (interfaces), nunca de clases concretas
public class ServicioReservas {

    private final IRepositorioVuelos repositorioVuelos;
    private final IProcesadorPago procesadorPago;
    private final IServicioNotificacion servicioNotificacion;

    // Inyección de dependencias por constructor — corazón del principio DIP
    public ServicioReservas(IRepositorioVuelos repositorioVuelos,
                            IProcesadorPago procesadorPago,
                            IServicioNotificacion servicioNotificacion) {
        this.repositorioVuelos = repositorioVuelos;
        this.procesadorPago = procesadorPago;
        this.servicioNotificacion = servicioNotificacion;
    }

    public Reserva reservarVuelo(Vuelo vuelo, Pasajero pasajero) {
        System.out.printf("%n Iniciando reserva para %s en vuelo %s...%n",
                pasajero.getNombre(), vuelo.getIdVuelo());

        // Paso 1: Verificar disponibilidad de asientos
        if (vuelo.getAsientosDisponibles() <= 0) {
            System.out.println(" No hay asientos disponibles en este vuelo.");
            return null;
        }

        // Paso 2: Procesar el pago (delegado a la abstracción IProcesadorPago)
        boolean pagoExitoso = procesadorPago.procesarPago(vuelo.getPrecio());
        if (!pagoExitoso) {
            System.out.println(" El pago fue rechazado. Reserva cancelada.");
            return null;
        }

        // Paso 3: Actualizar asientos disponibles en el vuelo
        vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles() - 1);

        // Paso 4: Crear el objeto Reserva
        String idReserva = "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Reserva reserva = new Reserva(idReserva, vuelo, pasajero, vuelo.getPrecio());

        // Paso 5: Notificar al pasajero (delegado a IServicioNotificacion)
        String mensaje = String.format(
            "¡Reserva confirmada! ID: %s | Vuelo: %s | Destino: %s | Total: $%.2f",
            idReserva, vuelo.getIdVuelo(), vuelo.getDestino(), vuelo.getPrecio()
        );
        servicioNotificacion.enviarNotificacion(pasajero.getCorreo(), mensaje);

        System.out.println(reserva);
        return reserva;
    }
}