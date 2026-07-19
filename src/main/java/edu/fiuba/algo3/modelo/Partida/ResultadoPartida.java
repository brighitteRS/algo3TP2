package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;
import edu.fiuba.algo3.modelo.NullPattern.BandoNulo;

public class ResultadoPartida {

    private Bando bandoGanador;
    private boolean terminada;

    public ResultadoPartida(){

        bandoGanador = BandoNulo.INSTANCIA;
        terminada = false;
    }

    public void finalizar(Bando ganador){

        bandoGanador = ganador;
        terminada = true;
    }

    public boolean termino(){
        return terminada;
    }

    public Bando ganador(){
        return bandoGanador;
    }
}