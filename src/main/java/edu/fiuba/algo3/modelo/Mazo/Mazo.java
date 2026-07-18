package edu.fiuba.algo3.modelo.Mazo;

import edu.fiuba.algo3.modelo.Excepciones.*;
import edu.fiuba.algo3.modelo.Jugador.Rol;

import java.util.ArrayList;
import java.util.List;

public class Mazo {

    private static final int MIN_JUGADORES = 5;
    private static final int MAX_JUGADORES = 12;

    private final List<Rol> cartas;

    public Mazo(List<Rol> cartas) {
        this.cartas = new ArrayList<>(cartas);
    }

    public Mazo(int cantJugadores) {

        if(cantJugadores < MIN_JUGADORES || cantJugadores > MAX_JUGADORES){
            throw new CantidadDeJugadoresInvalidaExcepcion();
        }

        EstrategiaDeComposicion estrategia = new FabricaDeComposicion().crear(cantJugadores);
        this.cartas = new ArrayList<>(estrategia.crear(cantJugadores));
    }

    public Rol repartirCarta() {

        if(cartas.isEmpty()){
            throw new MazoVacioExcepcion();
        }
        
        return cartas.remove(0);
    }

    public int cantidad(){return cartas.size();}

    public boolean estaVacio() {return cartas.isEmpty();}

    public void mezclar(Mezclador mezclador) {
        mezclador.mezclar(cartas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mazo otro = (Mazo) o;
        return cartas.equals(otro.cartas);
    }

    @Override
    public int hashCode() {
        return cartas.hashCode();
    }
}