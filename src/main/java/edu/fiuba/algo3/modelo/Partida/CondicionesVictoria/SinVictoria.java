package edu.fiuba.algo3.modelo.Partida.CondicionesVictoria;

import edu.fiuba.algo3.controllers.Visitors.Partida.VisitanteVictoria;
import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

public class SinVictoria implements ResultadoVictoria {

    @Override
    public boolean termino() {
        return false;
    }

    @Override
    public Bando ganador() {
        return BandoNulo.INSTANCIA;
    }

    @Override
    public void aceptarVisitante(VisitanteVictoria visitante){
        visitante.visitarSinVictoria(this);
    }
}