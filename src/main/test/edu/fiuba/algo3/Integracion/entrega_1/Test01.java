package edu.fiuba.algo3.Integracion.entrega_1;

import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test01 {

    @Test
    public void paraCincoJugadoresSeGeneraUnMazoConLaComposicionCorrecta() {

        Mazo esperado = new Mazo(List.of(
                new Mafioso(),
                new Mafioso(),
                new Medico(),
                new Ciudadano(),
                new Ciudadano()
        ));

        Mazo generado = new Mazo(5);

        assertEquals(esperado, generado);
    }

    @Test
    public void paraSieteJugadoresSeGeneraUnMazoConLaComposicionCorrecta() {

        Mazo esperado = new Mazo(List.of(
                new Mafioso(),
                new Mafioso(),
                new Mafioso(),
                new Detective(),
                new Medico(),
                new Ciudadano(),
                new Ciudadano()
        ));

        Mazo generado = new Mazo(7);

        assertEquals(esperado, generado);
    }

    @Test
    public void para10JugadoresSeGeneraUnMazoConLaComposicionCorrecta() {

        Mazo esperado = new Mazo(List.of(
                new Mafioso(),
                new Mafioso(),
                new Detective(),
                new Medico(),
                new Padrino(),
                new Sheriff(),
                new Ciudadano(),
                new Ciudadano(),
                new Ciudadano(),
                new Ciudadano()
        ));

        Mazo generado = new Mazo(10);

        assertEquals(esperado, generado);
    }
}
