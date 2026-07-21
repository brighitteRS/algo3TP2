package edu.fiuba.algo3.vistas.Fases.Noche;

import edu.fiuba.algo3.controllers.FaseNocturna.ControladorTurnoMafia;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaTurnoMafia extends Pantalla {

    public PantallaTurnoMafia(ControladorTurnoMafia controlador){

        Label titulo = new Label("Comenzó la Noche");

        Label turno = new Label("Turno de Mafia");

        Label mafiosoActual = new Label(
                "Vota el mafioso: " + controlador.idMafiosoActual()
        );

        getChildren().addAll(
                titulo,
                turno,
                mafiosoActual
        );

        for(Jugador jugador : controlador.objetivos().todos()){

            Button boton = new Button(
                    "Jugador " + jugador.id()
            );

            boton.setOnAction(event -> {

                controlador.votar(jugador);

                if(!controlador.terminoVotacion()){

                    mafiosoActual.setText(
                            "Vota el mafioso: "
                                    + controlador.idMafiosoActual()
                    );
                }
            });

            getChildren().add(boton);
        }
    }
}