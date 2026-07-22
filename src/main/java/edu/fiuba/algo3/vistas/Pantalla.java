package edu.fiuba.algo3.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Pantalla extends VBox {

    public Pantalla(){

        setAlignment(Pos.CENTER);

        setSpacing(20);

        setPadding(
                new Insets(30)
        );

        setStyle(
                "-fx-background-color: #060e17;"
        );
    }

    protected void estiloTextoClaro(Label label){

        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;"
        );
    }

    protected void estiloTitulo(Label label){

        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 32px;" +
                        "-fx-font-weight: bold;"
        );
    }

    protected void estiloBoton(Button boton){

        boton.setPrefWidth(160);
        boton.setPrefHeight(40);

        boton.setStyle(
                "-fx-background-color: #8B0000;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;"
        );
    }

    protected void estiloCampoTexto(TextField campo){

        campo.setMaxWidth(100);
        campo.setPrefHeight(30);

        campo.setStyle(
                "-fx-font-size: 12px;"
        );
    }
}