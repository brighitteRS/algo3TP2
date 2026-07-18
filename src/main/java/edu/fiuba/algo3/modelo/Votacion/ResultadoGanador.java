package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class ResultadoGanador extends ResultadoVotacion {

    private final Jugador ganador;

    public ResultadoGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    @Override
    public Jugador ganador() {
        return ganador;
    }

    @Override
    public AccionNocturna ataque() {
        return new Ataque(ganador);
    }
}
