package edu.fiuba.algo3.vistas.Fases.Noche;

import edu.fiuba.algo3.controllers.FaseNocturna.ControladorTurnoFinal;
import edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna.VisitanteResultadoNocheVista;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaNocheTerminada extends Pantalla {

    public PantallaNocheTerminada(
            ControladorTurnoFinal controlador
    ){

        controlador.resolver();

        Label titulo = new Label("Resultado de la noche");

        VisitanteResultadoNocheVista visitante =
                new VisitanteResultadoNocheVista();

        controlador.resultado()
                .aceptarVisitante(visitante);

        Button continuar = new Button("Continuar");

        continuar.setOnAction(e ->
                controlador.continuar()
        );

        getChildren().addAll(
                titulo,
                visitante.resultado(),
                continuar
        );
    }
}