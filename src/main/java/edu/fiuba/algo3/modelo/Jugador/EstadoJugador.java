package edu.fiuba.algo3.modelo.Jugador;

public interface EstadoJugador {

    void validarPuedeSerObjetivo();

    void validarPuedeActuar();

    void estaVivo();

    EstadoJugador morir();

    Rol revelarCarta(Rol rol);
}