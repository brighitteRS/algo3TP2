package edu.fiuba.algo3.Integracion.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Partida.Partida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Test03 {

    @Test
    public void partidaFinalizaCuandoLaCondicionDeVictoriaSeCumpleLuegoDeLaNoche(){

        EstadoPartida estado = new EstadoPartida();

        CondicionVictoria condicion = mock(CondicionVictoria.class);

        when(condicion.evaluar(estado))
                .thenReturn(new VictoriaMafia());

        Partida partida = new Partida(estado, condicion);

        partida.finalizarNoche();

        assertTrue(partida.resultado().termino());
        assertEquals(BandoMafia.INSTANCIA, partida.resultado().victoria().ganador());
    }

    @Test
    public void partidaFinalizaCuandoLaCondicionDeVictoriaSeCumpleLuegoDelDia(){

        EstadoPartida estado = new EstadoPartida();

        CondicionVictoria condicion = mock(CondicionVictoria.class);

        when(condicion.evaluar(estado))
                .thenReturn(new VictoriaCiudadanos());


        Partida partida = new Partida(estado, condicion);

        partida.finalizarDia();

        assertTrue(partida.resultado().termino());
        assertEquals(BandoCiudadano.INSTANCIA, partida.resultado().victoria().ganador());
    }
}
