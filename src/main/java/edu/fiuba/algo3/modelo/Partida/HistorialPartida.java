package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.FaseDiurna.HistorialDiurno;
import edu.fiuba.algo3.modelo.FaseNocturna.HistorialNocturno;

import java.util.ArrayList;
import java.util.List;

public class HistorialPartida {

    private final List<HistorialNocturno> historialNocturno = new ArrayList<>();
    private final List<HistorialDiurno> historialDiurno = new ArrayList<>();

    public void registrarHistorialNocturno(HistorialNocturno historial) {
        this.historialNocturno.add(historial);
    }

    public void registrarHistorialDiurno(HistorialDiurno historial) {
        this.historialDiurno.add(historial);
    }

    public List<HistorialNocturno> historialNoches(){

        return historialNocturno;
    }

    public List<HistorialDiurno> historialDias(){

        return historialDiurno;
    }

    public void limpiar(){

        historialNocturno.clear();
        historialDiurno.clear();
    }
}
