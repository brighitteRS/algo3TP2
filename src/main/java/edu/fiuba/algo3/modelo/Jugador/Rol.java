package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.NullPattern.AccionNula;

public abstract class Rol {

    public void registrarme(EstadoPartida estadoPartida, Jugador self){
    }

    public AccionNocturna actuarNoche(Jugador actor, Jugador objetivo) {
        return AccionNula.INSTANCIA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}