package edu.fiuba.algo3.vistas.Fases.Noche;

import edu.fiuba.algo3.controllers.FaseNocturna.ControladorTurnoDetective;
import edu.fiuba.algo3.controllers.Visitors.Bandos.VisitanteResultadoBando;
import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaTurnoDetective extends Pantalla {

    public PantallaTurnoDetective(ControladorTurnoDetective controlador){

        Label titulo = new Label("Turno del Detective");

        getChildren().add(titulo);


        for(Jugador jugador : controlador.objetivos().todos()){

            Button boton = new Button(
                    "Investigar jugador " + jugador.id()
            );

            boton.setOnAction(e -> {

                controlador.investigar(jugador);

                mostrarResultado(controlador);

            });

            getChildren().add(boton);
        }
    }


    private void mostrarResultado(ControladorTurnoDetective controlador){

        getChildren().clear();

        Bando bando = controlador.obtenerInvestigacion();

        VisitanteResultadoBando visitante =
                new VisitanteResultadoBando();

        bando.aceptarVisitante(visitante);


        Button continuar = new Button("Continuar");

        continuar.setOnAction(e -> {

            controlador.continuar();

        });

        getChildren().addAll(
                visitante.resultado(),
                continuar
        );
    }
}