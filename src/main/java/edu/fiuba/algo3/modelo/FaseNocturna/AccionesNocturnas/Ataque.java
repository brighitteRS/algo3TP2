package edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas;

import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.AtaqueBloqueado;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.AtaqueExitoso;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.ResultadoNoche;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Ataque implements AccionNocturna {

    private final Jugador victima;

    public Ataque(Jugador objetivo) {
        this.victima = objetivo;
    }

    public ResultadoNoche resolverCon(Proteccion proteccion) {

        if (proteccion.protegeA(victima)) {
            return new AtaqueBloqueado();
        }

        return new AtaqueExitoso(victima);
    }

    @Override
    public void registrarEn(HistorialNocturno historial) {
        historial.registrarAtaque(this);
    }

    @Override
    public void actuar() {}
}