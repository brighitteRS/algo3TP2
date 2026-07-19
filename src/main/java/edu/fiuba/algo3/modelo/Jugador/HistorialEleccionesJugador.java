package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Excepciones.MismaEleccionConsecutivaException;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class HistorialEleccionesJugador {

    private Jugador ultimoObjetivo = JugadorNulo.INSTANCIA;

    public void validarRepeticion(Jugador objetivo) {

        if (ultimoObjetivo == objetivo) {
            throw new MismaEleccionConsecutivaException();
        }
    }

    public void registrarObjetivo(Jugador objetivo) {
        ultimoObjetivo = objetivo;
    }
}
