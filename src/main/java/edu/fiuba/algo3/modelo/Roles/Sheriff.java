package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteRol;
import edu.fiuba.algo3.modelo.Jugador.Bando.BandoCiudadano;
import edu.fiuba.algo3.modelo.Jugador.Rol;

public class Sheriff extends Rol {

    public Sheriff() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public void aceptar(VisitanteRol visitante){
        visitante.visitarSheriff(this);
    }
}