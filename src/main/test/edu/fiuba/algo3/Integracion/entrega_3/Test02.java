package edu.fiuba.algo3.Integracion.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.CondicionVictoriaBando;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test02 {

    @Test
    public void mafiaGanaCuandoIgualaCantidadDeCiudadanosVivos() {

        EstadoPartida estado = new EstadoPartida();
        Jugadores jugadores = new Jugadores();
        Partida partida = new Partida(estado,new CondicionVictoriaBando());

        jugadores.agregar(new Jugador(1, new Mafioso()));
        jugadores.agregar(new Jugador(2, new Ciudadano()));

        estado.inicializar(jugadores);

        assertEquals(BandoMafia.INSTANCIA, partida.condicionVictoria().evaluar(estado).ganador());
    }

    @Test
    public void mafiaGanaCuandoSuperaCantidadDeCiudadanosVivos() {

        EstadoPartida estado = new EstadoPartida();
        Jugadores jugadores = new Jugadores();
        Partida partida = new Partida(estado,new CondicionVictoriaBando());

        jugadores.agregar(new Jugador(1, new Mafioso()));
        jugadores.agregar(new Jugador(2, new Mafioso()));
        jugadores.agregar(new Jugador(3, new Ciudadano()));

        estado.inicializar(jugadores);

        assertEquals(BandoMafia.INSTANCIA, partida.condicionVictoria().evaluar(estado).ganador());
    }

    @Test
    public void ciudadanosGananCuandoNoQuedanMafiososVivos() {

        EstadoPartida estado = new EstadoPartida();
        Jugadores jugadores = new Jugadores();
        Partida partida = new Partida(estado,new CondicionVictoriaBando());

        Jugador mafioso = new Jugador(1, new Mafioso());
        jugadores.agregar(mafioso);
        jugadores.agregar(new Jugador(2, new Ciudadano()));

        estado.inicializar(jugadores);
        estado.eliminar(mafioso);

        assertEquals(BandoCiudadano.INSTANCIA, partida.condicionVictoria().evaluar(estado).ganador());
    }

    @Test
    public void mafiaGanaCuandoNoQuedanCiudadanosVivos() {

        EstadoPartida estado = new EstadoPartida();
        Jugadores jugadores = new Jugadores();
        Partida partida = new Partida(estado,new CondicionVictoriaBando());

        jugadores.agregar(new Jugador(1, new Mafioso()));
        Jugador ciudadano = new Jugador(2, new Ciudadano());
        jugadores.agregar(ciudadano);

        estado.inicializar(jugadores);
        estado.eliminar(ciudadano);

        assertEquals(BandoMafia.INSTANCIA, partida.condicionVictoria().evaluar(estado).ganador());
    }
}
