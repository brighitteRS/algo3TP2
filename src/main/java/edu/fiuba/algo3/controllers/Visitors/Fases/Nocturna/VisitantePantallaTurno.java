package edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna;

import edu.fiuba.algo3.controllers.FaseNocturna.*;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.*;
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.vistas.Fases.Noche.PantallaNocheTerminada;
import edu.fiuba.algo3.vistas.Fases.Noche.PantallaTurnoDetective;
import edu.fiuba.algo3.vistas.Fases.Noche.PantallaTurnoMafia;
import edu.fiuba.algo3.vistas.Fases.Noche.PantallaTurnoMedico;

public class VisitantePantallaTurno implements VisitanteTurno {

    private final ControladorFaseNocturna controladorNocturno;
    private Pantalla pantalla;

    public VisitantePantallaTurno(ControladorFaseNocturna controlador){
        this.controladorNocturno = controlador;
    }

    @Override
    public void visitarTurnoMafia(TurnoMafia turno){

        pantalla = new PantallaTurnoMafia(
                new ControladorTurnoMafia(controladorNocturno, turno)
        );
    }

    @Override
    public void visitarTurnoMedico(TurnoMedico turno){

        pantalla = new PantallaTurnoMedico(
                new ControladorTurnoMedico(controladorNocturno, turno)
        );
    }

    @Override
    public void visitarTurnoDetective(TurnoDetective turno){

        pantalla = new PantallaTurnoDetective(
                new ControladorTurnoDetective(controladorNocturno, turno)
        );
    }

    @Override
    public void visitarTurnoFinal(TurnoFinal turno) {

        ControladorTurnoFinal controlador =
                new ControladorTurnoFinal(
                        controladorNocturno,turno
                );

        pantalla = new PantallaNocheTerminada(controlador);
    }

    public Pantalla pantalla(){
        return pantalla;
    }
}