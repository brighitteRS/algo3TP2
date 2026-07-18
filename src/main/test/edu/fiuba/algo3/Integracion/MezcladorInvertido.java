package edu.fiuba.algo3.Integracion;

import edu.fiuba.algo3.modelo.Jugador.Rol;
import edu.fiuba.algo3.modelo.Mazo.Mezclador;

import java.util.Collections;
import java.util.List;

public class MezcladorInvertido implements Mezclador {

    @Override
    public void mezclar(List<Rol> cartas) {
        Collections.reverse(cartas);
    }
}