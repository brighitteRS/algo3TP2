package edu.fiuba.algo3.controllers.FaseDiurna;

import edu.fiuba.algo3.controllers.JuegoControlador;
import edu.fiuba.algo3.controllers.Visitors.Fases.Diurna.VisitantePantallaResultadoDia;
import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.vistas.Fases.Dia.*;

public class ControladorFaseDiurna {

    private final JuegoControlador juego;
    private final FaseDiurna fase;
    private int jugadorActual = 0;

    public ControladorFaseDiurna(JuegoControlador juego, FaseDiurna fase){

        this.juego = juego;
        this.fase = fase;
    }

    public void mostrarPantallaActual() {
        mostrarDebate();
    }

    public void mostrarDebate() {

        juego.mostrarPantalla(
                new PantallaDebate(
                        new ControladorDebate(this)
                )
        );
    }

    public void mostrarNominaciones() {

        juego.mostrarPantalla(
                new PantallaNominaciones(
                        new ControladorNominaciones(this)
                )
        );
    }

    public void mostrarVotacion() {

        reiniciarTurno();

        juego.mostrarPantalla(
                new PantallaVotacion(
                        new ControladorVotacion(this)
                )
        );
    }

    public void mostrarResultado(){

        VisitantePantallaResultadoDia visitante =
                new VisitantePantallaResultadoDia(juego);

        fase.resultado()
                .aceptarVisitante(visitante);

        juego.mostrarPantalla(
                visitante.pantalla()
        );
    }

    public void nominar(Jugador nominador, Jugador nominado){

        fase.nominar(nominador, nominado);
    }

    public void votar(Jugador votante, Jugador votado){

        fase.votar(votante, votado);
    }

    public void abstenerse(Jugador jugador){

        fase.abstenerse(jugador);
    }

    public void resolverVotacion(){

        fase.resolver(juego.estado());
    }

    public Jugadores jugadoresActivos() {

        return juego.jugadoresActivos();
    }

    public Jugador jugadorActual(){

        return jugadoresActivos().jugador(jugadorActual);
    }

    public void siguienteJugador(){

        jugadorActual++;
    }

    public boolean terminoTurnos(){

        return jugadorActual >= jugadoresActivos().cantidad();
    }

    public Jugadores candidatosNominados(){

        return fase.nominaciones().nominados();
    }

    public void reiniciarTurno(){

        jugadorActual = 0;
    }
}