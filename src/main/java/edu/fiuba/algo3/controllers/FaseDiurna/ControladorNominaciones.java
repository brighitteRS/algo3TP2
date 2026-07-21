package edu.fiuba.algo3.controllers.FaseDiurna;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;

public class ControladorNominaciones {

    private final ControladorFaseDiurna fase;

    public ControladorNominaciones(ControladorFaseDiurna fase){

        this.fase = fase;
    }

    public Jugadores candidatos(){

        return fase.jugadoresActivos()
                .jugadoresSin(
                        fase.jugadorActual()
                );
    }

    public void nominar(Jugador jugador){

        fase.nominar(
                fase.jugadorActual(),
                jugador
        );

        fase.siguienteJugador();

        if(fase.terminoTurnos()){

            fase.mostrarVotacion();

        } else {

            fase.mostrarNominaciones();
        }
    }

    public void continuar(){

        fase.mostrarVotacion();
    }
}