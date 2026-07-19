package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Jugador.Bando.BandoCiudadano;

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
}