package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Jugador.*;

public class Padrino extends Rol {

    public Padrino() {
        super(BandoMafia.INSTANCIA);
    }

    @Override
    public Bando bandoInvestigacion() {
        return BandoCiudadano.INSTANCIA;
    }

    @Override
    public void registrarme(EstadoPartida estado, Jugador jugador) {
        estado.mafia().agregar(jugador);
    }
}