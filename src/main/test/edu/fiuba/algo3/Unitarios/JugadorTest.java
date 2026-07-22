package edu.fiuba.algo3.Unitarios;

import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Jugador.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {

    @Test
    public void unJugadorVivoPuedeActuar(){

        EstadoJugador estado = new Vivo();

        assertDoesNotThrow(
                estado::validarPuedeActuar
        );
    }

    @Test
    public void unJugadorVivoPuedeSerObjetivo(){

        EstadoJugador estado = new Vivo();

        assertDoesNotThrow(
                estado::validarPuedeSerObjetivo
        );
    }

    @Test
    public void siJugadorMuereCambiaSuEstado(){

        EstadoJugador estado = new Vivo();

        EstadoJugador nuevoEstado = estado.morir();

        assertTrue(nuevoEstado instanceof Muerto);
    }

    @Test
    public void unJugadorMuertoNoPuedeActuar(){

        EstadoJugador estado = new Muerto();

        assertThrows(
                JugadorMuertoNoPuedeActuarException.class,
                estado::validarPuedeActuar
        );
    }

    @Test
    public void unJugadorMuertoNoPuedeSerObjetivo(){

        EstadoJugador estado = new Muerto();

        assertThrows(
                JugadorMuertoNoPuedeSerObjetivoException.class,
                estado::validarPuedeSerObjetivo
        );
    }
}
