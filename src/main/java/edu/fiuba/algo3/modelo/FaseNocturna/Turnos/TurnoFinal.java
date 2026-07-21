package edu.fiuba.algo3.modelo.FaseNocturna.Turnos;

import edu.fiuba.algo3.modelo.Visitors.VisitanteTurno;

public class TurnoFinal implements TurnoNocturno {

    @Override
    public TurnoNocturno siguiente() {
        return this;
    }

    @Override
    public void aceptarVisitante(VisitanteTurno visitante){
        visitante.visitarTurnoFinal(this);
    }
}