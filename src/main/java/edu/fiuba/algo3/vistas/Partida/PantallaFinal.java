package edu.fiuba.algo3.vistas.Partida;

import edu.fiuba.algo3.controllers.ControladorResultadoPartida;
import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.controllers.Visitors.Partida.VisitantePartidaVista;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PantallaFinal extends Pantalla {

    public PantallaFinal(
            ControladorResultadoPartida controlador,
            JuegoControlador juegoControlador
    ){

        Label titulo = new Label("Resultado final");
        estiloTitulo(titulo);

        VisitantePartidaVista visitante =
                new VisitantePartidaVista();

        controlador.resultado()
                .aceptarVisitante(visitante);

        Button roles = new Button("Ver roles");
        Button resumenNoches = new Button("Resumen noches");
        Button resumenDias = new Button("Resumen días");
        Button eliminaciones = new Button("Eliminaciones");

        estiloBoton(roles);
        estiloBoton(resumenNoches);
        estiloBoton(resumenDias);
        estiloBoton(eliminaciones);

        roles.setOnAction(e -> juegoControlador.mostrarPantalla(
                new PantallaRolesFinal(
                        controlador,
                        juegoControlador
                )
        ));

        resumenNoches.setOnAction(e -> juegoControlador.mostrarPantalla(
                new PantallaResumenNocturno(
                        controlador,
                        juegoControlador
                )
        ));

        resumenDias.setOnAction(e -> juegoControlador.mostrarPantalla(
                new PantallaResumenDiurno(
                        controlador,
                        juegoControlador
                )
        ));

        eliminaciones.setOnAction(e -> juegoControlador.mostrarPantalla(
                new PantallaEliminaciones(
                        controlador,juegoControlador
                )
        ));

        getChildren().addAll(
                titulo,
                visitante.pantalla(),
                roles,
                resumenNoches,
                resumenDias,
                eliminaciones
        );
    }
}