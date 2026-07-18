package edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class SinAtaque extends ResultadoNoche {

    @Override
    public void aplicar(EstadoPartida estado) {}

    @Override
    public Jugador eliminado() {
        return JugadorNulo.INSTANCIA;
    }
}
