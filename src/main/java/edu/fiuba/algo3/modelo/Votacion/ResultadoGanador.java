package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public class ResultadoGanador extends ResultadoVotacion {

    private final Jugador ganador;

    public ResultadoGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    @Override
    public AccionNocturna accion(){
        return new Ataque(ganador);
    }

    @Override
    public void resolver(EstadoPartida estado){
        estado.eliminar(ganador);
    }

    @Override
    public Jugador ganador() {
        return ganador;
    }
}