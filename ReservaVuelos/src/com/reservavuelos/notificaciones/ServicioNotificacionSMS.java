package com.reservavuelos.notificaciones;

// OCP: Agregamos SMS sin modificar ServicioNotificacionEmail ni ServicioReservas
// LSP: Perfectamente intercambiable con ServicioNotificacionEmail
public class ServicioNotificacionSMS implements IServicioNotificacion {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        // Aquí iría la integración real con Twilio o similar
        System.out.println(" Enviando SMS al número: " + destinatario);
        System.out.println("   Mensaje: " + mensaje);
    }
}
