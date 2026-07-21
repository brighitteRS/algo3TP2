package edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas;

import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Proteccion implements AccionNocturna {

    private final Jugador protegido;

    public Proteccion(Jugador protegido) {
        this.protegido = protegido;
    }

    public boolean protegeA(Jugador jugador) {
        return protegido.equals(jugador);
    }

    public Jugador protegido(){

        return protegido;
    }

    @Override
    public void registrarEn(HistorialNocturno historial) {
        historial.registrarProteccion(this);
    }

    @Override
    public void actuar() {}
}
