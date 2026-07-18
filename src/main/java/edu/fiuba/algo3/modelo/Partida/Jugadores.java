package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Jugadores {

    private final List<Jugador> jugadores;

    public Jugadores(){
        jugadores = new ArrayList<>();
    }

    public Jugadores(Jugadores otros){
        jugadores = new ArrayList<>(otros.jugadores);
    }

    public List<Jugador> todos(){
        return List.copyOf(jugadores);
    }

    public boolean contiene(Jugador jugador){return jugadores.contains(jugador);}

    public boolean estaVacio(){return jugadores.isEmpty();}

    public void agregar(Jugador jugador){
        jugadores.add(jugador);
    }

    public void eliminar(Jugador jugador){
        jugadores.remove(jugador);
    }

    public void vaciar(){jugadores.clear();}

    public void registrarRoles(EstadoPartida estado){

        for(Jugador jugador : jugadores){
            jugador.registrarme(estado);
        }
    }
}
