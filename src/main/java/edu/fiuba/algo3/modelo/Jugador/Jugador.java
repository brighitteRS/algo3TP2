package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Visitors.VisitanteRol;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.TurnoNocturno;
import edu.fiuba.algo3.modelo.Jugador.Bando.Bando;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ContadorBandos;
import edu.fiuba.algo3.modelo.Partida.*;
import edu.fiuba.algo3.modelo.Excepciones.AccesoARolNoPermitidoExcepcion;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;

public class Jugador {

    private final int id;
    private Rol rol;
    private EstadoJugador estado;
    private Jugadores complices;
    private final HistorialEleccionesJugador historial;

    public Jugador() {
        this(0, RolNulo.INSTANCIA);
    }

    public Jugador(int id) {
        this(id, RolNulo.INSTANCIA);
    }

    public Jugador(int id, Rol rol) {

        this.id = id;
        this.rol = rol;
        this.estado = new Vivo();
        this.complices = new Jugadores();
        this.historial = new HistorialEleccionesJugador();
    }

    public int id(){return id;}

    public void eliminar() {
        estado = estado.morir();
    }

    public void estaVivo() {estado.estaVivo();}

    public void recibirRol(Rol rol) {
        this.rol = rol;
    }

    public Rol verRol(Jugador solicitante) {

        if (this != solicitante) {
            throw new AccesoARolNoPermitidoExcepcion();
        }

        return rol;
    }

    public Rol cartaRevelada() {return estado.revelarCarta(rol);}

    public void recibirComplices(Jugadores jugadores) {
        this.complices = new Jugadores(jugadores);
    }

    public boolean esMiComplice(Jugador jugador) {
        return complices.contiene(jugador);
    }

    public void registrarme(EstadoPartida estado) {
        rol.registrarme(estado, this);
    }

    public TurnoNocturno agregarTurno(TurnoNocturno siguiente) {
        return rol.agregarTurno(this, siguiente);
    }

    public void validarPuedeSerObjetivo() {
        estado.validarPuedeSerObjetivo();
    }

    public void validarPuedeActuar() {
        estado.validarPuedeActuar();
    }

    public AccionNocturna actuarNoche(Jugador objetivo) {

        objetivo.validarPuedeSerObjetivo();
        estado.validarPuedeActuar();

        return rol.actuarNoche(this,objetivo);
    }

    public void recibirResultadoInvestigacion(Bando bando){

        estado.validarPuedeActuar();
        rol.recibirResultadoInvestigacion(bando);
    }

    public Bando obtenerResultadoInvestigacion() {
        return rol.resultadoInvestigacion();
    }

    public Bando bandoVisibleParaInvestigacion() {
        return rol.bandoInvestigacion();
    }

    public void validarEleccion(Jugador objetivo){
        historial.validarRepeticion(objetivo);
    }

    public void registrarEleccion(Jugador objetivo){
        historial.registrarObjetivo(objetivo);
    }

    public void contabilizarEn(ContadorBandos contador) {rol.contabilizar(contador);}

    public void aceptarVisitante(VisitanteRol visitante){rol.aceptar(visitante);}

    public Jugadores complices(){return complices;}
}
