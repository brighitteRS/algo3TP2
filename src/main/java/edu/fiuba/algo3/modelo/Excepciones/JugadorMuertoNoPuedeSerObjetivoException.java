package edu.fiuba.algo3.modelo.Excepciones;

public class JugadorMuertoNoPuedeSerObjetivoException extends RuntimeException {

    public JugadorMuertoNoPuedeSerObjetivoException() {
        super("No se puede seleccionar como objetivo a un jugador muerto.");
    }
}
