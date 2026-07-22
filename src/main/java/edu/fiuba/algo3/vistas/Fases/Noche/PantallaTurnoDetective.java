package edu.fiuba.algo3.vistas.Fases.Noche;

import edu.fiuba.algo3.controllers.FaseNocturna.ControladorTurnoDetective;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class PantallaTurnoDetective extends Pantalla {

    public PantallaTurnoDetective(ControladorTurnoDetective controlador){

        Label titulo = new Label("Turno del Detective");

        Label instruccion = new Label(
                "Seleccione un jugador para investigar"
        );

        estiloTitulo(titulo);
        estiloTextoClaro(instruccion);

        FlowPane jugadores = new FlowPane();

        jugadores.setAlignment(Pos.CENTER);
        jugadores.setHgap(10);
        jugadores.setVgap(10);
        jugadores.setPrefWrapLength(450);

        for(int i = 0; i < controlador.cantidadObjetivos(); i++){

            int indice = i;

            Button boton = new Button(
                    "Jugador " + controlador.idObjetivo(indice)
            );

            estiloBoton(boton);

            boton.setOnAction(e -> {

                controlador.investigar(controlador.objetivo(indice));

                mostrarResultado(controlador);

            });

            jugadores.getChildren().add(boton);
        }

        getChildren().addAll(
                titulo,
                instruccion,
                jugadores
        );
    }

    private void mostrarResultado(ControladorTurnoDetective controlador){

        getChildren().clear();

        Label titulo = new Label("Resultado de la investigación");
        estiloTitulo(titulo);

        Label resultado = new Label(
                controlador.resultadoInvestigacion()
        );
        estiloTextoClaro(resultado);

        Button continuar = new Button("Continuar");
        estiloBoton(continuar);

        continuar.setOnAction(e -> {
            controlador.continuar();

        });

        getChildren().addAll(
                titulo,
                resultado,
                continuar
        );
    }
}