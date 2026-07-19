package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Mazo.Mazo;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.CondicionVictoria;
import edu.fiuba.algo3.modelo.Partida.CondicionesVictoria.ResultadoVictoria;

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

        Mazo mazo = new Mazo(jugadores.cantidad());

        estado.inicializar(jugadores);

        jugadores.asignarRoles(mazo);

        estado.registrarJugadores();

        estado.mafia().reconocimientoInicial();

        estado.iniciarNoche();
    }

    public void finalizarNoche(){

        estado.noche().resolver(estado);

        verificarVictoria();

        if(!resultado.termino()){
            estado.iniciarDia();
        }
    }

    public void finalizarDia(){

        estado.dia().resolver(estado);

        verificarVictoria();

        if(!resultado.termino()){
            estado.iniciarNoche();
        }
    }

    private void verificarVictoria() {

        ResultadoVictoria victoria = condicionVictoria.evaluar(estado);

        if(victoria.termino()){
            resultado.finalizar(victoria.ganador());
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
