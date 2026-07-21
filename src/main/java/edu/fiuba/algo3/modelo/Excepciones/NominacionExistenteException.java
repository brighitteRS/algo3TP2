package edu.fiuba.algo3.modelo.Excepciones;

public class NominacionExistenteException extends RuntimeException {

    public NominacionExistenteException() {
        super("Ya se realizo esta Nominacion");
    }
}
