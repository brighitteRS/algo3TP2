package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public abstract class ResultadoVotacion {

    public abstract AccionNocturna ataque();

    public abstract Jugador ganador();
}