package edu.fiuba.algo3.modelo.Partida.CondicionesVictoria;

public class ContadorBandos {

    private int mafiosos = 0;
    private int ciudadanos = 0;

    public void agregarMafioso() {
        mafiosos++;
    }

    public void agregarCiudadano() {
        ciudadanos++;
    }

    public ResultadoVictoria resultado() {

        if (mafiosos == 0) {
            return new VictoriaCiudadanos();
        }

        if (mafiosos >= ciudadanos) {
            return new VictoriaMafia();
        }

        return new SinVictoria();
    }
}