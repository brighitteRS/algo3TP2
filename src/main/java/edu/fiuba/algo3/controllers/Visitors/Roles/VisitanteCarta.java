package edu.fiuba.algo3.controllers.Visitors.Roles;

import edu.fiuba.algo3.modelo.Roles.*;
import edu.fiuba.algo3.modelo.Visitors.VisitanteRol;

public class VisitanteCarta implements VisitanteRol {

    private CartaRolVista carta;

    @Override
    public void visitarDetective(Detective detective) {

        carta = new CartaDetective();
    }

    @Override
    public void visitarMafioso(Mafioso mafioso){

        carta = new CartaMafioso();
    }

    @Override
    public void visitarCiudadano(Ciudadano ciudadano){

        carta = new CartaCiudadano();
    }

    @Override
    public void visitarMedico(Medico medico){

        carta = new CartaMedico();
    }

    @Override
    public void visitarPadrino(Padrino padrino){

        carta = new CartaPadrino();
    }

    @Override
    public void visitarSheriff(Sheriff sheriff){

        carta = new CartaSheriff();
    }

    public CartaRolVista carta(){

        return carta;
    }
}