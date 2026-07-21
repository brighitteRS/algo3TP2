package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.Visitors.VisitanteRol;
import edu.fiuba.algo3.modelo.Jugador.Bando.BandoCiudadano;
import edu.fiuba.algo3.modelo.Jugador.Rol;

public class Ciudadano extends Rol {

    public Ciudadano() {
        super(BandoCiudadano.INSTANCIA);
    }

    @Override
    public void aceptar(VisitanteRol visitante){
        visitante.visitarCiudadano(this);
    }
}
