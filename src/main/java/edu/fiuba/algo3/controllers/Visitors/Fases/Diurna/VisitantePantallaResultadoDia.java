package edu.fiuba.algo3.controllers.Visitors.Fases.Diurna;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorResultadoDia;
import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.modelo.Visitors.VisitanteResultadoDia;
import edu.fiuba.algo3.modelo.Votacion.*;
import edu.fiuba.algo3.vistas.Fases.Dia.PantallaResultadoDia;
import edu.fiuba.algo3.vistas.Pantalla;

public class VisitantePantallaResultadoDia implements VisitanteResultadoDia {

    private final JuegoControlador juego;
    private Pantalla pantalla;

    public VisitantePantallaResultadoDia(JuegoControlador juego){
        this.juego = juego;
    }

    @Override
    public void visitarGanador(ResultadoGanador resultado){

        pantalla = new PantallaResultadoDia(
                new ControladorResultadoDia(
                        juego,
                        resultado
                )
        );
    }

    @Override
    public void visitarEmpate(ResultadoEmpate resultado){

        pantalla = new PantallaResultadoDia(
                new ControladorResultadoDia(
                        juego,
                        resultado
                )
        );
    }

    public Pantalla pantalla(){
        return pantalla;
    }
}