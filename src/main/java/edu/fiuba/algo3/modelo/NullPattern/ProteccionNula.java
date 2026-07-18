package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.Proteccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class ProteccionNula extends Proteccion {

    public static final ProteccionNula INSTANCIA = new ProteccionNula();

    private ProteccionNula() {
        super(JugadorNulo.INSTANCIA);
    }

    @Override
    public boolean protegeA(Jugador jugador) {
        return false;
    }
}
