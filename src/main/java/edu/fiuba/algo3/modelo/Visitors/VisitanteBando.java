package edu.fiuba.algo3.modelo.Visitors;

import edu.fiuba.algo3.modelo.Jugador.Bando.*;

public interface VisitanteBando {

    void visitarMafia(BandoMafia mafia);

    void visitarCiudadano(BandoCiudadano ciudadano);
}
