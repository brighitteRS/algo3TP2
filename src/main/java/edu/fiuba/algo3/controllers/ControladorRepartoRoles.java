package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.controllers.Visitors.Roles.*;
import edu.fiuba.algo3.vistas.Partida.PantallaRepartoRoles;

public class ControladorRepartoRoles {

    private final JuegoControlador juego;
    private int jugadorActual;

    public ControladorRepartoRoles(JuegoControlador juego){

        this.juego = juego;
        jugadorActual = 0;
    }

    public int numeroJugadorActual(){

        return jugadorActual + 1;
    }

    public CartaRolVista cartaJugadorActual(){

        return juego.cartaJugador(jugadorActual);
    }

    public void continuar(){

        jugadorActual++;

        if(terminoReparto()){

            juego.reconocerMafia();

            juego.mostrarReconocimiento();

            return;
        }

        mostrarPantalla();
    }

    private boolean terminoReparto(){

        return jugadorActual >= juego.cantidadJugadores();
    }

    public void mostrarPantalla(){

        juego.mostrarPantalla(
                new PantallaRepartoRoles(this)
        );
    }
}