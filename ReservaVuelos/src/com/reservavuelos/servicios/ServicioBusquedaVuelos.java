package com.reservavuelos.servicios;

import com.reservavuelos.modelos.Vuelo;
import com.reservavuelos.repositorios.IRepositorioVuelos;
import java.time.LocalDate;
import java.util.List;

// SRP: SOLO se encarga de buscar vuelos, ninguna otra responsabilidad
// DIP: Depende de IRepositorioVuelos (abstracción), no de la implementación concreta
public class ServicioBusquedaVuelos {

    private final IRepositorioVuelos repositorioVuelos;

    // Inyección de dependencias por constructor
    public ServicioBusquedaVuelos(IRepositorioVuelos repositorioVuelos) {
        this.repositorioVuelos = repositorioVuelos;
    }

    public List<Vuelo> buscarVuelos(String destino, LocalDate fecha) {
        System.out.printf("%n Buscando vuelos a '%s' para el %s...%n", destino, fecha);
        List<Vuelo> resultados = repositorioVuelos.buscarPorDestinoYFecha(destino, fecha);

        if (resultados.isEmpty()) {
            System.out.println(" No se encontraron vuelos disponibles.");
        } else {
            System.out.println(" Vuelos encontrados:");
            resultados.forEach(v -> System.out.println("   " + v));
        }
        return resultados;
    }
}