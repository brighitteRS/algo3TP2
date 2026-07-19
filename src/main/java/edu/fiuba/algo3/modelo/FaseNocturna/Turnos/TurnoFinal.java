package edu.fiuba.algo3.modelo.FaseNocturna.Turnos;

public class TurnoFinal implements TurnoNocturno {

    @Override
    public TurnoNocturno siguiente() {
        return this;
    }
}