package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;

public class BandoNulo implements Bando {

    public static final BandoNulo INSTANCIA =
            new BandoNulo();

    private BandoNulo() {
    }
}