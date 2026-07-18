package edu.fiuba.algo3.modelo.Excepciones;

public class JugadorMuertoNoPuedeActuarException extends RuntimeException {

    public JugadorMuertoNoPuedeActuarException() {
        super("Un jugador muerto no puede realizar esta acción.");
    }
}
