package edu.fiuba.algo3.modelo.Excepciones;

public class NoSePuedeAtacarAMafiosoException extends RuntimeException {
    public NoSePuedeAtacarAMafiosoException() {
        super("El objetivo es un miembro de la Mafia");
    }
}
