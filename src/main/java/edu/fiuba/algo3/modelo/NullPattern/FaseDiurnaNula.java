package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.FaseDiurna.*;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;

public class FaseDiurnaNula extends FaseDiurna {

    public static final FaseDiurnaNula INSTANCIA = new FaseDiurnaNula();

    private FaseDiurnaNula(){
    }

    @Override
    public void resolver(EstadoPartida estado){
    }
}