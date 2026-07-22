package edu.fiuba.algo3.controllers.Visitors.Roles;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.util.Objects;

public abstract class CartaRolVista extends VBox {

    protected CartaRolVista() {

        setAlignment(Pos.CENTER);
        setSpacing(10);
    }


    protected ImageView crearImagen(String ruta){

        Image imagen = new Image(
                Objects.requireNonNull(getClass()
                        .getResourceAsStream(ruta))
        );

        ImageView vista = new ImageView(imagen);

        vista.setFitWidth(150);
        vista.setFitHeight(150);

        vista.setPreserveRatio(true);

        return vista;
    }

    protected Label crearNombre(String nombre){

        Label label = new Label(nombre);

        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;"
        );

        return label;
    }
}