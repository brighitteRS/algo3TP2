package edu.fiuba.algo3.controllers.FaseNocturna;

import edu.fiuba.algo3.modelo.Excepciones.MismaEleccionConsecutivaException;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoMedico;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;

public class ControladorTurnoMedico {

    private final ControladorFaseNocturna fase;
    private final TurnoMedico turno;

    public ControladorTurnoMedico(ControladorFaseNocturna controladorNocturno, TurnoMedico turno){

        this.fase = controladorNocturno;
        this.turno = turno;
    }

    public void proteger(Jugador objetivo){

        try {

            fase.registrar(
                    turno.medico().actuarNoche(objetivo)
            );

            fase.avanzar();

        } catch (MismaEleccionConsecutivaException e){

            fase.notificar(e.getMessage());
        }
    }

    public Jugadores objetivos(){

        return fase.jugadoresActivos();
    }
}