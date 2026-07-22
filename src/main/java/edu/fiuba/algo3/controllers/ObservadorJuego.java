package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.vistas.Pantalla;

public interface ObservadorJuego {

    void actualizar(String mensaje);

    void actualizarEstado(String estado);

    void mostrarPantalla(Pantalla pantalla);
}