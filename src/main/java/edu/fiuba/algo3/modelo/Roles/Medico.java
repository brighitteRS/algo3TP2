package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.Rol;

public class Medico extends Rol {

    @Override
    public AccionNocturna actuarNoche(Jugador actor, Jugador objetivo) {
        return new Proteccion(objetivo);
    }
}