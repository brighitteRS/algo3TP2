package edu.fiuba.algo3.Integracion.entrega_1;

import edu.fiuba.algo3.Integracion.MezcladorInvertido;
import edu.fiuba.algo3.modelo.Partida.GeneradorJugadores;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.modelo.Mazo.*;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Test02 {

    @Test
    public void enElRepartoDeCartasCadaJugadorRecibeUnRol() {

        GeneradorJugadores generador = new GeneradorJugadores();
        Jugadores jugadores = generador.crear(5);

        Mazo mazo = new Mazo(5);

        for (Jugador jugador : jugadores.todos()) {
            jugador.recibirRol(mazo.repartirCarta());
        }

        for (Jugador jugador : jugadores.todos()) {
            assertNotEquals(RolNulo.INSTANCIA, jugador.verRol(jugador));
        }

        assertTrue(mazo.estaVacio());
    }

    @Test
    public void elRepartoDeCartasDependeDelMezclador() {

        Mazo mazo = new Mazo(List.of(
                new Mafioso(),
                new Mafioso(),
                new Medico(),
                new Ciudadano(),
                new Ciudadano()
        ));

        mazo.mezclar(new MezcladorInvertido());

        assertEquals(new Ciudadano(), mazo.repartirCarta());
        assertEquals(new Ciudadano(), mazo.repartirCarta());
        assertEquals(new Medico(), mazo.repartirCarta());
        assertEquals(new Mafioso(), mazo.repartirCarta());
        assertEquals(new Mafioso(), mazo.repartirCarta());

        assertTrue(mazo.estaVacio());
    }
}
