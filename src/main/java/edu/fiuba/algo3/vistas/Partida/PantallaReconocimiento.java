package edu.fiuba.algo3.vistas.Partida;

import edu.fiuba.algo3.controllers.ControladorReconocimiento;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.vistas.Pantalla;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PantallaReconocimiento extends Pantalla {

    public PantallaReconocimiento(ControladorReconocimiento controlador){

        Label titulo = new Label("RECONOCIMIENTO");

        Label jugador = new Label(
                "Jugador " + controlador.numeroJugadorActual()
        );

        Button ver = new Button("Ver");

        VBox informacion = new VBox();

        Button continuar = new Button("Continuar");

        ver.setOnAction(event -> {

            informacion.getChildren().clear();

            informacion.getChildren().add(
                    controlador.cartaJugadorActual()
            );

            Jugadores complices = controlador.complicesJugadorActual();

            if (!complices.todos().isEmpty()) {

                informacion.getChildren().add(
                        new Label("Tus cómplices:")
                );

                for (Jugador complice : complices.todos()) {

                    informacion.getChildren().add(
                            new Label("Jugador " + complice.id())
                    );
                }
            }
        });

        continuar.setOnAction(event ->
                controlador.continuar()
        );

        getChildren().addAll(
                titulo,
                jugador,
                ver,
                informacion,
                continuar
        );
    }
}