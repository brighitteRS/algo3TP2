package edu.fiuba.algo3.controllers.FaseDiurna;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;

public class ControladorVotacion {

    private final ControladorFaseDiurna fase;

    public ControladorVotacion(ControladorFaseDiurna fase){

        this.fase = fase;
    }

    private Jugadores candidatos(){

        return fase.candidatosNominados();
    }

    public void votar(Jugador jugador){

        fase.votar(
                fase.jugadorActual(),
                jugador
        );

        fase.siguienteJugador();

        if(fase.terminoTurnos()){

            fase.resolverVotacion();
            fase.mostrarResultado();
        }
    }

    public void abstenerse(){

        fase.abstenerse(
                fase.jugadorActual()
        );

        fase.siguienteJugador();

        if(fase.terminoTurnos()){

            fase.resolverVotacion();
            fase.mostrarResultado();
        }
    }

    public int cantidadCandidatos(){

        return candidatos().cantidad();
    }

    public int idCandidato(int indice){

        return candidatos()
                .jugador(indice)
                .id();
    }

    public Jugador candidato(int indice){

        return candidatos()
                .jugador(indice);
    }
}