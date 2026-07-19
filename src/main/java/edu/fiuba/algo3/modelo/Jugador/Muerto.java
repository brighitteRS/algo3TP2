package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Excepciones.*;

public class Muerto implements EstadoJugador {

    @Override
    public void validarPuedeSerObjetivo() {
        throw new JugadorMuertoNoPuedeSerObjetivoException();
    }

    @Override
    public void validarPuedeActuar() {
        throw new JugadorMuertoNoPuedeActuarException();
    }

    @Override
    public EstadoJugador morir() {
        return this;
    }

    @Override
    public void estaVivo() {
        throw new JugadorMuertoException();
    }

    @Override
    public Rol revelarCarta(Rol rol) {
        return rol;
    }
}
