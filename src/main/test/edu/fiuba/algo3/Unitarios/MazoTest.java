package edu.fiuba.algo3.Unitarios;

import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazoTest {

    @Test
    public void elMazoTieneLaMismaCantidadDeCartasYJugadores(){

        Mazo mazo = new Mazo(5);

        assertEquals(5, mazo.cantidad());
    }

    @Test
    public void noSePuedeCrearUnMazoParaMenosDe5YMasDe12Jugadores(){

        assertThrows(
                CantidadDeJugadoresInvalidaExcepcion.class,
                () -> new Mazo(4)
        );

        assertThrows(
                CantidadDeJugadoresInvalidaExcepcion.class,
                () -> new Mazo(13)
        );
    }

    @Test
    public void alRepartirUnaCartaElMazoTieneUnaCartaMenos(){

        Mazo mazo = new Mazo(5);

        mazo.repartirCarta();

        assertEquals(4,mazo.cantidad());
    }

    @Test
    public void siElMazoEstaVacioNoReparteNada(){

        Mazo mazo = new Mazo(List.of());

        assertThrows(MazoVacioExcepcion.class, mazo::repartirCarta);
    }
}
