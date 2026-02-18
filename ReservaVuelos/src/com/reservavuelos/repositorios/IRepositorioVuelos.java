package com.reservavuelos.repositorios;

import com.reservavuelos.modelos.Vuelo;
import java.time.LocalDate;
import java.util.List;

// ISP: Interfaz pequeña y específica para el repositorio de vuelos
// DIP: Los servicios dependerán de esta abstracción, no de la implementación concreta
public interface IRepositorioVuelos {
    List<Vuelo> buscarPorDestinoYFecha(String destino, LocalDate fecha);
    List<Vuelo> obtenerTodos();
    void guardar(Vuelo vuelo);
}