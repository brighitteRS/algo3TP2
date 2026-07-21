package edu.fiuba.algo3.controllers.Visitors.Roles;

import javafx.scene.control.Label;

public class CartaCiudadano extends CartaRolVista {

    public CartaCiudadano() {

        getChildren().add(
                new Label("CIUDADANO")
        );
    }

}