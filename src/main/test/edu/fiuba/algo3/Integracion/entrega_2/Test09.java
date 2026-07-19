package edu.fiuba.algo3.Integracion.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test09 {

    @Test
    public void unJugadorEliminadoNoPuedeRealizarAccionesEnRondasPosteriores(){

        Jugador ciudadano = new Jugador(1,new Ciudadano());

        Jugador objetivo = new Jugador(2,new Ciudadano());

        FaseDiurna faseDiurna = new FaseDiurna();

        ciudadano.eliminar();

        assertThrows(JugadorMuertoException.class,ciudadano::estaVivo);

        assertThrows(JugadorMuertoNoPuedeActuarException.class, () -> ciudadano.actuarNoche(objetivo));
        assertThrows(JugadorMuertoNoPuedeActuarException.class, () -> faseDiurna.nominar(ciudadano,objetivo));
    }
}
