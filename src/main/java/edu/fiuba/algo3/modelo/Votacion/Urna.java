package edu.fiuba.algo3.modelo.Votacion;

import java.util.ArrayList;
import java.util.List;

public class Urna {

    private final List<Voto> votos = new ArrayList<>();

    public void registrar(Voto voto) {
        votos.add(voto);
    }

    public List<Voto> votos() {
        return List.copyOf(votos);
    }

    public void limpiar() {
        votos.clear();
    }
}
