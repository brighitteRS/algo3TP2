package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ContadorBandos;

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

    public int cantidad(){return jugadores.size();}

    public boolean estaVacio(){return jugadores.isEmpty();}

    public void agregar(Jugador jugador){
        jugadores.add(jugador);
    }

    public void eliminar(Jugador jugador){
        jugadores.remove(jugador);
    }

    public Jugador jugador(int indice) {return jugadores.get(indice);}

    public void vaciar(){jugadores.clear();}

    public void registrarRoles(EstadoPartida estado){

        for(Jugador jugador : jugadores){
            jugador.registrarme(estado);
        }
    }

    public void contabilizarEn(ContadorBandos contador){

        for(Jugador jugador : jugadores){
            jugador.contabilizarEn(contador);
        }
    }

    public void asignarRoles(Mazo mazo){

        for(Jugador jugador : jugadores){
            jugador.recibirRol(mazo.repartirCarta());
        }
    }

    public Jugadores jugadoresSin(Jugador jugador){

        Jugadores resultado = new Jugadores();

        for(Jugador otro : jugadores){

            if(!otro.equals(jugador)){
                resultado.agregar(otro);
            }
        }

        return resultado;
    }
}
