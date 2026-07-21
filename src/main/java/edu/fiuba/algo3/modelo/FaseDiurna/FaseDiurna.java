package edu.fiuba.algo3.modelo.FaseDiurna;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Partida.Fase;
import edu.fiuba.algo3.modelo.Votacion.Nominaciones.*;
import edu.fiuba.algo3.modelo.Votacion.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.*;

public class FaseDiurna implements Fase {

    private final Nominaciones nominaciones;
    private final Votacion votacion;
    private final Urna urna;
    private final HistorialDiurno historial;
    private final ReglaDesempate reglaDesempate;
    private ResultadoVotacion resultado;

    public FaseDiurna(){
        this(new SinEliminacionPorEmpate(), new HistorialDiurno());
    }

    public FaseDiurna(ReglaDesempate regla, HistorialDiurno historialInicial){

        nominaciones = new Nominaciones();
        urna = new Urna();
        votacion = new Votacion(urna);
        historial = historialInicial;
        reglaDesempate = regla;
    }

    public void nominar(Jugador nominador, Jugador nominado) {

        Nominacion nominacion = new Nominacion(nominador, nominado);

        nominaciones.registrar(nominacion);
        historial.registrarNominacion(nominacion);
    }

    public void votar(Jugador votador, Jugador votado) {

        nominaciones.validarEstaNominado(votado);
        Voto voto = new Voto(votador, votado);

        urna.registrar(voto);
        historial.registrarVoto(voto);
    }

    public void abstenerse(Jugador jugador){

        jugador.validarPuedeActuar();
        historial.registrarAbstencion(new Abstencion(jugador));
    }

    public void resolver(EstadoPartida estado){

        resultado = votacion.resolver(reglaDesempate);
        resultado.resolver(estado);
        estado.historialPartida().registrarHistorialDiurno(historial);
    }

    public Nominaciones nominaciones(){
        return nominaciones;
    }

    public ResultadoVotacion resultado(){
        return resultado;
    }
}
