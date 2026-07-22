package edu.fiuba.algo3.vistas.Partida;

import edu.fiuba.algo3.controllers.ControladorResultadoPartida;
import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class PantallaEliminaciones extends Pantalla {

    public PantallaEliminaciones(
            ControladorResultadoPartida controlador,
            JuegoControlador juegoControlador
    ){

        Label titulo = new Label("Jugadores eliminados");
        estiloTitulo(titulo);

        FlowPane eliminados = new FlowPane();

        eliminados.setHgap(15);
        eliminados.setVgap(15);
        eliminados.setAlignment(Pos.CENTER);


        for(int i = 0; i < controlador.cantidadEliminados();i++){

            Label eliminado =
                    new Label(
                            "Jugador " + controlador.idEliminado(i)
                    );

            estiloTextoClaro(eliminado);

            VBox jugadorBox = new VBox();

            jugadorBox.setSpacing(5);
            jugadorBox.setAlignment(Pos.CENTER);

            jugadorBox.getChildren().addAll(
                    eliminado,
                    controlador.cartaEliminado(i)
            );

            eliminados.getChildren().add(jugadorBox);
        }

        Button volver = new Button("Volver");

        estiloBoton(volver);

        volver.setOnAction(e ->
                juegoControlador.mostrarPantalla(
                        new PantallaFinal(
                                controlador,
                                juegoControlador
                        )
                )
        );

        setSpacing(20);
        setAlignment(Pos.CENTER);

        getChildren().addAll(
                titulo,
                eliminados,
                volver
        );
    }
}