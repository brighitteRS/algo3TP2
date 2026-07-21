package edu.fiuba.algo3.modelo.FaseNocturna.Turnos;

import edu.fiuba.algo3.modelo.Visitors.VisitanteTurno;
import edu.fiuba.algo3.modelo.Mafia;

public class TurnoMafia implements TurnoNocturno {

    private final Mafia mafia;
    private final TurnoNocturno siguiente;

    public TurnoMafia(Mafia mafia, TurnoNocturno siguiente) {
        this.mafia = mafia;
        this.siguiente = siguiente;
    }

    public Mafia mafia() {
        return mafia;
    }

    @Override
    public TurnoNocturno siguiente() {
        return siguiente;
    }

    @Override
    public void aceptarVisitante(VisitanteTurno visitante){
        visitante.visitarTurnoMafia(this);
    }
}