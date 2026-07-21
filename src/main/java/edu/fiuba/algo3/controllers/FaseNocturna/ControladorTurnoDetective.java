package edu.fiuba.algo3.controllers.FaseNocturna;

import edu.fiuba.algo3.modelo.Excepciones.MismaEleccionConsecutivaException;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoDetective;
import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;


public class ControladorTurnoDetective {

    private final ControladorFaseNocturna fase;
    private final TurnoDetective turno;

    public ControladorTurnoDetective(ControladorFaseNocturna controlador, TurnoDetective turno){
        this.fase = controlador;
        this.turno = turno;
    }

    public void investigar(Jugador objetivo){

        try {

            fase.registrar(
                    turno.detective().actuarNoche(objetivo)
            );

        } catch (MismaEleccionConsecutivaException e){

            fase.notificar(e.getMessage());
        }
    }

    public Bando obtenerInvestigacion(){
        return turno.detective().obtenerResultadoInvestigacion();
    }

    public void continuar(){
        fase.avanzar();
    }

    public Jugadores objetivos(){

        return fase.jugadoresActivos();
    }
}