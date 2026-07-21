package edu.fiuba.algo3.modelo.Roles;

import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteRol;
import edu.fiuba.algo3.modelo.Jugador.Bando.BandoMafia;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Jugador.*;

public class Mafioso extends Rol {

    public Mafioso() {
        super(BandoMafia.INSTANCIA);
    }

    @Override
    public void registrarme(EstadoPartida estado, Jugador jugador) {
        estado.mafia().agregar(jugador);
    }

    @Override
    public void aceptar(VisitanteRol visitante){
        visitante.visitarMafioso(this);
    }
}