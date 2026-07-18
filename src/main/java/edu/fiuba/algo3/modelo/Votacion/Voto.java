package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Voto {

    private final Jugador votante;
    private final Jugador votado;

    public Voto(Jugador votante, Jugador votado) {
        this.votante = votante;
        this.votado = votado;
    }

    public Jugador votado() {
        return votado;
    }

    public boolean esDe(Jugador jugador){
        return votante == jugador;
    }

    public boolean apuntaA(Jugador jugador){
        return votado == jugador;
    }
}

