package edu.fiuba.algo3.modelo.FaseNocturna.Turnos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class TurnoDetective implements TurnoNocturno {

    private final Jugador detective;
    private final TurnoNocturno siguiente;

    public TurnoDetective(Jugador detective, TurnoNocturno siguiente) {
        this.detective = detective;
        this.siguiente = siguiente;
    }

    public Jugador detective() {
        return detective;
    }

    @Override
    public TurnoNocturno siguiente() {
        return siguiente;
    }
}
