package edu.fiuba.algo3.controllers.FaseNocturna;

import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.controllers.Visitors.Fases.Nocturna.VisitantePantallaTurno;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.ResultadoNoche;
import edu.fiuba.algo3.modelo.Partida.Jugadores;

public class ControladorFaseNocturna {

    private final JuegoControlador juego;
    private final FaseNocturna fase;

    public ControladorFaseNocturna(JuegoControlador juego, FaseNocturna fase){
        this.juego = juego;
        this.fase = fase;
    }

    public void mostrarTurnoActual(){

        VisitantePantallaTurno visitante =
                new VisitantePantallaTurno(this);

        fase.turnoActual()
                .aceptarVisitante(visitante);

        juego.mostrarPantalla(
                visitante.pantalla()
        );
    }

    public void registrar(AccionNocturna accion){

        fase.registrar(accion);
    }

    public void avanzar(){

        fase.avanzar();

        mostrarTurnoActual();
    }

    public Jugadores jugadoresActivos(){

        return juego.jugadoresActivos();
    }

    public void notificar(String mensaje){

        juego.notificar(mensaje);
    }

    public void resolver(){

        fase.resolver(juego.estado());
    }

    public ResultadoNoche resultado(){

        return fase.resultado();
    }

    public void finalizarNoche(){

        juego.finalizarNoche();
    }
}