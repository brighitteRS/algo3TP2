package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.FaseDiurna.HistorialDiurno;
import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ResultadoVictoria;
import edu.fiuba.algo3.modelo.Partida.*;

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

    public List<HistorialNocturno> noches(){

        return partida.estado()
                .historialPartida()
                .historialNoches();
    }

    public List<HistorialDiurno> dias(){

        return partida.estado()
                .historialPartida()
                .historialDias();
    }
}