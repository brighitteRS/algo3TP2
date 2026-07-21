package edu.fiuba.algo3.modelo.Visitors;

import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;

public interface VisitanteVictoria {

    void visitarVictoriaMafia(VictoriaMafia victoria);

    void visitarVictoriaCiudadanos(VictoriaCiudadanos victoria);

    void visitarSinVictoria(SinVictoria victoria);
}

