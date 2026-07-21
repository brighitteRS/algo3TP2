package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorFaseDiurna;
import edu.fiuba.algo3.controllers.FaseNocturna.ControladorFaseNocturna;
import edu.fiuba.algo3.controllers.Visitors.Roles.CartaRolVista;
import edu.fiuba.algo3.controllers.Visitors.Roles.VisitanteCarta;
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
    private Jugadores jugadores;

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

    public void iniciarPartida(int cantidad){

        try {

            jugadores = generador.crear(cantidad);

            partida = new Partida(
                    new EstadoPartida(),
                    new CondicionVictoriaBando()
            );

            partida.iniciar(jugadores);
            partida.repartirRoles();

            notificar("Partida iniciada");

            new ControladorRepartoRoles(this)
                    .mostrarPantalla();

        }catch(CantidadDeJugadoresInvalidaExcepcion e){

            notificar(e.getMessage());
        }
    }

    public CartaRolVista cartaJugador(int indice){

        VisitanteCarta visitante = new VisitanteCarta();

        jugadores
                .jugador(indice)
                .aceptarVisitante(visitante);

        return visitante.carta();
    }

    public void mostrarReconocimiento(){

        new ControladorReconocimiento(this)
                .mostrarPantalla();
    }

    private void verificarVictoria(){

        if(partida.resultado().termino()){
            mostrarPantalla(
                    new PantallaFinal(
                            new ControladorResultadoPartida(partida)
                    )
            );
        }
    }

    public void finalizarNoche(){

        partida.finalizarNoche();

        if(partida.resultado().termino()){

           verificarVictoria();
        } else {

            iniciarDia();
        }
    }

    public void finalizarDia(){

        partida.finalizarDia();

        if(partida.resultado().termino()){

           verificarVictoria();
        } else {

            iniciarNoche();
        }
    }

    public void iniciarNoche(){

        partida.iniciarNoche();

        new ControladorFaseNocturna(
                this,
                partida.estado().noche()
        ).mostrarTurnoActual();
    }

    public void iniciarDia(){

        partida.iniciarDia();

        new ControladorFaseDiurna(
                this,
                partida.estado().dia()
        ).mostrarPantallaActual();
    }

    public Jugadores jugadoresActivos(){

        return partida.estado().jugadoresVivos();
    }

    public Jugadores complicesJugador(int indice){

        return jugadores.jugador(indice).complices();
    }

    public int cantidadJugadores(){

        return jugadores.cantidad();
    }

    public EstadoPartida estado(){

        return partida.estado();
    }

    public void reconocerMafia(){

        partida.reconocerMafia();
    }
}