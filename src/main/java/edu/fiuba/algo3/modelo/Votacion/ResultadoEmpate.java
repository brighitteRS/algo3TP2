package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public class ResultadoEmpate extends ResultadoVotacion {

    @Override
    public Jugador ganador(){
        return JugadorNulo.INSTANCIA;
    }

    @Override
    public void resolver(EstadoPartida estado){
    }
}