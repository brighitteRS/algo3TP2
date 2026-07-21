package edu.fiuba.algo3.controllers.Visitors.Partida;

import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class VisitantePartidaVista implements VisitanteVictoria {

    private VBox pantalla;

    @Override
    public void visitarVictoriaMafia(VictoriaMafia victoria){

        pantalla = new VBox(
                new Label("La Mafia ganó la partida")
        );
    }

    @Override
    public void visitarVictoriaCiudadanos(VictoriaCiudadanos victoria){

        pantalla = new VBox(
                new Label("Los Ciudadanos ganaron la partida")
        );
    }

    @Override
    public void visitarSinVictoria(SinVictoria victoria){

        pantalla = new VBox(
                new Label("La partida continúa")
        );
    }

    public VBox pantalla(){

        return pantalla;
    }
}