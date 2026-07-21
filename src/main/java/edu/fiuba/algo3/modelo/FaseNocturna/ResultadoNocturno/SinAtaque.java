package edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Visitors.VisitanteResultadoNoche;

public class SinAtaque extends ResultadoNoche {

    @Override
    public void aplicar(EstadoPartida estado) {}

    @Override
    public Jugador eliminado() {
        return JugadorNulo.INSTANCIA;
    }

    @Override
    public void aceptarVisitante(VisitanteResultadoNoche visitante){
        visitante.visitarSinAtaque(this);
    }
}
