package edu.fiuba.algo3.Integracion.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mafia;
import edu.fiuba.algo3.modelo.Roles.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.DecisionPorPadrino;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test05y06 {

    @Test
    public void verificarQueMafiaPuedaSeleccionarVíctimaValidaDuranteFaseNocturna() {

        Mafia mafia = new Mafia();

        Jugador mafioso1 = new Jugador(1,new Mafioso());
        Jugador mafioso2 = new Jugador(2,new Mafioso());
        Jugador ciudadano = new Jugador(3,new Ciudadano());

        mafia.agregar(mafioso1);
        mafia.agregar(mafioso2);

        mafia.reconocimientoInicial();

        mafia.votar(mafioso1, ciudadano);
        mafia.votar(mafioso2, ciudadano);

        Jugador victima = mafia.resolverVotacion(new DecisionPorPadrino()).ganador();

        assertEquals(ciudadano, victima);
    }

    @Test
    public void verificarQueIntentarSeleccionarVictimaInvalidaElSistemaRechaceLaAccion() {

        Mafia mafia = new Mafia();

        Jugador mafioso1 = new Jugador(1,new Mafioso());
        Jugador mafioso2 = new Jugador(2,new Mafioso());
        Jugador ciudadano = new Jugador(3,new Ciudadano());

        mafia.agregar(mafioso1);
        mafia.agregar(mafioso2);

        mafia.reconocimientoInicial();

        ciudadano.eliminar();

        assertThrows(JugadorMuertoNoPuedeSerObjetivoException.class, () -> mafia.votar(mafioso1,ciudadano));
        assertThrows(NoSePuedeAtacarAMafiosoException.class, () -> mafia.votar(mafioso1,mafioso2));
    }
}
