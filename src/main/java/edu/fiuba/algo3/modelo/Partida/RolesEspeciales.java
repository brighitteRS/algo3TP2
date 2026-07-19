package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;

public class RolesEspeciales {

    private Jugador padrino;
    private Jugador medico;
    private Jugador detective;

    public RolesEspeciales(){
        reiniciar();
    }

    public void reiniciar(){

        padrino = JugadorNulo.INSTANCIA;
        medico = JugadorNulo.INSTANCIA;
        detective = JugadorNulo.INSTANCIA;
    }

    public void registrarPadrino(Jugador jugador){
        padrino = jugador;
    }

    public void registrarMedico(Jugador jugador){medico = jugador;}

    public void registrarDetective(Jugador jugador){detective = jugador;}

    public Jugador padrino(){
        return padrino;
    }

    public Jugador medico(){
        return medico;
    }

    public Jugador detective(){return detective;}
}