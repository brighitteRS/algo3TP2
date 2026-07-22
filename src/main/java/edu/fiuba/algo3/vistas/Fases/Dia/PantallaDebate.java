package edu.fiuba.algo3.vistas.Fases.Dia;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorDebate;
import edu.fiuba.algo3.vistas.Pantalla;
import javafx.scene.control.*;

public class PantallaDebate extends Pantalla {

    public PantallaDebate(ControladorDebate controlador){

        Label titulo = new Label("Debate");
        estiloTitulo(titulo);

        TextArea chat = new TextArea();

        chat.setEditable(false);
        chat.setPrefHeight(200);

        TextField mensaje = new TextField();
        mensaje.setPromptText("Escriba su mensaje...");

        Button enviar = new Button("Enviar");
        Button continuar = new Button(
                "Ir a nominaciones"
        );

        estiloBoton(enviar);
        estiloBoton(continuar);

        enviar.setOnAction(e -> {

            if(!mensaje.getText().isEmpty()){

                chat.appendText(
                        "Jugador: "
                                + mensaje.getText()
                                + "\n"
                );

                mensaje.clear();
            }
        });

        continuar.setOnAction(e ->
                controlador.continuar()
        );

        getChildren().addAll(
                titulo,
                chat,
                mensaje,
                enviar,
                continuar
        );
    }
}