package edu.fiuba.algo3.vistas.Fases.Noche;

import edu.fiuba.algo3.controllers.FaseNocturna.ControladorTurnoMafia;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class PantallaTurnoMafia extends Pantalla {

    public PantallaTurnoMafia(ControladorTurnoMafia controlador){

        Label titulo = new Label("NOCHE");

        Label turno = new Label(
                "Turno de Mafia"
        );

        Label mafiosoActual = new Label(
                "Jugador "
                        + controlador.idMafiosoActual()
                        + ", es tu turno"
        );

        Label instruccion = new Label(
                "Seleccione la víctima"
        );

        estiloTitulo(titulo);
        estiloTextoClaro(turno);
        estiloTextoClaro(mafiosoActual);
        estiloTextoClaro(instruccion);

        getChildren().addAll(
                titulo,
                turno,
                mafiosoActual,
                instruccion
        );

        FlowPane jugadores = new FlowPane();

        jugadores.setAlignment(Pos.CENTER);
        jugadores.setHgap(10);
        jugadores.setVgap(10);
        jugadores.setPrefWrapLength(450);

        for(int i = 0; i < controlador.cantidadObjetivos(); i++){

            int indice = i;

            Button boton = new Button(
                    "Jugador " + controlador.idObjetivo(indice)
            );

            estiloBoton(boton);

            boton.setOnAction(event -> {

                controlador.votar(controlador.objetivo(indice));

                if(!controlador.terminoVotacion()){

                    mafiosoActual.setText(
                            "Jugador "
                                    + controlador.idMafiosoActual()
                                    + ", es tu turno"
                    );
                }
            });

            jugadores.getChildren().add(boton);
        }

        getChildren().add(jugadores);
    }
}