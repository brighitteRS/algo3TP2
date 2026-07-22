package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorFaseDiurna;
import edu.fiuba.algo3.controllers.FaseNocturna.ControladorFaseNocturna;
import edu.fiuba.algo3.controllers.Visitors.Roles.*;
import edu.fiuba.algo3.modelo.Excepciones.CantidadDeJugadoresInvalidaExcepcion;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.CondicionVictoriaBando;
import edu.fiuba.algo3.vistas.*;
import edu.fiuba.algo3.vistas.Partida.PantallaFinal;

import java.util.ArrayList;
import java.util.List;

public class JuegoControlador {

    private final List<ObservadorJuego> observadores;
    private final GeneradorJugadores generador;

    private Partida partida;

    public JuegoControlador(){

        observadores = new ArrayList<>();
        generador = new GeneradorJugadores();
    }

    public void agregarObservador(ObservadorJuego observador){

        observadores.add(observador);
    }

    public void mostrarPantalla(Pantalla pantalla){

        for(ObservadorJuego observador: observadores){

            observador.mostrarPantalla(pantalla);
        }
    }

    public void notificar(String mensaje){

        for(ObservadorJuego observador: observadores){

            observador.actualizar(mensaje);
        }
    }

    public void notificarEstado(String estado){

        for(ObservadorJuego observador: observadores){

            observador.actualizarEstado(estado);
        }
    }

    public void iniciarPartida(int cantidad){

        try {

            Jugadores jugadores = generador.crear(cantidad);

            partida = new Partida(
                    new EstadoPartida(),
                    new CondicionVictoriaBando()
            );

            partida.iniciar(jugadores);
            partida.repartirRoles();

            notificarEstado("Reparto de roles");

            notificar("Partida iniciada");

            new ControladorRepartoRoles(this)
                    .mostrarPantalla();

        } catch(CantidadDeJugadoresInvalidaExcepcion e){

            notificar(e.getMessage());
        }
    }

    public CartaRolVista cartaJugador(int indice){

        VisitanteCarta visitante = new VisitanteCarta();

        partida.estado().jugadores()
                .jugador(indice)
                .aceptarVisitante(visitante);

        return visitante.carta();
    }

    public void mostrarReconocimiento(){

        notificarEstado("Reconocimiento de roles");

        new ControladorReconocimiento(this)
                .mostrarPantalla();
    }

    private void verificarVictoria(){

        if(partida.resultado().termino()){

            notificarEstado("Resumen de partida");

            ControladorResultadoPartida controladorResultado =
                    new ControladorResultadoPartida(partida);

            mostrarPantalla(
                    new PantallaFinal(
                            controladorResultado,
                            this
                    )
            );
        }
    }

    public void finalizarNoche(){

        partida.finalizarNoche();

        notificarEstado("Fase Nocturna");

        if(partida.resultado().termino()){

           verificarVictoria();

        } else {

            iniciarDia();
        }
    }

    public void finalizarDia(){

        partida.finalizarDia();

        notificarEstado("Fase Diurna");

        if(partida.resultado().termino()){

           verificarVictoria();

        } else {

            iniciarNoche();
        }
    }

    public void iniciarNoche(){

        partida.iniciarNoche();

        notificarEstado("Fase nocturna");

        new ControladorFaseNocturna(
                this,
                partida.estado().noche()
        ).mostrarTurnoActual();
    }

    public void iniciarDia(){

        partida.iniciarDia();

        notificarEstado("Fase diurna");

        new ControladorFaseDiurna(
                this,
                partida.estado().dia()
        ).mostrarPantallaActual();
    }

    public Jugadores jugadoresActivos(){

        return partida.estado().jugadoresVivos();
    }

    public Jugadores complicesJugador(int indice){

        return partida.estado()
                .jugadores()
                .jugador(indice)
                .complices();
    }

    public int cantidadJugadores(){

        return partida.estado()
                .jugadores()
                .cantidad();
    }

    public EstadoPartida estado(){

        return partida.estado();
    }

    public void reconocerMafia(){

        partida.reconocerMafia();
    }
}