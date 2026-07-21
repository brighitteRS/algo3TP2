package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteRol;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ContadorBandos;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;

public abstract class Rol {

    private final Bando bando;

    protected Rol(Bando bando) {
        this.bando = bando;
    }

    public void registrarme(EstadoPartida estadoPartida, Jugador self){
    }

    public TurnoNocturno agregarTurno(Jugador jugador, TurnoNocturno siguiente) {
        return siguiente;
    }

    public AccionNocturna actuarNoche(Jugador actor, Jugador objetivo) {
        return AccionNula.INSTANCIA;
    }

    public void recibirResultadoInvestigacion(Bando bando){
    }

    public Bando resultadoInvestigacion() {
        return BandoNulo.INSTANCIA;
    }

    public Bando bandoInvestigacion() {
        return bando;
    }

    public void contabilizar(ContadorBandos contador) {bando.contabilizar(contador);}

    public abstract void aceptar(VisitanteRol visitante);

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