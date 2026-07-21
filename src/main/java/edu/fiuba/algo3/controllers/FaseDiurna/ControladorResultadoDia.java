package edu.fiuba.algo3.controllers.FaseDiurna;

import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.modelo.Votacion.ResultadoVotacion;

public class ControladorResultadoDia {

    private final JuegoControlador juego;
    private final ResultadoVotacion resultado;

    public ControladorResultadoDia(
            JuegoControlador juego,
            ResultadoVotacion resultado
    ){
        this.juego = juego;
        this.resultado = resultado;
    }

    public ResultadoVotacion resultado(){
        return resultado;
    }

    public void continuar(){
        juego.finalizarDia();
    }
}