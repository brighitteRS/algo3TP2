package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.controllers.Visitors.Bandos.VisitanteBando;
import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ContadorBandos;

public class BandoNulo implements Bando {

    public static final BandoNulo INSTANCIA = new BandoNulo();

    private BandoNulo() {
    }

    @Override
    public void contabilizar(ContadorBandos contador) {}

    @Override
    public void aceptarVisitante(VisitanteBando visitante) {
    }
}