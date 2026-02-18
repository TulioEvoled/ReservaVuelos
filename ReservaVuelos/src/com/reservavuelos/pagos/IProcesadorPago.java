package com.reservavuelos.pagos;

// ISP: Interfaz mínima y específica para cualquier procesador de pago
// DIP: ServicioReservas dependerá de esta abstracción
public interface IProcesadorPago {
    boolean procesarPago(double monto);
}