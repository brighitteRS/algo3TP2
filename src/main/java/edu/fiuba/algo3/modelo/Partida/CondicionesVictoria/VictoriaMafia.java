package edu.fiuba.algo3.modelo.Partida.CondicionesVictoria;

import edu.fiuba.algo3.modelo.Visitors.VisitanteVictoria;
import edu.fiuba.algo3.modelo.Jugador.Bando.*;

public class VictoriaMafia implements ResultadoVictoria {

    @Override
    public boolean termino() {
        return true;
    }

    @Override
    public Bando ganador() {
        return BandoMafia.INSTANCIA;
    }

    @Override
    public void aceptarVisitante(VisitanteVictoria visitante){
        visitante.visitarVictoriaMafia(this);
    }
}