package edu.fiuba.algo3.controllers.Visitors.Roles;

public class CartaSheriff extends CartaRolVista {

    public CartaSheriff() {

        getChildren().addAll(
                crearImagen("/sheriff.png"),
                crearNombre("SHERIFF")
        );
    }
}