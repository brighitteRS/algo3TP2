package edu.fiuba.algo3.Integracion.entrega_1;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mafia;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test04 {

    @Test
    public void losMafiososConocenASusComplicesAlInicioDelJuego() {

        Mafia mafia = new Mafia();

        Jugador mafioso1 = new Jugador(1,new Mafioso());
        Jugador mafioso2 = new Jugador(2,new Mafioso());
        Jugador ciudadano = new Jugador(3,new Ciudadano());

        mafia.agregar(mafioso1);
        mafia.agregar(mafioso2);
        mafia.reconocimientoInicial();

        assertTrue(mafioso1.esMiComplice(mafioso2));
        assertTrue(mafioso2.esMiComplice(mafioso1));

        assertFalse(mafioso1.esMiComplice(ciudadano));
        assertFalse(ciudadano.esMiComplice(mafioso1));
    }
}
