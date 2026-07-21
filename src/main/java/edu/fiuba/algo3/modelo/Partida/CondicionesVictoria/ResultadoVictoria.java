package edu.fiuba.algo3.modelo.Partida.CondicionesVictoria;

import edu.fiuba.algo3.controllers.Visitors.Partida.VisitanteVictoria;
import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;

public interface ResultadoVictoria {

    boolean termino();

    Bando ganador();

    void aceptarVisitante(VisitanteVictoria visitante);
}