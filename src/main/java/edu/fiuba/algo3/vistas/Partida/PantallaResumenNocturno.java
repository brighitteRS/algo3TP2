package edu.fiuba.algo3.vistas.Partida;

import edu.fiuba.algo3.controllers.ControladorResultadoPartida;
import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class PantallaResumenNocturno extends Pantalla {

    public PantallaResumenNocturno(
            ControladorResultadoPartida controlador,
            JuegoControlador juegoControlador
    ){

        Label titulo = new Label("Resumen de noches");
        estiloTitulo(titulo);


        VBox contenido = new VBox();
        contenido.setSpacing(10);
        contenido.setStyle(
                "-fx-background-color: #060e17;"
        );

        for(String texto : controlador.resumenNoches()){

            Label label = new Label(texto);

            estiloTextoClaro(label);

            contenido.getChildren().add(label);
        }

        ScrollPane scroll = new ScrollPane();

        scroll.setContent(contenido);
        scroll.setFitToWidth(true);
        scroll.setPrefHeight(450);

        scroll.setStyle(
                "-fx-background: #060e17;" +
                        "-fx-background-color: #060e17;"
        );

        Button volver = new Button("Volver");

        estiloBoton(volver);

        volver.setOnAction(e -> {

            juegoControlador.mostrarPantalla(
                    new PantallaFinal(
                            controlador,
                            juegoControlador
                    )
            );

        });

        getChildren().addAll(
                titulo,
                scroll,
                volver
        );
    }
}
