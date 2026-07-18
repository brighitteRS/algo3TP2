package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.*;

public class Resolutor {

    public ResultadoNoche resolver(HistorialNocturno historial) {
        return historial.ataque().resolverCon(historial.proteccion());
    }
}