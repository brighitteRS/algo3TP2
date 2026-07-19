package edu.fiuba.algo3.Integracion.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.JugadorMuertoException;
import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.modelo.Roles.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.SinEliminacionPorEmpate;
import edu.fiuba.algo3.modelo.Votacion.ResultadoVotacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test06 {

    @Test
    public void verificarQueLaVotacionDiurnaElimineJugadorConMayorCantidadDeVotos() {

        Jugador jugadorAEliminar = new Jugador(1,new Mafioso());

        Jugador jugador2 = new Jugador(2,new Ciudadano());

        Jugador jugador3 = new Jugador(3,new Ciudadano());

        Jugadores jugadores = new Jugadores();

        jugadores.agregar(jugadorAEliminar);
        jugadores.agregar(jugador2);
        jugadores.agregar(jugador3);

        EstadoPartida estado = new EstadoPartida();

        estado.inicializar(jugadores);

        FaseDiurna fase = new FaseDiurna();

        fase.nominar(jugador2, jugadorAEliminar);
        fase.nominar(jugador3, jugadorAEliminar);
        fase.nominar(jugadorAEliminar, jugador3);

        fase.votar(jugador2, jugadorAEliminar);
        fase.votar(jugador3, jugadorAEliminar);
        fase.abstenerse(jugadorAEliminar);

        ResultadoVotacion resultado = fase.resolverVotacion(new SinEliminacionPorEmpate());

        fase.aplicarResultadoVotacion(resultado,estado);

        assertThrows(JugadorMuertoException.class, jugadorAEliminar::estaVivo);
        assertFalse(estado.eliminados().contiene(jugador2));
        assertFalse(estado.eliminados().contiene(jugador3));
    }
}
