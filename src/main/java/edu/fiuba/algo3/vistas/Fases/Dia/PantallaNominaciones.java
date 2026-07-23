package edu.fiuba.algo3.vistas.Fases.Dia;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorNominaciones;
import edu.fiuba.algo3.vistas.Pantalla;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaNominaciones extends Pantalla {

    public PantallaNominaciones(ControladorNominaciones controlador){

        Label titulo = new Label("Nominaciones");
        estiloTitulo(titulo);

        setSpacing(15);
        setAlignment(Pos.CENTER);

        getChildren().add(titulo);

        Label jugador = new Label("Jugador " + controlador.idJugador() + ", es tu turno");
        estiloTextoClaro(jugador);
        getChildren().add(jugador);

        for(int i = 0; i < controlador.cantidadCandidatos(); i++) {

            int indice = i;

            Button boton = new Button(
                    "Nominar jugador "
                            + controlador.idCandidato(indice)
            );

            estiloBoton(boton);

            boton.setOnAction(e ->
                    controlador.nominar(
                            controlador.candidato(indice)
                    )
            );

            getChildren().add(boton);
        }
    }
}