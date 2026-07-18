package edu.fiuba.algo3.Integracion.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test03 {

    @Test
    public void unJugadorSoloPuedeVerSuPropioRolYNoElDeLosDemas() {

        Jugador jugador1 = new Jugador(1,new Mafioso());
        Jugador jugador2 = new Jugador(2,new Ciudadano());

        assertEquals(new Mafioso(), jugador1.verRol(jugador1));

        assertThrows(AccesoARolNoPermitidoExcepcion.class, () -> jugador1.verRol(jugador2));
    }
}
