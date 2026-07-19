package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Abstencion {

    private final Jugador jugador;

    public Abstencion(Jugador jugador){
        this.jugador = jugador;
    }

    public Jugador jugador(){
        return jugador;
    }
}
