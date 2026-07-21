package edu.fiuba.algo3.vistas.Fases.Noche;

import edu.fiuba.algo3.controllers.FaseNocturna.ControladorTurnoMedico;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vistas.Pantalla;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaTurnoMedico extends Pantalla {

    public PantallaTurnoMedico(ControladorTurnoMedico controlador){

        Label titulo = new Label("Turno del Médico");

        getChildren().add(titulo);

        for(Jugador jugador : controlador.objetivos().todos()){

            Button boton = new Button(
                    "Proteger Jugador " + jugador.id()
            );

            boton.setOnAction(e -> {

                controlador.proteger(jugador);

            });

            getChildren().add(boton);
        }
    }
}