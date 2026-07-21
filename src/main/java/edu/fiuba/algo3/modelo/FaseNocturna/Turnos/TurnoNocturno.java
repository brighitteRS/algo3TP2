package edu.fiuba.algo3.modelo.FaseNocturna.Turnos;

import edu.fiuba.algo3.modelo.Visitors.VisitanteTurno;

public interface TurnoNocturno {

    TurnoNocturno siguiente();

    void aceptarVisitante(VisitanteTurno visitante);
}