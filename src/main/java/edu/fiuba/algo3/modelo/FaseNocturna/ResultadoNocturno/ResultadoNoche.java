package edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;

import edu.fiuba.algo3.modelo.Visitors.VisitanteResultadoNoche;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public abstract class ResultadoNoche {

    public abstract void aplicar(EstadoPartida estado);

    public abstract Jugador eliminado();

    public abstract void aceptarVisitante(VisitanteResultadoNoche visitante);
}