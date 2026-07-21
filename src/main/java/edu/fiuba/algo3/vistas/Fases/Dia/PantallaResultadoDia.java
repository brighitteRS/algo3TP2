package edu.fiuba.algo3.vistas.Fases.Dia;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorResultadoDia;
import edu.fiuba.algo3.controllers.Visitors.Fases.Diurna.VisitanteResultadoDiaVista;
import edu.fiuba.algo3.vistas.Pantalla;
import javafx.scene.control.Button;

public class PantallaResultadoDia extends Pantalla {

    public PantallaResultadoDia(ControladorResultadoDia controlador){

        VisitanteResultadoDiaVista visitante =
                new VisitanteResultadoDiaVista();

        controlador.resultado()
                .aceptarVisitante(visitante);

        Button continuar = new Button("Continuar");

        continuar.setOnAction(e ->
                controlador.continuar()
        );

        getChildren().addAll(
                visitante.resultado(),
                continuar
        );
    }
}