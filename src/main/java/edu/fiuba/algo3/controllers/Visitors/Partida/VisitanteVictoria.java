package edu.fiuba.algo3.controllers.Visitors.Partida;

import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;

public interface VisitanteVictoria {

    void visitarVictoriaMafia(VictoriaMafia victoria);

    void visitarVictoriaCiudadanos(VictoriaCiudadanos victoria);

    void visitarSinVictoria(SinVictoria victoria);
}

