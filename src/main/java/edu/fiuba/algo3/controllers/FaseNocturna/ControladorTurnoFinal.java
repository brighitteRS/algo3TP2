package edu.fiuba.algo3.controllers.FaseNocturna;

import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.ResultadoNoche;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoFinal;

public class ControladorTurnoFinal {

    private final ControladorFaseNocturna fase;
    private final TurnoFinal turno;

    public ControladorTurnoFinal(
            ControladorFaseNocturna fase,
            TurnoFinal turno
    ){
        this.fase = fase;
        this.turno = turno;
    }

    public void resolver(){

        fase.resolver();
    }

    public ResultadoNoche resultado(){

        return fase.resultado();
    }

    public void continuar(){

        fase.finalizarNoche();
    }
}