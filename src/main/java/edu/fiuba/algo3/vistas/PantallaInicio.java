package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.JuegoControlador;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class PantallaInicio extends Pantalla {

    public PantallaInicio(JuegoControlador controlador){

        Label titulo = new Label("MAFIA");

        Label jugadores = new Label(
                "Cantidad de jugadores:"
        );

        TextField cantidad = new TextField();

        Button iniciar = new Button(
                "Iniciar partida"
        );

        iniciar.setOnAction(event -> {

            try {

                int cantidadJugadores =
                        Integer.parseInt(
                                cantidad.getText().trim()
                        );


                controlador.iniciarPartida(cantidadJugadores);


            }
            catch(NumberFormatException e){

                controlador.notificar(
                        "Ingrese una cantidad válida"
                );
            }
        });

        setSpacing(20);

        setAlignment(Pos.CENTER);

        getChildren().addAll(
                titulo,
                jugadores,
                cantidad,
                iniciar
        );


    }

}