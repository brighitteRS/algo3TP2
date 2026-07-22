package edu.fiuba.algo3.vistas.Partida;

import edu.fiuba.algo3.controllers.ControladorReconocimiento;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PantallaReconocimiento extends Pantalla {

    public PantallaReconocimiento(ControladorReconocimiento controlador){

        Label titulo = new Label("RECONOCIMIENTO DE MAFIA");

        Label jugador = new Label(
                "Jugador " + controlador.numeroJugadorActual()
        );

        Label instruccion = new Label(
                "Revisa tus cómplices antes de continuar."
        );

        estiloTitulo(titulo);
        estiloTextoClaro(jugador);
        estiloTextoClaro(instruccion);

        Button ver = new Button("Ver cómplices");
        Button continuar = new Button("Continuar");

        estiloBoton(ver);
        estiloBoton(continuar);

        VBox informacion = new VBox();

        informacion.setSpacing(10);
        informacion.setAlignment(Pos.CENTER);

        ver.setOnAction(event -> {

            informacion.getChildren().clear();

            if(controlador.tieneComplices()) {

                Label tituloComplices = new Label("Tus cómplices:");
                estiloTextoClaro(tituloComplices);

                informacion.getChildren().add(tituloComplices);

                for(int i = 0; i < controlador.cantidadComplices(); i++){

                    Label compliceLabel =
                            new Label(
                                    "Jugador "
                                            + controlador.idComplice(i)
                            );

                    estiloTextoClaro(compliceLabel);

                    informacion.getChildren().add(compliceLabel);
                }

            } else {

                Label mensaje = new Label(
                        "No tienes cómplices para reconocer."
                );

                estiloTextoClaro(mensaje);

                informacion.getChildren().add(mensaje);
            }
        });

        continuar.setOnAction(event ->
                controlador.continuar()
        );

        getChildren().addAll(
                titulo,
                jugador,
                instruccion,
                ver,
                informacion,
                continuar
        );
    }
}