package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Partida.Jugadores;
import edu.fiuba.algo3.modelo.NullPattern.JugadorNulo;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.ReglaDesempate;

public class Votacion {

    private final Urna urna;

    public Votacion(Urna urna) {
        this.urna = urna;
    }

    public ResultadoVotacion resolver(ReglaDesempate regla) {

        Jugadores candidatos = obtenerCandidatos();

        ResultadoVotacion resultado;

        if (candidatos.estaVacio()) {

            resultado = new ResultadoEmpate();

        } else {

            Jugador ganador = encontrarGanador(candidatos);

            if (hayEmpate(candidatos, ganador)) {

                resultado = regla.resolver(this);

            } else {

                resultado = new ResultadoGanador(ganador);
            }
        }

        urna.limpiar();

        return resultado;
    }

    public Jugador votoDe(Jugador jugador) {

        for (Voto voto : urna.votos()) {

            if (voto.esDe(jugador)) {
                return voto.votado();
            }
        }

        return JugadorNulo.INSTANCIA;
    }

    private int contarVotos(Jugador jugador) {

        int cantidad = 0;

        for (Voto voto : urna.votos()) {

            if (voto.apuntaA(jugador)) {
                cantidad++;
            }
        }

        return cantidad;
    }

    private Jugadores obtenerCandidatos() {

        Jugadores candidatos = new Jugadores();

        for (Voto voto : urna.votos()) {

            if (!candidatos.contiene(voto.votado())) {
                candidatos.agregar(voto.votado());
            }
        }

        return candidatos;
    }

    private Jugador encontrarGanador(Jugadores candidatos) {

        Jugador ganador = JugadorNulo.INSTANCIA;

        int mayorCantidad = -1;

        for (Jugador candidato : candidatos.todos()) {

            int votos = contarVotos(candidato);


            if (votos > mayorCantidad) {

                ganador = candidato;
                mayorCantidad = votos;
            }
        }


        return ganador;
    }

    private boolean hayEmpate(Jugadores candidatos, Jugador ganador) {

        int votosGanador = contarVotos(ganador);

        int cantidadGanadores = 0;

        for (Jugador candidato : candidatos.todos()) {

            if (contarVotos(candidato) == votosGanador) {
                cantidadGanadores++;
            }
        }

        return cantidadGanadores > 1;
    }
}
