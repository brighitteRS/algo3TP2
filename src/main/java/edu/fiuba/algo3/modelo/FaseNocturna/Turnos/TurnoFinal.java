package edu.fiuba.algo3.modelo.FaseNocturna.Turnos;

import edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna.VisitanteTurno;

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