package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.FaseNocturna.ResultadoNocturno.*;

public class FaseNocturna {

    private final HistorialNocturno historial = new HistorialNocturno();
    private final Resolutor resolutor = new Resolutor();

    public void registrar(AccionNocturna accion) {
        accion.registrarEn(historial);
    }

    public void resolver(EstadoPartida estado) {

        ResultadoNoche resultado = resolutor.resolver(historial);

        resultado.aplicar(estado);

        historial.limpiar();
    }
}
