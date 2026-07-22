package edu.fiuba.algo3.controllers.FaseDiurna;

import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.controllers.Visitors.Fases.Diurna.VisitanteResultadoDiaVista;
import edu.fiuba.algo3.modelo.Votacion.ResultadoVotacion;

import javafx.scene.layout.VBox;

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

    public void continuar(){
        juego.finalizarDia();
    }

    public VBox resultadoVista(){

        VisitanteResultadoDiaVista visitante =
                new VisitanteResultadoDiaVista();

        resultado.aceptarVisitante(visitante);

        return visitante.resultado();
    }
}