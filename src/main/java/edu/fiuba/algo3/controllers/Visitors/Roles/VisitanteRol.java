package edu.fiuba.algo3.controllers.Visitors.Roles;

import edu.fiuba.algo3.modelo.Roles.*;

public interface VisitanteRol {

    void visitarCiudadano(Ciudadano ciudadano);

    void visitarDetective(Detective detective);

    void visitarMedico(Medico medico);

    void visitarMafioso(Mafioso mafioso);

    void visitarPadrino(Padrino padrino);

    void visitarSheriff(Sheriff sheriff);
}
