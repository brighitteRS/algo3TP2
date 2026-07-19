package edu.fiuba.algo3.Integracion.entrega_2;

import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mafia;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.modelo.Roles.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.*;
import edu.fiuba.algo3.modelo.Votacion.ResultadoVotacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test08 {

    @Test
    public void alFinalizarLaFaseNocturnaLaCartaDelJugadorEliminadoQuedaRevelada(){

        EstadoPartida estado = new EstadoPartida();
        FaseNocturna noche = new FaseNocturna();

        Jugador mafioso1 = new Jugador(1,new Mafioso());

        Jugador mafioso2 = new Jugador(2,new Mafioso());

        Jugador ciudadano = new Jugador(3,new Ciudadano());

        Jugadores jugadores = new Jugadores();

        jugadores.agregar(mafioso1);
        jugadores.agregar(mafioso2);
        jugadores.agregar(ciudadano);

        estado.inicializar(jugadores);
        estado.registrarJugadores();

        Mafia mafia = estado.mafia();

        mafia.reconocimientoInicial();

        mafia.votar(mafioso1, ciudadano);
        mafia.votar(mafioso2, ciudadano);

        noche.registrar(mafia.decidirAtaque());

        assertEquals(RolNulo.INSTANCIA, ciudadano.cartaRevelada());

        noche.resolver(estado);

        assertTrue(estado.eliminados().contiene(ciudadano));

        assertEquals(new Ciudadano(), ciudadano.cartaRevelada());
    }

    @Test
    public void alFinalizarLaFaseDiurnaLaCartaDelJugadorEliminadoQuedaRevelada() {

        EstadoPartida estado = new EstadoPartida();
        FaseDiurna dia = new FaseDiurna();

        Jugador jugadorAEliminar = new Jugador(1,new Mafioso());

        Jugador jugador2 = new Jugador(2,new Ciudadano());

        Jugador jugador3 = new Jugador(3,new Ciudadano());

        Jugadores jugadores = new Jugadores();

        jugadores.agregar(jugadorAEliminar);
        jugadores.agregar(jugador2);
        jugadores.agregar(jugador3);

        estado.inicializar(jugadores);

        dia.nominar(jugador2, jugadorAEliminar);
        dia.nominar(jugador3, jugadorAEliminar);
        dia.nominar(jugadorAEliminar, jugador3);

        dia.votar(jugador2, jugadorAEliminar);
        dia.votar(jugador3, jugadorAEliminar);
        dia.abstenerse(jugadorAEliminar);

        assertEquals(RolNulo.INSTANCIA, jugadorAEliminar.cartaRevelada());

        dia.resolver(estado);

        assertTrue(estado.eliminados().contiene(jugadorAEliminar));

        assertEquals(new Mafioso(), jugadorAEliminar.cartaRevelada());
    }
}
