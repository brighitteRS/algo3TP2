package edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;

import edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna.VisitanteResultadoNocheVista;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class AtaqueBloqueado extends ResultadoNoche {

    private final Jugador jugador;

    public AtaqueBloqueado(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void aplicar(EstadoPartida estado) {
    }

    @Override
    public Jugador eliminado() {
        return JugadorNulo.INSTANCIA;
    }

    public Jugador objetivo() {
        return jugador;
    }

    @Override
    public void aceptarVisitante(VisitanteResultadoNocheVista visitante){
        visitante.visitarAtaqueBloqueado(this);
    }
}