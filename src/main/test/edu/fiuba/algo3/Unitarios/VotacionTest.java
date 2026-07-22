package edu.fiuba.algo3.Unitarios;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Votacion.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VotacionTest {

    @Test
    public void ganaJugadorConMayorCantidadDeVotos(){

        Jugador jugador1 = new Jugador(1);
        Jugador jugador2 = new Jugador(2);

        Urna urna = new Urna();
        Votacion votacion = new Votacion(urna);

        urna.registrar(new Voto(new Jugador(3), jugador1));
        urna.registrar(new Voto(new Jugador(4), jugador1));
        urna.registrar(new Voto(new Jugador(5), jugador2));

        ResultadoVotacion resultado = votacion.resolver(new SinEliminacionPorEmpate());

        assertEquals(jugador1, resultado.ganador());
    }

    @Test
    public void empateNoEliminaSiLaReglaEsSinEliminacion(){

        Jugador jugador1 = new Jugador(1);
        Jugador jugador2 = new Jugador(2);

        Urna urna = new Urna();
        Votacion votacion = new Votacion(urna);

        urna.registrar(new Voto(new Jugador(3), jugador1));
        urna.registrar(new Voto(new Jugador(4), jugador2));

        ResultadoVotacion resultado = votacion.resolver(new SinEliminacionPorEmpate());

        assertEquals(JugadorNulo.INSTANCIA,resultado.ganador());
    }

    @Test
    public void padrinoDefineGanadorEnEmpate(){

        Jugador padrino = new Jugador(1);
        Jugador jugador1 = new Jugador(2);
        Jugador jugador2 = new Jugador(3);

        Urna urna = new Urna();
        Votacion votacion = new Votacion(urna);

        urna.registrar(new Voto(new Jugador(4), jugador1));
        urna.registrar(new Voto(new Jugador(5), jugador2));
        urna.registrar(new Voto(padrino, jugador2));

        ResultadoVotacion resultado = new DecisionPorPadrino(padrino).resolver(votacion);

        assertEquals(jugador2, resultado.ganador());
    }
}