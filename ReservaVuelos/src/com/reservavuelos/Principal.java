
package com.reservavuelos;

import com.reservavuelos.modelos.Pasajero;
import com.reservavuelos.modelos.Reserva;
import com.reservavuelos.modelos.Vuelo;
import com.reservavuelos.notificaciones.IServicioNotificacion;
import com.reservavuelos.notificaciones.ServicioNotificacionEmail;
import com.reservavuelos.notificaciones.ServicioNotificacionSMS;
import com.reservavuelos.pagos.IProcesadorPago;
import com.reservavuelos.pagos.ProcesadorPagoPaypal;
import com.reservavuelos.pagos.ProcesadorPagoTarjeta;
import com.reservavuelos.repositorios.IRepositorioVuelos;
import com.reservavuelos.repositorios.RepositorioVuelosEnMemoria;
import com.reservavuelos.servicios.ServicioBusquedaVuelos;
import com.reservavuelos.servicios.ServicioReservas;
import java.time.LocalDate;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        // ─── 1. Crear el repositorio usando la abstracción ───────────────
        IRepositorioVuelos repositorio = new RepositorioVuelosEnMemoria();

        // ─── 2. Cargar vuelos de ejemplo en el sistema ───────────────────
        repositorio.guardar(new Vuelo("AA-101", "Ciudad de México", "Cancún",
                LocalDate.of(2026, 3, 15), 2500.00, 3));
        repositorio.guardar(new Vuelo("MX-202", "Ciudad de México", "Cancún",
                LocalDate.of(2026, 3, 15), 1980.00, 5));
        repositorio.guardar(new Vuelo("LA-303", "Ciudad de México", "Miami",
                LocalDate.of(2026, 3, 20), 8500.00, 2));

        // ─── 3. Buscar vuelos disponibles ────────────────────────────────
        ServicioBusquedaVuelos servicioBusqueda = new ServicioBusquedaVuelos(repositorio);
        List<Vuelo> vuelosDisponibles = servicioBusqueda.buscarVuelos("Cancún",
                LocalDate.of(2026, 3, 15));

        if (vuelosDisponibles.isEmpty()) return;

        // ─── 4. Seleccionar vuelos para cada caso ────────────────────────
        Vuelo vueloCaso1 = vuelosDisponibles.get(0);
        Vuelo vueloCaso2 = vuelosDisponibles.get(1);

        // ─── 5. Crear pasajeros ──────────────────────────────────────────
        Pasajero pasajero1 = new Pasajero("P-001", "Zaira Corona",
                "zaira.corona@correo.com", "+52 55 1234 5678");

        Pasajero pasajero2 = new Pasajero("P-002", "Iván Cástelan",
                "ivan.castelan@correo.com", "+52 55 9876 5432");

        // ─── CASO 1: Tarjeta de Crédito + Notificación por Correo ────────
        System.out.println("\n==============================");
        System.out.println("  CASO 1: Tarjeta + Correo");
        System.out.println("==============================");

        IProcesadorPago procesadorTarjeta = new ProcesadorPagoTarjeta();
        IServicioNotificacion notificacionEmail = new ServicioNotificacionEmail();
        ServicioReservas servicioReservas1 = new ServicioReservas(
                repositorio, procesadorTarjeta, notificacionEmail);

        Reserva reserva1 = servicioReservas1.reservarVuelo(vueloCaso1, pasajero1);

        // ─── CASO 2: PayPal + Notificación por SMS ───────────────────────
        System.out.println("\n==============================");
        System.out.println("  CASO 2: PayPal + SMS");
        System.out.println("==============================");

        IProcesadorPago procesadorPaypal = new ProcesadorPagoPaypal();
        IServicioNotificacion notificacionSMS = new ServicioNotificacionSMS();
        ServicioReservas servicioReservas2 = new ServicioReservas(
                repositorio, procesadorPaypal, notificacionSMS);

        Reserva reserva2 = servicioReservas2.reservarVuelo(vueloCaso2, pasajero2);
    }
}