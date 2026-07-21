package edu.fiuba.algo3.vistas.Fases.Dia;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorNominaciones;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vistas.Pantalla;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaNominaciones extends Pantalla {

    public PantallaNominaciones(ControladorNominaciones controlador){

        Label titulo = new Label("Nominaciones");

        getChildren().add(titulo);

        for(Jugador jugador : controlador.candidatos().todos()){

            Button boton = new Button(
                    "Nominar jugador " + jugador.id()
            );

            boton.setOnAction(e ->
                    controlador.nominar(jugador)
            );

            getChildren().add(boton);
        }
    }
}