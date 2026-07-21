package edu.fiuba.algo3.controllers.Visitors.Roles;

import javafx.scene.control.Label;

public class CartaMafioso extends CartaRolVista {

    public CartaMafioso() {

        getChildren().add(
                new Label("MAFIOSO")
        );

    }

}