package com.reservavuelos.pagos;

// OCP: Agregamos PayPal sin modificar ProcesadorPagoTarjeta ni ServicioReservas
// LSP: Intercambiable con cualquier otra implementación de IProcesadorPago
public class ProcesadorPagoPaypal implements IProcesadorPago {

    @Override
    public boolean procesarPago(double monto) {
        // Aquí iría la integración real con la API de PayPal
        System.out.printf(" Procesando pago de $%.2f con PayPal...%n", monto);
        System.out.println(" Pago con PayPal aprobado.");
        return true;
    }
}
