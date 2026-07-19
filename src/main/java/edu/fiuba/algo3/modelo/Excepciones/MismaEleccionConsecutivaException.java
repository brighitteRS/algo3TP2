package edu.fiuba.algo3.modelo.Excepciones;

public class MismaEleccionConsecutivaException extends RuntimeException {

    public MismaEleccionConsecutivaException() {
        super("No puede elegir al mismo jugador dos noches consecutivas");
    }
}
