package edu.fiuba.algo3.controllers.Visitors.Roles;

public class CartaMedico extends CartaRolVista {

    public CartaMedico() {

        getChildren().addAll(
                crearImagen("/medico.png"),
                crearNombre("MEDICO")
        );
    }
}
