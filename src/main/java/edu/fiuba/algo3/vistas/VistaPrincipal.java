package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.controllers.ObservadorJuego;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class VistaPrincipal extends BorderPane
        implements ObservadorJuego {

    private final Label mensaje;


    public VistaPrincipal(JuegoControlador controlador){

        mensaje = new Label();

        controlador.agregarObservador(this);

        setBottom(mensaje);

        setCenter(
                new PantallaInicio(controlador)
        );
    }

    @Override
    public void actualizar(String mensaje){

        this.mensaje.setText(mensaje);
    }

    @Override
    public void mostrarPantalla(Pantalla pantalla){

        setCenter(pantalla);
    }
}