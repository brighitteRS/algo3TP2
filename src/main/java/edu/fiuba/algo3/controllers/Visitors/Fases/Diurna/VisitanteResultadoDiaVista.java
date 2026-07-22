package edu.fiuba.algo3.controllers.Visitors.Fases.Diurna;

import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteCarta;
import edu.fiuba.algo3.modelo.Visitors.VisitanteResultadoDia;
import edu.fiuba.algo3.modelo.Votacion.*;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VisitanteResultadoDiaVista implements VisitanteResultadoDia {

    private VBox resultado;

    @Override
    public void visitarGanador(ResultadoGanador resultadoDia){

        resultado = new VBox();

        Label mensaje = mensaje(
                "Jugador eliminado: "
                        + resultadoDia.ganador().id()
        );

        VisitanteCarta carta =
                new VisitanteCarta();

        resultadoDia.ganador()
                .cartaRevelada()
                .aceptar(carta);

        resultado.getChildren().addAll(
                mensaje,
                carta.carta()
        );
    }

    @Override
    public void visitarEmpate(ResultadoEmpate empate){

        resultado = new VBox(
                mensaje("No hubo eliminación")
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