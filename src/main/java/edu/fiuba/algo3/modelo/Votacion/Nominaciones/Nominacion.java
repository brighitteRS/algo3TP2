package edu.fiuba.algo3.modelo.Votacion.Nominaciones;

import edu.fiuba.algo3.modelo.Excepciones.NominacionExistenteException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Nominacion {

    private final Jugador nominador;
    private final Jugador nominado;

    public Nominacion(Jugador nominador, Jugador nominado) {
        this.nominador = nominador;
        this.nominado = nominado;
    }

    public void validar() {

        nominador.validarPuedeActuar();
        nominado.validarPuedeSerObjetivo();

        if (nominador.equals(nominado)) {
            throw new NominacionExistenteException();
        }
    }

    public Jugador nominado() {
        return nominado;
    }
}