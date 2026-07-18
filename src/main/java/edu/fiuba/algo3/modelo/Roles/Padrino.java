package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Jugador.*;

public class Padrino extends Rol {

    @Override
    public void registrarme(EstadoPartida estado, Jugador jugador) {
        estado.mafia().agregar(jugador);
    }
}