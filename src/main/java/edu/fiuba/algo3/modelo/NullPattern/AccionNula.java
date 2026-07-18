package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;

public class AccionNula implements AccionNocturna {

    public static final AccionNocturna INSTANCIA = new AccionNula();

    private AccionNula() {
    }

    @Override
    public void registrarEn(HistorialNocturno estado) {
    }
}
