package edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna;

import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteCarta;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.*;
import edu.fiuba.algo3.modelo.Visitors.VisitanteResultadoNoche;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VisitanteResultadoNocheVista implements VisitanteResultadoNoche {

    private VBox resultado;

    @Override
    public void visitarAtaqueExitoso(AtaqueExitoso ataque){

        resultado = new VBox();

        Label mensaje =
                new Label(
                        "Fue eliminado el jugador "
                                + ataque.eliminado().id()
                );

        VisitanteCarta visitanteCarta =
                new VisitanteCarta();

        ataque.eliminado()
                .aceptarVisitante(visitanteCarta);

        resultado.getChildren().addAll(
                mensaje,
                visitanteCarta.carta()
        );
    }

    @Override
    public void visitarAtaqueBloqueado(AtaqueBloqueado ataque){

        resultado = new VBox(
                new Label(
                        "El médico salvó al jugador "
                                + ataque.objetivo().id()
                )
        );
    }

    @Override
    public void visitarSinAtaque(SinAtaque ataque){

        resultado = new VBox(
                new Label("La noche pasó sin eliminaciones")
        );
    }

    public VBox resultado(){
        return resultado;
    }
}