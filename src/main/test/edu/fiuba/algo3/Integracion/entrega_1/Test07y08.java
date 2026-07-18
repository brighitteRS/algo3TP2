package edu.fiuba.algo3.Integracion.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.JugadorMuertoException;
import edu.fiuba.algo3.modelo.FaseNocturna.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test07y08 {

    @Test
    public void siMedicoProtegeAlMismoJugadorQueEligioMafiaLaEliminacionQuedaAnuladaYJugadorSigueVivo() {

        EstadoPartida estado = new EstadoPartida();
        FaseNocturna noche = new FaseNocturna();

        Jugador mafioso1 = new Jugador(1,new Mafioso());
        Jugador mafioso2 = new Jugador(2,new Mafioso());
        Jugador ciudadano = new Jugador(3,new Ciudadano());
        Jugador medico = new Jugador(4,new Medico());

        Jugadores jugadores = new Jugadores();

        jugadores.agregar(mafioso1);
        jugadores.agregar(mafioso2);
        jugadores.agregar(ciudadano);
        jugadores.agregar(medico);

        estado.inicializar(jugadores);
        estado.registrarJugadores();

        Mafia mafia = estado.mafia();

        mafia.reconocimientoInicial();

        mafia.votar(mafioso1, ciudadano);
        mafia.votar(mafioso2, ciudadano);

        noche.registrar(mafia.decidirAtaque());
        noche.registrar(medico.actuarNoche(ciudadano));

        noche.resolver(estado);

        assertDoesNotThrow(ciudadano::estaVivo);
        assertFalse(estado.eliminados().contiene(ciudadano));
    }

    @Test
    public void siLaMafiaEligeUnJugadorNoProtegidoJugadorPasaAEstadoEliminadoAlFinalizarFaseNocturna() {

        EstadoPartida estado = new EstadoPartida();
        FaseNocturna noche = new FaseNocturna();

        Jugador mafioso1 = new Jugador(1,new Mafioso());
        Jugador mafioso2 = new Jugador(2,new Mafioso());
        Jugador jugador3 = new Jugador(3,new Ciudadano());
        Jugador jugador4 = new Jugador(4,new Ciudadano());
        Jugador medico = new Jugador(5,new Medico());

        Jugadores jugadores = new Jugadores();

        jugadores.agregar(mafioso1);
        jugadores.agregar(mafioso2);
        jugadores.agregar(jugador3);
        jugadores.agregar(jugador4);
        jugadores.agregar(medico);

        estado.inicializar(jugadores);
        estado.registrarJugadores();

        Mafia mafia = estado.mafia();

        mafia.reconocimientoInicial();

        mafia.votar(mafioso1, jugador3);
        mafia.votar(mafioso2, jugador3);

        noche.registrar(mafia.decidirAtaque());
        noche.registrar(medico.actuarNoche(jugador4));

        noche.resolver(estado);

        assertThrows(JugadorMuertoException.class, jugador3::estaVivo);
        assertTrue(estado.eliminados().contiene(jugador3));
    }
}
