package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;

public class ResultadoPartida {

    private ResultadoVictoria resultado;

    public ResultadoPartida(){

        resultado = new SinVictoria();
    }

    public void finalizar(ResultadoVictoria resultado){

        this.resultado = resultado;
    }

    public boolean termino(){

        return resultado.termino();
    }

    public ResultadoVictoria victoria(){

        return resultado;
    }
}