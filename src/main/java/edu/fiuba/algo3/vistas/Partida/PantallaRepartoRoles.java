package edu.fiuba.algo3.vistas.Partida;

import edu.fiuba.algo3.controllers.ControladorRepartoRoles;
import edu.fiuba.algo3.controllers.Visitors.Roles.CartaRolVista;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PantallaRepartoRoles extends Pantalla {

    public PantallaRepartoRoles(ControladorRepartoRoles controlador){

        Label titulo = new Label("REPARTO DE ROLES");
        estiloTitulo(titulo);

        Label jugador = new Label(
                "Jugador " + controlador.numeroJugadorActual()
        );
        estiloTextoClaro(jugador);

        Button verCarta = new Button("Ver mi carta");
        Button continuar = new Button("Continuar");

        estiloBoton(verCarta);
        estiloBoton(continuar);

        VBox carta = new VBox();
        carta.setAlignment(Pos.CENTER);

        verCarta.setOnAction(event -> {

            CartaRolVista cartaRol =
                    controlador.cartaJugadorActual();

            carta.getChildren().setAll(cartaRol);

        });

        continuar.setOnAction(event -> {

            controlador.continuar();

        });

        setSpacing(20);
        setAlignment(Pos.CENTER);

        getChildren().addAll(
                titulo,
                jugador,
                verCarta,
                carta,
                continuar
        );

    }

}