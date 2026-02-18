package com.reservavuelos.modelos;

import java.time.LocalDate;

// SRP: Esta clase solo representa un vuelo como entidad de datos
public class Vuelo {
    private String idVuelo;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private double precio;
    private int asientosDisponibles;

    public Vuelo(String idVuelo, String origen, String destino,
                 LocalDate fecha, double precio, int asientosDisponibles) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.precio = precio;
        this.asientosDisponibles = asientosDisponibles;
    }

    // Getters
    public String getIdVuelo()             { return idVuelo; }
    public String getOrigen()              { return origen; }
    public String getDestino()             { return destino; }
    public LocalDate getFecha()            { return fecha; }
    public double getPrecio()              { return precio; }
    public int getAsientosDisponibles()    { return asientosDisponibles; }

    // Setter
    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s -> %s | Fecha: %s | Precio: $%.2f | Asientos: %d",
                idVuelo, origen, destino, fecha, precio, asientosDisponibles);
    }
}