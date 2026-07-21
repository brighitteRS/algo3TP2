package edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.*;

public interface VisitanteResultadoNoche {

    void visitarAtaqueExitoso(AtaqueExitoso ataque);

    void visitarAtaqueBloqueado(AtaqueBloqueado ataque);

    void visitarSinAtaque(SinAtaque ataque);
}
