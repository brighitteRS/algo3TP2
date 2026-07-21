package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Mazo.Aleatorio;
import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.*;

public class Partida {

    private final EstadoPartida estado;
    private final CondicionVictoria condicionVictoria;
    private final ResultadoPartida resultado;

    public Partida(EstadoPartida estado,
                   CondicionVictoria condicionVictoria) {

        this.estado = estado;
        this.condicionVictoria = condicionVictoria;
        this.resultado = new ResultadoPartida();
    }

    public void iniciar(Jugadores jugadores) {

        estado.inicializar(jugadores);
    }

    public void repartirRoles(){

        Mazo mazo = new Mazo(estado.jugadores().cantidad());

        mazo.mezclar(new Aleatorio());

        estado.jugadores().asignarRoles(mazo);

        estado.registrarJugadores();

    }

    public void reconocerMafia(){

        estado.mafia().reconocimientoInicial();
    }

    public void iniciarNoche(){

        estado.iniciarNoche();
    }

    public void iniciarDia(){

        estado.iniciarDia();
    }

    public void finalizarNoche(){

        verificarVictoria();

        if(!resultado.termino()){
           iniciarDia();
        }
    }

    public void finalizarDia(){

        verificarVictoria();

        if(!resultado.termino()){
            iniciarNoche();
        }
    }

    private void verificarVictoria() {

        ResultadoVictoria victoria = condicionVictoria.evaluar(estado);

        if(victoria.termino()){
            resultado.finalizar(victoria);
        }
    }

    public EstadoPartida estado() {
        return estado;
    }

    public ResultadoPartida resultado() {
        return resultado;
    }

    public CondicionVictoria condicionVictoria() {
        return condicionVictoria;
    }
}
