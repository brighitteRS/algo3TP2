package edu.fiuba.algo3.modelo.Excepciones;

public class MazoVacioExcepcion extends RuntimeException {

    public MazoVacioExcepcion() {
        super("No hay más cartas disponibles");
    }
}
