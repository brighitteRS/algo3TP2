package edu.fiuba.algo3.vistas.Fases.Dia;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorVotacion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vistas.Pantalla;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaVotacion extends Pantalla {

    public PantallaVotacion(ControladorVotacion controlador){

        Label titulo = new Label("Votación");

        getChildren().add(titulo);

        for(Jugador jugador : controlador.candidatos().todos()){

            Button boton = new Button(
                    "Votar a jugador " + jugador.id()
            );

            boton.setOnAction(e ->
                    controlador.votar(jugador)
            );

            getChildren().add(boton);
        }

        Button abstener = new Button("Abstenerse");

        abstener.setOnAction(e ->
                controlador.abstenerse()
        );

        getChildren().add(abstener);
    }
}