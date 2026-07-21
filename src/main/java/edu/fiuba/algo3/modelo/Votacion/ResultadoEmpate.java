package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.controllers.Visitors.Fases.Diurna.VisitanteResultadoDia;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public class ResultadoEmpate extends ResultadoVotacion {

    @Override
    public AccionNocturna accion(){
        return AtaqueNulo.INSTANCIA;
    }

    @Override
    public void resolver(EstadoPartida estado){
    }

    @Override
    public Jugador ganador() {
        return JugadorNulo.INSTANCIA;
    }

    @Override
    public void aceptarVisitante(VisitanteResultadoDia visitante){

        visitante.visitarEmpate(this);
    }
}