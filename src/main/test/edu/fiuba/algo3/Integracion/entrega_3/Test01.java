package edu.fiuba.algo3.Integracion.entrega_3;

import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.Jugador.Bando.BandoCiudadano;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mafia;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test01 {

    @Test
    public void juegoTerminadoIncluyendoTodosLosRolesEspecialesYSusInteracciones(){

        EstadoPartida estado = new EstadoPartida();
        FaseNocturna noche = new FaseNocturna();

        Jugador mafioso = new Jugador(1,new Mafioso());
        Jugador padrino = new Jugador(2,new Padrino());
        Jugador medico = new Jugador(3,new Medico());
        Jugador detective = new Jugador(4,new Detective());
        Jugador ciudadano1 = new Jugador(5,new Ciudadano());
        Jugador ciudadano2 = new Jugador(6,new Ciudadano());

        Jugadores jugadores = new Jugadores();

        jugadores.agregar(mafioso);
        jugadores.agregar(padrino);
        jugadores.agregar(medico);
        jugadores.agregar(detective);
        jugadores.agregar(ciudadano1);
        jugadores.agregar(ciudadano2);

        estado.inicializar(jugadores);
        estado.registrarJugadores();

        Mafia mafia = estado.mafia();

        mafia.reconocimientoInicial();

        mafia.votar(mafioso,ciudadano1);
        mafia.votar(padrino,ciudadano2);

        noche.registrar(mafia.decidirAtaque());
        noche.registrar(detective.actuarNoche(medico));
        noche.registrar(medico.actuarNoche(ciudadano2));

        noche.resolver(estado);

        assertFalse(estado.eliminados().contiene(ciudadano2));
        assertFalse(estado.eliminados().contiene(ciudadano1));
        assertEquals(BandoCiudadano.INSTANCIA,detective.obtenerResultadoInvestigacion());
    }

    @Test
    public void padrinoDefineLaVictimaCuandoLaMafiaEmpataEnLaVotacion() {

        EstadoPartida estado = new EstadoPartida();
        FaseNocturna noche = new FaseNocturna();

        Jugador mafioso = new Jugador(1, new Mafioso());
        Jugador padrino = new Jugador(2, new Padrino());
        Jugador ciudadano1 = new Jugador(3, new Ciudadano());
        Jugador ciudadano2 = new Jugador(4, new Ciudadano());

        Jugadores jugadores = new Jugadores();

        jugadores.agregar(mafioso);
        jugadores.agregar(padrino);
        jugadores.agregar(ciudadano1);
        jugadores.agregar(ciudadano2);

        estado.inicializar(jugadores);
        estado.registrarJugadores();

        Mafia mafia = estado.mafia();

        mafia.reconocimientoInicial();

        mafia.votar(mafioso, ciudadano1);
        mafia.votar(padrino, ciudadano2);

        noche.registrar(mafia.decidirAtaque());

        noche.resolver(estado);

        assertTrue(estado.eliminados().contiene(ciudadano2));
        assertFalse(estado.eliminados().contiene(ciudadano1));
    }
}
