package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.vistas.Pantalla;

public interface ObservadorJuego {

    void actualizar(String mensaje);

    void mostrarPantalla(Pantalla pantalla);
}