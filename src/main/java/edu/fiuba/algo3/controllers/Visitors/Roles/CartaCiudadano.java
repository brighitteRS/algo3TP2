package edu.fiuba.algo3.controllers.Visitors.Roles;

public class CartaCiudadano extends CartaRolVista {

    public CartaCiudadano() {

        getChildren().addAll(
                crearImagen("/ciudadano.png"),
                crearNombre("CIUDADANO")
        );
    }

}