package edu.fiuba.algo3.modelo.FaseNocturna.Turnos;

import edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna.VisitanteTurno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class TurnoMedico implements TurnoNocturno {

    private final Jugador medico;
    private final TurnoNocturno siguiente;

    public TurnoMedico(Jugador medico, TurnoNocturno siguiente) {
        this.medico = medico;
        this.siguiente = siguiente;
    }

    public Jugador medico() {
        return medico;
    }

    @Override
    public TurnoNocturno siguiente() {
        return siguiente;
    }

    @Override
    public void aceptarVisitante(VisitanteTurno visitante){
        visitante.visitarTurnoMedico(this);
    }
}