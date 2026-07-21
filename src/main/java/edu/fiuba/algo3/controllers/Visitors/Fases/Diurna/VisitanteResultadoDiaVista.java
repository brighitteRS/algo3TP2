package edu.fiuba.algo3.controllers.Visitors.Fases.Diurna;

import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteCarta;
import edu.fiuba.algo3.modelo.Votacion.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VisitanteResultadoDiaVista implements VisitanteResultadoDia {

    private VBox resultado;

    @Override
    public void visitarGanador(ResultadoGanador ganador){

        resultado = new VBox();

        Label mensaje = new Label(
                "Jugador eliminado: "
                        + ganador.ganador().id()
        );

        VisitanteCarta carta =
                new VisitanteCarta();

        ganador.ganador()
                .aceptarVisitante(carta);

        resultado.getChildren().addAll(
                mensaje,
                carta.carta()
        );
    }

    @Override
    public void visitarEmpate(ResultadoEmpate empate){

        resultado = new VBox(
                new Label("No hubo eliminación")
        );
    }

    public VBox resultado(){
        return resultado;
    }
}