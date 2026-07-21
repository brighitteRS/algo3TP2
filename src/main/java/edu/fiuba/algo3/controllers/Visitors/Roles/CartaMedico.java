package edu.fiuba.algo3.controllers.Visitors.Roles;

import javafx.scene.control.Label;

public class CartaMedico extends CartaRolVista {

    public CartaMedico() {

        getChildren().add(
                new Label("MEDICO")
        );

    }

}
