package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.FaseDiurna.HistorialDiurno;
import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ResultadoVictoria;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.controllers.Visitors.Roles.*;

import java.util.ArrayList;
import java.util.List;

public class ControladorResultadoPartida {

    private final Partida partida;

    public ControladorResultadoPartida(Partida partida){

        this.partida = partida;
    }

    public ResultadoVictoria resultado(){

        return partida.resultado().victoria();
    }

    public Jugadores jugadores(){

        return partida.estado().jugadores();
    }

    public int cantidadJugadores() {

        return partida.estado()
                .jugadores()
                .cantidad();
    }

    public int idJugador(int indice) {

        return partida.estado()
                .jugadores()
                .jugador(indice)
                .id();
    }

    public CartaRolVista cartaJugador(int indice) {

        VisitanteCarta visitante = new VisitanteCarta();

        partida.estado()
                .jugadores()
                .jugador(indice)
                .aceptarVisitante(visitante);

        return visitante.carta();
    }

    public int cantidadEliminados() {

        return partida.estado()
                .eliminados()
                .cantidad();
    }

    public int idEliminado(int indice) {

        return partida.estado()
                .eliminados()
                .jugador(indice)
                .id();
    }

    public CartaRolVista cartaEliminado(int indice) {

        VisitanteCarta visitante = new VisitanteCarta();

        partida.estado()
                .eliminados()
                .jugador(indice).
                cartaRevelada().
                aceptar(visitante);

        return visitante.carta();
    }

    public List<String> resumenNoches(){

        List<String> resumen = new ArrayList<>();

        int numero = 1;

        for(HistorialNocturno noche :
                partida.estado()
                        .historialPartida()
                        .historialNoches()){

            resumen.add("Noche " + numero);

            resumen.add(
                    "Mafia atacó a Jugador "
                            + noche.ataque()
                            .victima()
                            .id()
            );

            resumen.add(
                    "Médico protegió a Jugador "
                            + noche.proteccion()
                            .protegido()
                            .id()
            );

            resumen.add(
                    "Detective investigó a Jugador "
                            + noche.investigacion()
                            .investigado()
                            .id()
            );

            numero++;
        }

        return resumen;
    }

    public List<String> resumenDias(){

        List<String> resumen = new ArrayList<>();

        int numero = 1;

        for(HistorialDiurno dia :
                partida.estado()
                        .historialPartida()
                        .historialDias()){

            resumen.add("Día " + numero);

            resumen.add("Nominaciones");

            for(var nominacion : dia.nominaciones()){

                resumen.add(
                        "Jugador "
                                + nominacion.nominador().id()
                                + " nominó a Jugador "
                                + nominacion.nominado().id()
                );
            }

            resumen.add("Votos");

            for(var voto : dia.votos()){

                resumen.add(
                        "Jugador "
                                + voto.votante().id()
                                + " votó a Jugador "
                                + voto.votado().id()
                );
            }

            resumen.add("Abstenciones");

            for(var abstencion : dia.abstenciones()){

                resumen.add(
                        "Jugador "
                                + abstencion.jugador().id()
                                + " se abstuvo"
                );
            }

            numero++;
        }

        return resumen;
    }
}