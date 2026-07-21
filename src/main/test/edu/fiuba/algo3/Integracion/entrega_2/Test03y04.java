package edu.fiuba.algo3.Integracion.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.MismaEleccionConsecutivaException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test03y04 {

    @Test
    public void elDetectiveNoPuedeInvestigarAlMismoJugadorDosNochesConsecutivas() {

        Jugador detective = new Jugador(1,new Detective());

        Jugador jugador1 = new Jugador(2,new Mafioso());

        Jugador jugador2 = new Jugador(3,new Mafioso());

        detective.actuarNoche(jugador1);

        assertThrows(MismaEleccionConsecutivaException.class, () -> detective.actuarNoche(jugador1));

        detective.actuarNoche(jugador2);
    }

    @Test
    public void elMedicoNoPuedeProtegerAlMismoJugadorDosNochesConsecutivas() {

        Jugador medico = new Jugador(1,new Medico());

        Jugador jugador1 = new Jugador(2,new Ciudadano());

        Jugador jugador2 = new Jugador(3,new Ciudadano());

        medico.actuarNoche(jugador1);

        assertThrows(MismaEleccionConsecutivaException.class, () -> medico.actuarNoche(jugador1));

        medico.actuarNoche(jugador2);
    }
}
