package edu.fiuba.algo3.controllers.Visitors.Roles;

public class CartaMafioso extends CartaRolVista {

    public CartaMafioso() {

        getChildren().addAll(
                crearImagen("/mafioso.png"),
                crearNombre("MAFIOSO")
        );
    }
}