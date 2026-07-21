package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeAtacarAMafiosoException;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.modelo.Votacion.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.*;

public class Mafia {

    private final Jugadores miembros;
    private final Urna urna;
    private final Votacion votacion;
    private ReglaDesempate reglaDesempate;

    public Mafia(){
        this(new SinEliminacionPorEmpate());
    }

    public Mafia(ReglaDesempate regla){

        miembros = new Jugadores();
        urna = new Urna();
        votacion = new Votacion(urna);
        reglaDesempate = regla;
    }

    public void agregar(Jugador jugador){
        miembros.agregar(jugador);
    }

    public void agregarPadrino(Jugador padrino) {

        agregar(padrino);
        reglaDesempate = new DecisionPorPadrino(padrino);
    }

    public void eliminarMiembro(Jugador jugador){
        miembros.eliminar(jugador);
    }

    public Jugador miembro(int indice){
        return miembros.jugador(indice);
    }

    public int cantidadMiembros(){
        return miembros.cantidad();
    }

    public void reconocimientoInicial(){

        for(Jugador mafioso : miembros.todos()){
            mafioso.recibirComplices(miembros);
        }
    }

    public void votar(Jugador mafioso, Jugador objetivo) {

        mafioso.validarPuedeActuar();
        objetivo.validarPuedeSerObjetivo();

        if (mafioso.esMiComplice(objetivo)) {
            throw new NoSePuedeAtacarAMafiosoException();
        }

        urna.registrar(new Voto(mafioso, objetivo));
    }

    public ResultadoVotacion resolverVotacion() {

        return votacion.resolver(reglaDesempate);
    }

    public AccionNocturna decidirAtaque(){

        return resolverVotacion().accion();
    }
}
