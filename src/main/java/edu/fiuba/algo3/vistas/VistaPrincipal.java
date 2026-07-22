package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.controllers.ObservadorJuego;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class VistaPrincipal extends BorderPane
        implements ObservadorJuego {

    private final Label mensaje;
    private final Label estado;

    public VistaPrincipal(JuegoControlador controlador){

        setStyle("-fx-background-color: #060e17;");

        mensaje = new Label();
        estado = new Label();

        estiloBarra(estado);
        estiloBarra(mensaje);

        setTop(estado);

        setBottom(mensaje);

        controlador.agregarObservador(this);

        setCenter(
                new PantallaInicio(controlador)
        );
    }

    @Override
    public void actualizar(String mensaje){

        this.mensaje.setText(mensaje);

        PauseTransition pausa =
                new PauseTransition(Duration.seconds(3));

        pausa.setOnFinished(e ->
                this.mensaje.setText("")
        );

        pausa.play();
    }

    @Override
    public void actualizarEstado(String estado){

        this.estado.setText(
                "Estado: " + estado
        );
    }

    @Override
    public void mostrarPantalla(Pantalla pantalla){

        setCenter(pantalla);
    }

    private void estiloBarra(Label label) {
        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;"
        );
    }
}