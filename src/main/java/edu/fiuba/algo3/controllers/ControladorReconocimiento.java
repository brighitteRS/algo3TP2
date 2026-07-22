package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.controllers.Visitors.Roles.*;
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

    public void continuar(){

        jugadorActual++;

        if(jugadorActual >= juego.cantidadJugadores()){

            juego.iniciarNoche();
            return;
        }

        mostrarPantalla();
    }

    public boolean tieneComplices(){

        return !juego.complicesJugador(jugadorActual)
                .todos()
                .isEmpty();
    }

    public int cantidadComplices(){

        return juego.complicesJugador(jugadorActual)
                .cantidad();
    }

    public int idComplice(int indice){

        return juego.complicesJugador(jugadorActual)
                .jugador(indice)
                .id();
    }

    public void mostrarPantalla(){

        juego.mostrarPantalla(
                new PantallaReconocimiento(this)
        );
    }
}