package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Excepciones.CantidadDeJugadoresInvalidaExcepcion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class GeneradorJugadores {

    private static final int MIN_JUGADORES = 5;
    private static final int MAX_JUGADORES = 12;

    public Jugadores crear(int cantidad) {

        if (cantidad < MIN_JUGADORES || cantidad > MAX_JUGADORES) {
            throw new CantidadDeJugadoresInvalidaExcepcion();
        }

        Jugadores jugadores = new Jugadores();

        for (int i = 1; i <= cantidad; i++) {
            jugadores.agregar(new Jugador(i));
        }

        return jugadores;
    }
}