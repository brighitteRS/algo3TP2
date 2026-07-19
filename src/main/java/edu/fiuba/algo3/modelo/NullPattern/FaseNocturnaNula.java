package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.FaseNocturna.FaseNocturna;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public class FaseNocturnaNula extends FaseNocturna {

    public static final FaseNocturnaNula INSTANCIA =
            new FaseNocturnaNula();

    private FaseNocturnaNula(){
    }

    @Override
    public void resolver(EstadoPartida estado){
    }
}