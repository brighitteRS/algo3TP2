package edu.fiuba.algo3.modelo.FaseDiurna;

import edu.fiuba.algo3.modelo.Votacion.Nominaciones.*;
import edu.fiuba.algo3.modelo.Votacion.*;

import java.util.ArrayList;
import java.util.List;

public class HistorialDiurno {

    private final List<Nominacion> nominaciones =
            new ArrayList<>();

    private final List<Voto> votos =
            new ArrayList<>();

    private final List<Abstencion> abstenciones =
            new ArrayList<>();


    public void registrarNominacion(Nominacion nominacion){
        nominaciones.add(nominacion);
    }

    public void registrarVoto(Voto voto){
        votos.add(voto);
    }

    public void registrarAbstencion(Abstencion abstencion){
        abstenciones.add(abstencion);
    }

    public void limpiar(){
        nominaciones.clear();
        votos.clear();
        abstenciones.clear();
    }
}
