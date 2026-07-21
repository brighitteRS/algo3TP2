package edu.fiuba.algo3.controllers.FaseNocturna;

import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeAtacarAMafiosoException;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoMafia;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;

public class ControladorTurnoMafia {

    private final ControladorFaseNocturna fase;
    private final TurnoMafia turno;

    private int mafiosoActual = 0;

    public ControladorTurnoMafia(
            ControladorFaseNocturna fase,
            TurnoMafia turno
    ){
        this.fase = fase;
        this.turno = turno;
    }

    public void votar(Jugador objetivo){

        try {

            turno.mafia().votar(
                    mafiosoActual(),
                    objetivo
            );

            mafiosoActual++;

            fase.notificar(
                    "Voto registrado"
            );


            if(terminoVotacion()){

                finalizar();
            }


        } catch(NoSePuedeAtacarAMafiosoException e){

            fase.notificar(
                    e.getMessage()
            );
        }
    }


    private Jugador mafiosoActual(){

        return turno.mafia()
                .miembro(mafiosoActual);
    }

    public boolean terminoVotacion(){

        return mafiosoActual >=
                turno.mafia().cantidadMiembros();
    }

    private void finalizar(){

        fase.registrar(
                turno.mafia().decidirAtaque()
        );

        fase.avanzar();
    }

    public Jugadores objetivos(){

        return fase.jugadoresActivos();
    }

    public int idMafiosoActual(){

        return mafiosoActual().id();
    }
}