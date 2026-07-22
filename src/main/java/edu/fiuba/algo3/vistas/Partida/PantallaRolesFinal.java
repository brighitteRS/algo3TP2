package edu.fiuba.algo3.vistas.Partida;

import edu.fiuba.algo3.controllers.ControladorResultadoPartida;
import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class PantallaRolesFinal extends Pantalla {

    public PantallaRolesFinal(
            ControladorResultadoPartida controlador,
            JuegoControlador juegoControlador
    ){

        Label titulo = new Label("Roles revelados");
        estiloTitulo(titulo);

        FlowPane jugadores = new FlowPane();

        jugadores.setHgap(15);
        jugadores.setVgap(15);
        jugadores.setAlignment(Pos.CENTER);

        for(int i = 0; i < controlador.cantidadJugadores(); i++){

            Label jugadorRol = new Label("Jugador " + controlador.idJugador(i));

            estiloTextoClaro(jugadorRol);

            VBox jugadorBox = new VBox();

            jugadorBox.setSpacing(5);
            jugadorBox.setAlignment(Pos.CENTER);

            jugadorBox.getChildren().addAll(
                    jugadorRol,
                    controlador.cartaJugador(i)
            );

            jugadores.getChildren().add(jugadorBox);
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
                jugadores,
                volver
        );
    }
}