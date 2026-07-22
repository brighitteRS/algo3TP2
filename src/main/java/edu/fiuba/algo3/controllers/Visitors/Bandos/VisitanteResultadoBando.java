package edu.fiuba.algo3.controllers.Visitors.Bandos;

import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Visitors.VisitanteBando;

public class VisitanteResultadoBando implements VisitanteBando {

    private String resultado;

    @Override
    public void visitarMafia(BandoMafia mafia){

        resultado = "BANDO MAFIA";
    }

    @Override
    public void visitarCiudadano(BandoCiudadano ciudadano){

        resultado = "BANDO CIUDADANO";
    }

    public String resultado(){

        return resultado;
    }
}