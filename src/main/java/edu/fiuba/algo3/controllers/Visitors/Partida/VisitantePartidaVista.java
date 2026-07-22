package edu.fiuba.algo3.controllers.Visitors.Partida;

import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;
import edu.fiuba.algo3.modelo.Visitors.VisitanteVictoria;

import javafx.scene.control.Label;

public class VisitantePartidaVista implements VisitanteVictoria {

    private Label pantalla;

    @Override
    public void visitarVictoriaMafia(VictoriaMafia victoria){

        pantalla = crearMensaje(
                "La Mafia ganó la partida"
        );
    }

    @Override
    public void visitarVictoriaCiudadanos(VictoriaCiudadanos victoria){

        pantalla = crearMensaje(
                "Los Ciudadanos ganaron la partida"
        );
    }

    @Override
    public void visitarSinVictoria(SinVictoria victoria){

        pantalla = crearMensaje(
                "La partida continúa"
        );
    }

    public Label pantalla(){

        return pantalla;
    }

    private Label crearMensaje(String texto){

        Label label = new Label(texto);

        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 22px;"
        );

        return label;
    }
}