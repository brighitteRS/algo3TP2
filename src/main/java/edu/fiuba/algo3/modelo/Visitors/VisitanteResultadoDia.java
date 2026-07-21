package edu.fiuba.algo3.modelo.Visitors;

import edu.fiuba.algo3.modelo.Votacion.*;

public interface VisitanteResultadoDia {

    void visitarGanador(ResultadoGanador resultado);

    void visitarEmpate(ResultadoEmpate resultado);
}
