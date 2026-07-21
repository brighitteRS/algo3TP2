package edu.fiuba.algo3.vistas.Partida;

import edu.fiuba.algo3.controllers.ControladorResultadoPartida;
import edu.fiuba.algo3.controllers.Visitors.Partida.VisitantePartidaVista;
import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteCarta;
import edu.fiuba.algo3.modelo.FaseDiurna.HistorialDiurno;
import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Votacion.*;
import edu.fiuba.algo3.modelo.Votacion.Nominaciones.Nominacion;
import edu.fiuba.algo3.vistas.Pantalla;

import javafx.scene.control.Label;


public class PantallaFinal extends Pantalla {

    public PantallaFinal(ControladorResultadoPartida controlador){

        Label titulo = new Label("Resultado final");


        VisitantePartidaVista visitante =
                new VisitantePartidaVista();


        controlador.resultado()
                .aceptarVisitante(visitante);


        getChildren().addAll(
                titulo,
                visitante.pantalla()
        );


        mostrarCartas(controlador);

        mostrarNoches(controlador);

        mostrarDias(controlador);
    }

    private void mostrarCartas(ControladorResultadoPartida controlador){

        getChildren().add(
                new Label("Roles revelados")
        );

        for(Jugador jugador : controlador.jugadores().todos()){

            VisitanteCarta visitante =
                    new VisitanteCarta();

            jugador.aceptarVisitante(visitante);

            getChildren().add(
                    visitante.carta()
            );
        }
    }

    private void mostrarNoches(ControladorResultadoPartida controlador){

        getChildren().add(
                new Label("Noches")
        );

        int numero = 1;

        for(HistorialNocturno noche : controlador.noches()){


            getChildren().add(
                    new Label("Noche " + numero)
            );

            getChildren().add(
                    new Label(
                            "Mafia atacó a Jugador: "
                                    + noche.ataque().victima().id()
                    )
            );

            getChildren().add(
                    new Label(
                            "Médico protegió a Jugador: "
                                    + noche.proteccion().protegido().id()
                    )
            );

            getChildren().add(
                    new Label(
                            "Detective investigó a Jugador: "
                                    + noche.investigacion().investigado().id()
                    )
            );


            numero++;
        }
    }

    private void mostrarDias(ControladorResultadoPartida controlador){

        getChildren().add(
                new Label("Días")
        );

        int numero = 1;

        for(HistorialDiurno dia : controlador.dias()){

            getChildren().add(
                    new Label("Dia " + numero)
            );

            for(Nominacion nominacion : dia.nominaciones()){

                getChildren().add(
                        new Label(
                                "Jugador "
                                        + nominacion.nominador().id()
                                        + " nominó a "
                                        + nominacion.nominado().id()
                        )
                );
            }

            for(Voto voto : dia.votos()){

                getChildren().add(
                        new Label(
                                "Jugador "
                                        + voto.votante().id()
                                        + " Votó a "
                                        + voto.votado().id()
                        )
                );
            }

            for(Abstencion abstencion : dia.abstenciones()){

                getChildren().add(
                        new Label(
                                "Jugador "
                                        + abstencion.jugador().id()
                                        + " se abstuvo"
                        )
                );
            }

            numero++;
        }
    }
}