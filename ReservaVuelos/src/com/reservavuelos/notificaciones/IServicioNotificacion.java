package com.reservavuelos.notificaciones;

// ISP: Interfaz pequeña y enfocada solo en el envío de notificaciones
// DIP: ServicioReservas dependerá de esta abstracción, no de Email ni SMS directamente
public interface IServicioNotificacion {
    void enviarNotificacion(String destinatario, String mensaje);
}