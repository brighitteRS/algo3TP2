package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.NullPattern.RolNulo;

public class Vivo implements EstadoJugador {

    @Override
    public void validarPuedeSerObjetivo() {
    }

    @Override
    public void validarPuedeActuar() {
    }

    @Override
    public EstadoJugador morir() {
        return new Muerto();
    }

    @Override
    public void estaVivo() {
    }

    @Override
    public Rol revelarCarta(Rol rol) {
        return RolNulo.INSTANCIA;
    }
}
