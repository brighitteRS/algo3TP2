package edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class AtaqueExitoso extends ResultadoNoche {

    private final Jugador jugador;

    public AtaqueExitoso(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void aplicar(EstadoPartida estado) {
        estado.eliminar(jugador);
    }

    @Override
    public Jugador eliminado() {
        return jugador;
    }
}