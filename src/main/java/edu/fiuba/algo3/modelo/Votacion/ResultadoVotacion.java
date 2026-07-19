package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public abstract class ResultadoVotacion {

    public abstract Jugador ganador();

    public abstract void resolver(EstadoPartida estado);
}