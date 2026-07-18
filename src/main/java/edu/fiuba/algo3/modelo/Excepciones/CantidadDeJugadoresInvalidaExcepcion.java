package edu.fiuba.algo3.modelo.Excepciones;

public class CantidadDeJugadoresInvalidaExcepcion extends RuntimeException {

    public CantidadDeJugadoresInvalidaExcepcion() {
        super("La cantidad de jugadores debe estar entre 5 y 12");
    }
}
