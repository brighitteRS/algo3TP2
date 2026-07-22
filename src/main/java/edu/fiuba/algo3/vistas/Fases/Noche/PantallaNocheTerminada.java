package edu.fiuba.algo3.vistas.Fases.Noche;

import edu.fiuba.algo3.controllers.FaseNocturna.ControladorTurnoFinal;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaNocheTerminada extends Pantalla {

    public PantallaNocheTerminada(
            ControladorTurnoFinal controlador
    ){

        controlador.resolver();

        Label titulo = new Label("Resultado de la noche");
        estiloTitulo(titulo);

        Button continuar = new Button("Continuar");
        estiloBoton(continuar);

        continuar.setOnAction(e ->
                controlador.continuar()
        );

        getChildren().addAll(
                titulo,
                controlador.resultadoVista(),
                continuar
        );
    }
}