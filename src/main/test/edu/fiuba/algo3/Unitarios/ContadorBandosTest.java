package edu.fiuba.algo3.Unitarios;

import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContadorBandosTest {

    @Test
    public void elContadorDevuelveVictoriaCiudadanoPorqueSoloSeRegistroEseBando(){

        ContadorBandos contador = new ContadorBandos();

        contador.agregarCiudadano();
        contador.agregarCiudadano();

        ResultadoVictoria resultado = contador.resultado();

        assertTrue(resultado instanceof VictoriaCiudadanos);
    }

    @Test
    public void elContadorDevuelveVictoriaMafiaPorqueHayEmpateDeBandos(){

        ContadorBandos contador = new ContadorBandos();

        contador.agregarMafioso();
        contador.agregarMafioso();

        contador.agregarCiudadano();
        contador.agregarCiudadano();

        ResultadoVictoria resultado = contador.resultado();

        assertTrue(resultado instanceof VictoriaMafia);
    }

    @Test
    public void elContadorDevuelveSinVictoriaPorqueHayMasDelBandoCiudadano(){

        ContadorBandos contador = new ContadorBandos();

        contador.agregarMafioso();

        contador.agregarCiudadano();
        contador.agregarCiudadano();

        ResultadoVictoria resultado = contador.resultado();

        assertTrue(resultado instanceof SinVictoria);
    }
}