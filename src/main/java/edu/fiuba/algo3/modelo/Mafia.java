package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeAtacarAMafiosoException;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.modelo.Votacion.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.ReglaDesempate;

public class Mafia {

    private final Jugadores miembros;
    private final Urna urna;
    private final Votacion votacion;

    public Mafia(){

        miembros = new Jugadores();
        urna = new Urna();
        votacion = new Votacion(urna);
    }

    public void agregar(Jugador jugador){

        miembros.agregar(jugador);
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

    public ResultadoVotacion resolverVotacion(ReglaDesempate regla) {
        return votacion.resolver(regla);
    }

    public AccionNocturna decidirAtaque(ReglaDesempate regla){

        Jugador victima = resolverVotacion(regla).ganador();

        return new Ataque(victima);
    }
}
