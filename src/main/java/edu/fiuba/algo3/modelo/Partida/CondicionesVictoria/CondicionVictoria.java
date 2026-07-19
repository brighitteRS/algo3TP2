package edu.fiuba.algo3.modelo.Partida.CondicionesVictoria;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public interface CondicionVictoria {

    ResultadoVictoria evaluar(EstadoPartida estado);
}