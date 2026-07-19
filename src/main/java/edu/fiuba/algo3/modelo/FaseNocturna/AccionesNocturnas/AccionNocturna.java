package edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas;

import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;

public interface AccionNocturna {

    void registrarEn(HistorialNocturno historial);

    void actuar();
}