package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controllers.JuegoControlador;
import javafx.scene.control.*;

public class PantallaInicio extends Pantalla {

    public PantallaInicio(JuegoControlador controlador){

        Label titulo = new Label("MAFIA");

        Label jugadores = new Label(
                "Cantidad de jugadores:"
        );

        TextField cantidad = new TextField();

        estiloCampoTexto(cantidad);

        Button iniciar = new Button(
                "Iniciar partida"
        );

        estiloBoton(iniciar);

        estiloTitulo(titulo);
        estiloTextoClaro(jugadores);

        iniciar.setOnAction(event -> {

            try {

                int cantidadJugadores =
                        Integer.parseInt(
                                cantidad.getText().trim()
                        );

                controlador.iniciarPartida(cantidadJugadores);

            }
            catch(NumberFormatException e){

                controlador.notificar(
                        "Ingrese una cantidad válida"
                );
            }
        });

        getChildren().addAll(
                titulo,
                jugadores,
                cantidad,
                iniciar
        );


    }

}