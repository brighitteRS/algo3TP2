package edu.fiuba.algo3.controllers.FaseDiurna;

public class ControladorDebate {

    private final ControladorFaseDiurna fase;

    public ControladorDebate(ControladorFaseDiurna fase){
        this.fase = fase;
    }

    public void continuar(){

        fase.mostrarNominaciones();
    }
}