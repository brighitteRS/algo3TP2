package edu.fiuba.algo3.modelo.Excepciones;

public class AccesoARolNoPermitidoExcepcion extends RuntimeException {

    public AccesoARolNoPermitidoExcepcion() {
        super("No puede ver el rol de otro jugador");
    }
}