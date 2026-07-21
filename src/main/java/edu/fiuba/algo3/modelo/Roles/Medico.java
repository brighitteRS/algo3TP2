package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteRol;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Jugador.Bando.BandoCiudadano;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public class Medico extends Rol {

    public Medico() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public AccionNocturna actuarNoche(Jugador actor, Jugador objetivo) {

        actor.validarEleccion(objetivo);
        actor.registrarEleccion(objetivo);

        return new Proteccion(objetivo);
    }

    @Override
    public void registrarme(EstadoPartida estado, Jugador jugador) {

        estado.rolesEspeciales().registrarMedico(jugador);
    }

    @Override
    public TurnoNocturno agregarTurno(Jugador jugador, TurnoNocturno siguiente) {
        return new TurnoMedico(jugador, siguiente);
    }

    @Override
    public void aceptar(VisitanteRol visitante){
        visitante.visitarMedico(this);
    }
}