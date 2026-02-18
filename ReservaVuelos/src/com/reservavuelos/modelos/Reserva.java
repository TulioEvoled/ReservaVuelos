package com.reservavuelos.modelos;

// SRP: Solo representa la reserva como entidad de datos
public class Reserva {
    private String idReserva;
    private Vuelo vuelo;
    private Pasajero pasajero;
    private String estado; // CONFIRMADA, PENDIENTE, CANCELADA
    private double costoTotal;

    public Reserva(String idReserva, Vuelo vuelo, Pasajero pasajero, double costoTotal) {
        this.idReserva = idReserva;
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.costoTotal = costoTotal;
        this.estado = "CONFIRMADA";
    }

    public String getIdReserva()  { return idReserva; }
    public Vuelo getVuelo()       { return vuelo; }
    public Pasajero getPasajero() { return pasajero; }
    public String getEstado()     { return estado; }
    public double getCostoTotal() { return costoTotal; }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return String.format(
            "\n===== RESERVA =====\n" +
            "ID: %s\nEstado: %s\n%s\n%s\nTotal: $%.2f\n===================",
            idReserva, estado, vuelo, pasajero, costoTotal);
    }
}