package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

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
}