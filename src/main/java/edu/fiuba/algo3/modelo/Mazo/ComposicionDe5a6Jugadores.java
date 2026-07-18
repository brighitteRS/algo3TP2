package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.Jugador.Rol;
import edu.fiuba.algo3.modelo.Roles.*;

import java.util.ArrayList;
import java.util.List;

public class ComposicionDe5a6Jugadores implements EstrategiaDeComposicion {

    @Override
    public List<Rol> crear(int cantidadJugadores) {

        List<Rol> cartas = new ArrayList<>();

        cartas.add(new Mafioso());
        cartas.add(new Mafioso());
        cartas.add(new Medico());

        completarConCiudadanos(cartas, cantidadJugadores);

        return cartas;
    }

    private void completarConCiudadanos(List<Rol> cartas, int cantidadJugadores) {
        while (cartas.size() < cantidadJugadores) {
            cartas.add(new Ciudadano());
        }
    }
}