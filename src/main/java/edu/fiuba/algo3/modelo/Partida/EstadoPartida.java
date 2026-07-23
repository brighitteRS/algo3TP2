package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Excepciones.JugadorMuertoException;
import edu.fiuba.algo3.modelo.FaseDiurna.*;
import edu.fiuba.algo3.modelo.FaseNocturna.*;
import edu.fiuba.algo3.modelo.FaseNocturna.Turnos.*;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mafia;
import edu.fiuba.algo3.modelo.NullPattern.*;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.*;

public class EstadoPartida {

    private Jugadores todos;
    private Jugadores vivos;
    private final Jugadores eliminados;

    private Mafia mafia;
    private final RolesEspeciales rolesEspeciales;

    private final HistorialPartida historialPartida;

    private FaseNocturna faseNocturna;
    private FaseDiurna faseDiurna;
    private Fase faseActual;

    public EstadoPartida(){

        todos = new Jugadores();
        vivos = new Jugadores();
        eliminados = new Jugadores();

        rolesEspeciales = new RolesEspeciales();
        mafia = new Mafia();

        historialPartida = new  HistorialPartida();

        faseNocturna = FaseNocturnaNula.INSTANCIA;
        faseDiurna = FaseDiurnaNula.INSTANCIA;
        faseActual = FaseNula.INSTANCIA;
    }

    public void inicializar(Jugadores jugadores){

        reiniciar();

        todos = new Jugadores(jugadores);
        vivos = new Jugadores(jugadores);
    }

    private void reiniciar(){

        rolesEspeciales.reiniciar();
        eliminados.vaciar();

        mafia = new Mafia();

        historialPartida.limpiar();

        faseNocturna = FaseNocturnaNula.INSTANCIA;
        faseDiurna = FaseDiurnaNula.INSTANCIA;
        faseActual = FaseNula.INSTANCIA;
    }

    public void registrarJugadores(){todos.registrarRoles(this);}

    public Jugadores jugadores(){return todos;}

    public Jugadores eliminados(){
        return eliminados;
    }

    public Jugadores jugadoresVivos(){
        return vivos;
    }

    public Mafia mafia(){
        return mafia;
    }

    public RolesEspeciales rolesEspeciales(){
        return rolesEspeciales;
    }

    public void eliminar(Jugador jugador){

        if(!vivos.contiene(jugador)){
            throw new JugadorMuertoException();
        }

        jugador.eliminar();

        vivos.eliminar(jugador);

        mafia.eliminarMiembro(jugador);

        rolesEspeciales.eliminar(jugador);

        eliminados.agregar(jugador);
    }

    private TurnoNocturno crearSecuenciaNocturna() {

        TurnoNocturno turno = new TurnoFinal();

        turno = rolesEspeciales.medico().agregarTurno(turno);
        turno = rolesEspeciales.detective().agregarTurno(turno);

        return new TurnoMafia(mafia, turno);
    }

    public void iniciarNoche() {

        HistorialNocturno historial =
                new HistorialNocturno();

        faseNocturna = new FaseNocturna(
                crearSecuenciaNocturna(),
                historial
        );

        faseActual = faseNocturna;
    }

    public void iniciarDia() {

        HistorialDiurno historial =
                new HistorialDiurno();

        faseDiurna = new FaseDiurna(
                new SinEliminacionPorEmpate(),
                historial
        );

        faseActual = faseDiurna;
    }

    public Fase faseActual() {return faseActual;}

    public FaseNocturna noche() {return faseNocturna;}

    public FaseDiurna dia() {return faseDiurna;}

    public HistorialPartida historialPartida() {return historialPartida;}
}
