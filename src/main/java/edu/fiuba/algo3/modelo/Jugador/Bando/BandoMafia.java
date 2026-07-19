package edu.fiuba.algo3.modelo.Jugador.Bando;

import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ContadorBandos;

public class BandoMafia implements Bando {

    public static final BandoMafia INSTANCIA = new BandoMafia();

    private BandoMafia() {
    }

    @Override
    public void contabilizar(ContadorBandos contador) {
        contador.agregarMafioso();
    }
}