package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.*;

public class AtaqueNulo extends Ataque {

    public static final AtaqueNulo INSTANCIA = new AtaqueNulo();

    private AtaqueNulo() {
        super(JugadorNulo.INSTANCIA);
    }

    @Override
    public ResultadoNoche resolverCon(Proteccion proteccion) {
        return new SinAtaque();
    }

    @Override
    public void registrarEn(HistorialNocturno historial) {
    }
}
