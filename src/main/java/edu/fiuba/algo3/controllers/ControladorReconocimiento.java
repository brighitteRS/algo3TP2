package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.controllers.Visitors.Roles.*;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.vistas.Partida.PantallaReconocimiento;

public class ControladorReconocimiento {

    private final JuegoControlador juego;
    private int jugadorActual = 0;

    public ControladorReconocimiento(JuegoControlador juego){

        this.juego = juego;
    }

    public int numeroJugadorActual(){

        return jugadorActual + 1;
    }

    public CartaRolVista cartaJugadorActual(){

        return juego.cartaJugador(jugadorActual);
    }

    public Jugadores complicesJugadorActual(){

        return juego.complicesJugador(jugadorActual);
    }

    public void continuar(){

        jugadorActual++;

        if(jugadorActual >= juego.cantidadJugadores()){

            juego.iniciarNoche();
            return;
        }

        mostrarPantalla();
    }

    public void mostrarPantalla(){

        juego.mostrarPantalla(
                new PantallaReconocimiento(this)
        );
    }
}