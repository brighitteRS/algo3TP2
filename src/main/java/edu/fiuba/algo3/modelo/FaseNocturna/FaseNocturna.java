package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoFinal;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoNocturno;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.*;
import edu.fiuba.algo3.modelo.Partida.Fase;

public class FaseNocturna implements Fase {

    private final HistorialNocturno historial;
    private final Resolutor resolutor;
    private TurnoNocturno turnoActual;

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

        ResultadoNoche resultado = resolutor.resolver(historial);

        resultado.aplicar(estado);
    }
}
