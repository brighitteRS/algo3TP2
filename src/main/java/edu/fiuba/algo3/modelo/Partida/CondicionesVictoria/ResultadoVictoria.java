package edu.fiuba.algo3.modelo.Partida.CondicionesVictoria;

import edu.fiuba.algo3.modelo.Visitors.VisitanteVictoria;
import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;

public interface ResultadoVictoria {

    boolean termino();

    Bando ganador();

    void aceptarVisitante(VisitanteVictoria visitante);
}