package edu.fiuba.algo3.modelo.Votacion.Nominaciones;

import edu.fiuba.algo3.modelo.Excepciones.JugadorNoNominadoException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Nominaciones {

    private final List<Nominacion> nominaciones = new ArrayList<>();

    public void registrar(Nominacion nominacion) {

        nominacion.validar();
        nominaciones.add(nominacion);
    }

    public void validarEstaNominado(Jugador jugador) {

        for (Nominacion nominacion : nominaciones) {
            if (nominacion.nominado().equals(jugador)) {
                return;
            }
        }

        throw new JugadorNoNominadoException();
    }
}
