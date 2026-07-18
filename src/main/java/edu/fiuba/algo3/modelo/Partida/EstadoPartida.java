package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Excepciones.JugadorMuertoException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mafia;

public class EstadoPartida {

    private Jugadores todos;
    private Jugadores vivos;
    private final Jugadores eliminados;
    private final Mafia mafia;


    public EstadoPartida(){

        todos = new Jugadores();
        vivos = new Jugadores();
        eliminados = new Jugadores();

        mafia = new Mafia();
    }

    public void inicializar(Jugadores jugadores){

        reiniciar();

        todos = new Jugadores(jugadores);

        vivos = new Jugadores(jugadores);
    }

    private void reiniciar(){
        eliminados.vaciar();
    }

    public void registrarJugadores(){
        todos.registrarRoles(this);
    }

    public Jugadores eliminados(){
        return eliminados;
    }

    public Mafia mafia(){
        return mafia;
    }

    public void eliminar(Jugador jugador){

        if(!vivos.contiene(jugador)){
            throw new JugadorMuertoException();
        }

        jugador.eliminar();

        vivos.eliminar(jugador);

        eliminados.agregar(jugador);
    }
}
