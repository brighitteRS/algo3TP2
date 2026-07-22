package edu.fiuba.algo3.controllers.Visitors.Roles;

public class CartaDetective extends CartaRolVista {

    public CartaDetective() {

        getChildren().addAll(
                crearImagen("/detective.png"),
                crearNombre("DETECTIVE")
        );
    }
}