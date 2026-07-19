package edu.fiuba.algo3.modelo.Partida.CondicionesVictoria;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public class CondicionVictoriaBando implements CondicionVictoria {

    @Override
    public ResultadoVictoria evaluar(EstadoPartida estado) {

        ContadorBandos contador = new ContadorBandos();

        estado.jugadoresVivos().contabilizarEn(contador);

        return contador.resultado();
    }
}
