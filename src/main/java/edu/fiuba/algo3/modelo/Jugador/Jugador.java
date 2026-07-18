package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Excepciones.AccesoARolNoPermitidoExcepcion;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.RolNulo;

public class Jugador {

    private final int id;
    private Rol rol;
    private EstadoJugador estado;
    private Jugadores complices;

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
    }

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

    public void recibirComplices(Jugadores jugadores) {
        this.complices = new Jugadores(jugadores);
    }

    public boolean esMiComplice(Jugador jugador) {
        return complices.contiene(jugador);
    }

    public void registrarme(EstadoPartida estado) {
        rol.registrarme(estado, this);
    }

    public void validarPuedeSerObjetivo() {
        estado.validarPuedeSerObjetivo();
    }

    public void validarPuedeVotar() {
        estado.validarPuedeActuar();
    }

    public AccionNocturna actuarNoche(Jugador objetivo) {

        estado.validarPuedeActuar();
        return rol.actuarNoche(this, objetivo);
    }
}
