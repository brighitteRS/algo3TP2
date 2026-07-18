package edu.fiuba.algo3.modelo.Jugador;


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
}
