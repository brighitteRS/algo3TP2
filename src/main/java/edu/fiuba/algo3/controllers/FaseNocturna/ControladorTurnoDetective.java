package edu.fiuba.algo3.controllers.FaseNocturna;

import edu.fiuba.algo3.controllers.Visitors.Bandos.VisitanteResultadoBando;
import edu.fiuba.algo3.modelo.Excepciones.MismaEleccionConsecutivaException;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoDetective;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class ControladorTurnoDetective {

    private final ControladorFaseNocturna fase;
    private final TurnoDetective turno;

    public ControladorTurnoDetective(ControladorFaseNocturna controlador, TurnoDetective turno){
        this.fase = controlador;
        this.turno = turno;
    }

    public void investigar(Jugador objetivo){

        try {

            fase.registrar(
                    turno.detective().actuarNoche(objetivo)
            );

        } catch (MismaEleccionConsecutivaException e){

            fase.notificar(e.getMessage());
        }
    }

    public String resultadoInvestigacion() {

        VisitanteResultadoBando visitante =
                new VisitanteResultadoBando();

        turno.detective()
                .obtenerResultadoInvestigacion()
                .aceptarVisitante(visitante);

        return visitante.resultado();
    }

    public void continuar(){
        fase.avanzar();
    }

    public int cantidadObjetivos() {

        return fase.jugadoresActivos().cantidad();
    }

    public int idObjetivo(int indice) {

        return fase.jugadoresActivos()
                .jugador(indice)
                .id();
    }

    public Jugador objetivo(int indice) {

        return fase.jugadoresActivos()
                .jugador(indice);
    }
}