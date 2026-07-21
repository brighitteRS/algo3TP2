package edu.fiuba.algo3.modelo.Excepciones;

public class JugadorMuertoException extends RuntimeException {

    public JugadorMuertoException() {
        super("El Jugador esta muerto");
    }
}
