package edu.fiuba.algo3.Integracion.entrega_2;

import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.modelo.Roles.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.*;
import edu.fiuba.algo3.modelo.Votacion.ResultadoVotacion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test07 {

    @Test
    public void verificarDeclaracionDeFaseDiurnaSinEliminacion() {

        Jugador jugador1 = new Jugador(1,new Mafioso());

        Jugador jugador2 = new Jugador(2,new Ciudadano());

        Jugadores jugadores = new Jugadores();

        jugadores.agregar(jugador1);
        jugadores.agregar(jugador2);

        EstadoPartida estado = new EstadoPartida();

        estado.inicializar(jugadores);

        FaseDiurna fase = new FaseDiurna();

        fase.nominar(jugador1,jugador2);
        fase.nominar(jugador2,jugador1);

        fase.votar(jugador1,jugador2);
        fase.votar(jugador2,jugador1);

        ResultadoVotacion resultado = fase.resolverVotacion(new SinEliminacionPorEmpate());

        fase.aplicarResultadoVotacion(resultado,estado);

        assertFalse(estado.eliminados().contiene(jugador1));
        assertFalse(estado.eliminados().contiene(jugador2));
    }

}
