package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class JugadorNulo extends Jugador {

    public static final JugadorNulo INSTANCIA = new JugadorNulo();

    @Override
    public int id(){
        return 0;
    }

    @Override
    public void eliminar() {
    }

    @Override
    public TurnoNocturno agregarTurno(TurnoNocturno siguiente) {
        return siguiente;
    }
}