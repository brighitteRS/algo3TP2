package edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna;

import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.*;

public interface VisitanteTurno {

    void visitarTurnoMafia(TurnoMafia turno);

    void visitarTurnoDetective(TurnoDetective turno);

    void visitarTurnoMedico(TurnoMedico turno);

    void visitarTurnoFinal(TurnoFinal turno);
}