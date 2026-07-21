package edu.fiuba.algo3.Integracion.entrega_3;

import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.*;
import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Test04 {

    @Test
    public void partidaAlternaEntreFaseNocturnaYFaseDiurna() {

        CondicionVictoria condicion = mock(CondicionVictoria.class);

        when(condicion.evaluar(any()))
                .thenReturn(new SinVictoria());

        Partida partida = new Partida(new EstadoPartida(), condicion);

        partida.iniciarNoche();

        assertTrue(partida.estado().faseActual() instanceof FaseNocturna);

        partida.finalizarNoche();

        assertTrue(partida.estado().faseActual() instanceof FaseDiurna);

        partida.finalizarDia();

        assertTrue(partida.estado().faseActual() instanceof FaseNocturna);
    }

    @Test
    public void nocheActivaRolesEnOrdenCorrecto() {

        EstadoPartida estado = new EstadoPartida();

        Jugadores jugadores = new Jugadores();
        jugadores.agregar(new Jugador(1, new Mafioso()));
        jugadores.agregar(new Jugador(2, new Detective()));
        jugadores.agregar(new Jugador(3, new Medico()));

        estado.inicializar(jugadores);
        estado.registrarJugadores();

        estado.iniciarNoche();

        FaseNocturna noche = estado.noche();

        assertTrue(noche.turnoActual() instanceof TurnoMafia);

        noche.avanzar();

        assertTrue(noche.turnoActual() instanceof TurnoDetective);

        noche.avanzar();

        assertTrue(noche.turnoActual() instanceof TurnoMedico);

        noche.avanzar();

        assertTrue(noche.turnoActual() instanceof TurnoFinal);
    }
}
