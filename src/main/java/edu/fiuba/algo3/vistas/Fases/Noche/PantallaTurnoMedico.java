package edu.fiuba.algo3.vistas.Fases.Noche;

import edu.fiuba.algo3.controllers.FaseNocturna.ControladorTurnoMedico;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class PantallaTurnoMedico extends Pantalla {

    public PantallaTurnoMedico(ControladorTurnoMedico controlador){

        Label titulo = new Label("Turno del Médico");

        Label instruccion = new Label(
                "Seleccione un jugador para proteger"
        );

        estiloTitulo(titulo);
        estiloTextoClaro(instruccion);

        FlowPane jugadores = new FlowPane();

        jugadores.setAlignment(Pos.CENTER);
        jugadores.setHgap(10);
        jugadores.setVgap(10);
        jugadores.setPrefWrapLength(450);

        for(int i = 0; i < controlador.cantidadObjetivos(); i++) {

            int indice = i;

            Button boton = new Button(
                    "Jugador " + controlador.idObjetivo(indice)
            );

            estiloBoton(boton);

            boton.setOnAction(e ->
                    controlador.proteger(
                            controlador.objetivo(indice)
                    )
            );

            jugadores.getChildren().add(boton);
        }

        getChildren().addAll(
                titulo,
                instruccion,
                jugadores
        );
    }
}