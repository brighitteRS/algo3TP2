package edu.fiuba.algo3.controllers.FaseDiurna;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;

public class ControladorNominaciones {

    private final ControladorFaseDiurna fase;

    public ControladorNominaciones(ControladorFaseDiurna fase){

        this.fase = fase;
    }

    private Jugadores candidatos(){

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

            fase.reiniciarTurno();
            fase.mostrarVotacion();

        } else {

            fase.mostrarNominaciones();
        }
    }

    public void continuar(){

        fase.mostrarVotacion();
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

    public int idJugador(){
        return fase.idJugador();
    }
}