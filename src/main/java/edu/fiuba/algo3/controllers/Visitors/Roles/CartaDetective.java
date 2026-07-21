package edu.fiuba.algo3.controllers.Visitors.Roles;

import javafx.scene.control.Label;

public class CartaDetective extends CartaRolVista {

    public CartaDetective() {

        getChildren().add(
                new Label("DETECTIVE")
        );

    }
}