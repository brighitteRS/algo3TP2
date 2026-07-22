package edu.fiuba.algo3.controllers.Visitors.Roles;

public class CartaPadrino extends CartaRolVista {

    public CartaPadrino() {

        getChildren().addAll(
                crearImagen("/padrino.png"),
                crearNombre("PADRINO")
        );
    }
}