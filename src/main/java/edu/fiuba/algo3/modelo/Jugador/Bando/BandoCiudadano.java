package edu.fiuba.algo3.modelo.Jugador.Bando;

import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ContadorBandos;

public class BandoCiudadano implements Bando {

    public static final BandoCiudadano INSTANCIA = new BandoCiudadano();

    private BandoCiudadano() {
    }

    @Override
    public void contabilizar(ContadorBandos contador) {
        contador.agregarCiudadano();
    }
}