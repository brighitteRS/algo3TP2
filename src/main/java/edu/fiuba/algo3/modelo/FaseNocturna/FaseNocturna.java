package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.*;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.*;
import edu.fiuba.algo3.modelo.Partida.Fase;

public class FaseNocturna implements Fase {

    private final HistorialNocturno historial;
    private final Resolutor resolutor;
    private TurnoNocturno turnoActual;
    private ResultadoNoche resultado;

    public FaseNocturna(){
        this(new TurnoFinal(),new HistorialNocturno());
    }

    public FaseNocturna(TurnoNocturno turnoInicial,HistorialNocturno historialInicial) {

        historial = historialInicial;
        resolutor = new Resolutor();
        turnoActual = turnoInicial;
    }

    public void registrar(AccionNocturna accion) {

        accion.actuar();
        accion.registrarEn(historial);
    }

    public void avanzar() {
        turnoActual = turnoActual.siguiente();
    }

    public TurnoNocturno turnoActual() {
        return turnoActual;
    }

    public void resolver(EstadoPartida estado) {

        resultado = resolutor.resolver(historial);
        resultado.aplicar(estado);
        estado.historialPartida().registrarHistorialNocturno(historial);
    }

    public ResultadoNoche resultado(){
        return resultado;
    }
}
