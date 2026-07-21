package edu.fiuba.algo3.controllers.Visitors.Bandos;

import edu.fiuba.algo3.modelo.Jugador.Bando.*;

public interface VisitanteBando {

    void visitarMafia(BandoMafia mafia);

    void visitarCiudadano(BandoCiudadano ciudadano);
}
