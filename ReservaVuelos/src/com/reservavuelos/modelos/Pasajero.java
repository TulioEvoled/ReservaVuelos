package com.reservavuelos.modelos;

// SRP: Solo representa al pasajero con su información personal
public class Pasajero {
    private String idPasajero;
    private String nombre;
    private String correo;
    private String telefono;

    public Pasajero(String idPasajero, String nombre, String correo, String telefono) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getIdPasajero() { return idPasajero; }
    public String getNombre()     { return nombre; }
    public String getCorreo()     { return correo; }
    public String getTelefono()   { return telefono; }

    @Override
    public String toString() {
        return String.format("Pasajero[%s]: %s | Correo: %s | Tel: %s",
                idPasajero, nombre, correo, telefono);
    }
}