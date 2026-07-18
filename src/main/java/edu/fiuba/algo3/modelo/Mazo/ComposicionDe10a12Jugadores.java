package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.Jugador.Rol;
import edu.fiuba.algo3.modelo.Roles.*;

import java.util.ArrayList;
import java.util.List;

public class ComposicionDe10a12Jugadores implements EstrategiaDeComposicion {

    @Override
    public List<Rol> crear(int cantidadJugadores) {

        List<Rol> cartas = new ArrayList<>();

        cartas.add(new Mafioso());
        cartas.add(new Mafioso());

        cartas.add(new Detective());
        cartas.add(new Medico());
        cartas.add(new Padrino());
        cartas.add(new Sheriff());

        completarConCiudadanos(cartas, cantidadJugadores);

        return cartas;
    }

    private void completarConCiudadanos(List<Rol> cartas, int cantidadJugadores) {
        while (cartas.size() < cantidadJugadores) {
            cartas.add(new Ciudadano());
        }
    }
}