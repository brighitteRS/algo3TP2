package edu.fiuba.algo3.modelo.Votacion.ReglaDesempates;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Votacion.*;

public class DecisionPorPadrino implements ReglaDesempate {

    private final Jugador padrino;

    public DecisionPorPadrino(Jugador padrino){
        this.padrino = padrino;
    }

    public ResultadoVotacion resolver(Votacion votacion){

        Jugador voto = votacion.votoDe(padrino);

        return new ResultadoGanador(voto);
    }
}