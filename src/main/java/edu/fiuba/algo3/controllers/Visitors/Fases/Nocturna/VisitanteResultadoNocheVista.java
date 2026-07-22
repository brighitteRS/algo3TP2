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

        Label mensaje = mensaje(
                "Fue eliminado el jugador "
                        + ataque.eliminado().id()
        );

        VisitanteCarta visitanteCarta =
                new VisitanteCarta();

        ataque.eliminado()
                .cartaRevelada()
                .aceptar(visitanteCarta);

        resultado.getChildren().addAll(
                mensaje,
                visitanteCarta.carta()
        );
    }

    @Override
    public void visitarAtaqueBloqueado(AtaqueBloqueado ataque){

        resultado = new VBox(
                mensaje(
                        "El médico salvó al jugador "
                                + ataque.objetivo().id()
                )
        );
    }

    @Override
    public void visitarSinAtaque(SinAtaque ataque){

        resultado = new VBox(
                mensaje("La noche pasó sin eliminaciones")
        );
    }

    public VBox resultado(){
        return resultado;
    }

    private Label mensaje(String texto){

        Label label = new Label(texto);

        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;"
        );

        return label;
    }
}