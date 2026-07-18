package edu.fiuba.algo3.modelo.Votacion;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.AccionNocturna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.NullPattern.*;

public class ResultadoEmpate extends ResultadoVotacion {

    @Override
    public Jugador ganador(){
        return JugadorNulo.INSTANCIA;
    }

    @Override
    public AccionNocturna ataque() {
        return AtaqueNulo.INSTANCIA;
    }
}