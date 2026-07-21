package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.JuegoControlador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {


    @Override
    public void start(Stage stage) {


        JuegoControlador controlador = new JuegoControlador();

        VistaPrincipal vista = new VistaPrincipal(controlador);

        controlador.agregarObservador(vista);

        Scene escena = new Scene(vista,600,400);

        stage.setScene(escena);
        stage.setTitle("Mafia");
        stage.show();

    }

    public static void main(String[] args){

        launch(args);

    }

}