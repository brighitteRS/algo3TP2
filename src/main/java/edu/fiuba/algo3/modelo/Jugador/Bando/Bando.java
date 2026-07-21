package edu.fiuba.algo3.modelo.Jugador.Bando;

import edu.fiuba.algo3.controllers.Visitors.Bandos.VisitanteBando;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ContadorBandos;

public interface Bando {

    void contabilizar(ContadorBandos contador);

    void aceptarVisitante(VisitanteBando visitante);
}