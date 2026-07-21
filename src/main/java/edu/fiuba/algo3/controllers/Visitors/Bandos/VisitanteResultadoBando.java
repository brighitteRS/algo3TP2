package edu.fiuba.algo3.controllers.Visitors.Bandos;

import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Visitors.VisitanteBando;
import javafx.scene.control.Label;

public class VisitanteResultadoBando implements VisitanteBando {

    private Label resultado;

    @Override
    public void visitarMafia(BandoMafia mafia){

        resultado = new Label("BANDO MAFIA");
    }

    @Override
    public void visitarCiudadano(BandoCiudadano ciudadano){

        resultado = new Label("BANDO CIUDADANO");
    }

    public Label resultado(){

        return resultado;
    }
}