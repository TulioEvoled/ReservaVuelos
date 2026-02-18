package com.reservavuelos.notificaciones;

// SRP: Solo gestiona el envío de notificaciones por correo electrónico
// LSP: Cumple completamente el contrato de IServicioNotificacion
public class ServicioNotificacionEmail implements IServicioNotificacion {

    @Override
    public void enviarNotificacion(String destinatario, String mensaje) {
        // Aquí iría la integración real con JavaMail o SendGrid
        System.out.println(" Enviando CORREO a: " + destinatario);
        System.out.println("   Mensaje: " + mensaje);
    }
}