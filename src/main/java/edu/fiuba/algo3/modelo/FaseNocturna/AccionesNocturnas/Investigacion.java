package edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas;

import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Investigacion implements AccionNocturna {

    private final Jugador detective;
    private final Jugador investigado;

    public Investigacion(Jugador detective, Jugador investigado) {
        this.detective = detective;
        this.investigado = investigado;
    }

    @Override
    public void actuar(){
        detective.recibirResultadoInvestigacion(investigado.bandoVisibleParaInvestigacion());
    }

    @Override
    public void registrarEn(HistorialNocturno historial) {
        historial.registrarInvestigacion(this);
    }
}
