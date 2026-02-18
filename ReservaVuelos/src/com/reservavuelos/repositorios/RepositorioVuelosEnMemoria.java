package com.reservavuelos.repositorios;

import com.reservavuelos.modelos.Vuelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// SRP: Solo se encarga de almacenar y recuperar vuelos en memoria
// OCP: Si se necesita otro repositorio (base de datos, API), se crea otra clase
//      que implemente IRepositorioVuelos sin modificar esta
public class RepositorioVuelosEnMemoria implements IRepositorioVuelos {

    private final List<Vuelo> listaVuelos = new ArrayList<>();

    @Override
    public List<Vuelo> buscarPorDestinoYFecha(String destino, LocalDate fecha) {
        return listaVuelos.stream()
                .filter(v -> v.getDestino().equalsIgnoreCase(destino)
                        && v.getFecha().equals(fecha)
                        && v.getAsientosDisponibles() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vuelo> obtenerTodos() {
        return new ArrayList<>(listaVuelos);
    }

    @Override
    public void guardar(Vuelo vuelo) {
        listaVuelos.add(vuelo);
    }
}