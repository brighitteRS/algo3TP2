package edu.fiuba.algo3.Integracion.entrega_2;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.Jugador.Bando.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test01y02 {

    @Test
    public void verificarQueDetectiveRecibaElResultadoCorrectoAlInvestigarUnMafioso() {

        Jugador detective = new Jugador(1,new Detective());
        Jugador mafioso = new Jugador(2,new Mafioso());

        AccionNocturna investigacion = detective.actuarNoche(mafioso);

        investigacion.actuar();

        assertEquals(BandoMafia.INSTANCIA, detective.obtenerResultadoInvestigacion());
    }

    @Test
    public void verificarQueDetectiveRecibaElResultadoCorrectoAlInvestigarUnCiudadano() {

        Jugador detective = new Jugador(1,new Detective());

        Jugador ciudadano = new Jugador(2,new Ciudadano());

        AccionNocturna investigacion = detective.actuarNoche(ciudadano);

        investigacion.actuar();

        assertEquals(BandoCiudadano.INSTANCIA, detective.obtenerResultadoInvestigacion());}

    @Test
    public void verificarQueDetectiveRecibaCiudadanoAlInvestigarAlPadrino() {

        Jugador detective = new Jugador(1,new Detective());

        Jugador padrino = new Jugador(2,new Padrino());

        AccionNocturna investigacion = detective.actuarNoche(padrino);

        investigacion.actuar();

        assertEquals(BandoCiudadano.INSTANCIA, detective.obtenerResultadoInvestigacion());}
}
