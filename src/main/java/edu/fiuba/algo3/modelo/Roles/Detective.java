package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteRol;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.*;
import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public class Detective extends Rol {

    public Detective() {
        super(BandoCiudadano.INSTANCIA);
    }

    private Bando resultadoInvestigacion = BandoNulo.INSTANCIA;

    @Override
    public AccionNocturna actuarNoche(Jugador actor, Jugador objetivo) {

        actor.validarEleccion(objetivo);
        actor.registrarEleccion(objetivo);

        return new Investigacion(actor, objetivo);
    }

    @Override
    public void recibirResultadoInvestigacion(Bando bando){
        resultadoInvestigacion = bando;
    }

    @Override
    public Bando resultadoInvestigacion(){
        return resultadoInvestigacion;
    }

    @Override
    public void registrarme(EstadoPartida estado, Jugador jugador) {

        estado.rolesEspeciales().registrarDetective(jugador);
    }

    @Override
    public TurnoNocturno agregarTurno(Jugador jugador, TurnoNocturno siguiente) {
        return new TurnoDetective(jugador, siguiente);
    }

    @Override
    public void aceptar(VisitanteRol visitante){
        visitante.visitarDetective(this);
    }
}