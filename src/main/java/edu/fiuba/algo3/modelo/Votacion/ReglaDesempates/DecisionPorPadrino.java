package edu.fiuba.algo3.modelo.Votacion.ReglaDesempates;

import edu.fiuba.algo3.modelo.Votacion.*;

public class DecisionPorPadrino implements ReglaDesempate {

    @Override
    public ResultadoVotacion resolver(Votacion votacion){return new ResultadoEmpate();}
}