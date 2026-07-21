package edu.fiuba.algo3.controllers.Visitors.Fases.Diurna;

import edu.fiuba.algo3.modelo.Votacion.*;

public interface VisitanteResultadoDia {

    void visitarGanador(ResultadoGanador resultado);

    void visitarEmpate(ResultadoEmpate resultado);
}
