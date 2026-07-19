package edu.fiuba.algo3.modelo.Excepciones;

public class JugadorNoNominadoException extends RuntimeException {

    public JugadorNoNominadoException() {
        super("El jugador no esta Nominado por lo que no se puede votar");
    }
}
