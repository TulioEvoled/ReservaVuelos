package com.reservavuelos.pagos;

// OCP: Nueva forma de pago sin modificar código existente
// LSP: Puede usarse en cualquier lugar donde se espere IProcesadorPago
public class ProcesadorPagoTarjeta implements IProcesadorPago {

    @Override
    public boolean procesarPago(double monto) {
        // Aquí iría la integración real con una pasarela de pago
        System.out.printf(" Procesando pago de $%.2f con Tarjeta de Crédito...%n", monto);
        System.out.println(" Pago con tarjeta aprobado.");
        return true;
    }
}
