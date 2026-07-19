package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public abstract class ResultadoVotacion {

    public abstract AccionNocturna accion();

    public abstract void resolver(EstadoPartida estado);

    public abstract Jugador ganador();
}