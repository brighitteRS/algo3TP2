package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.FaseDiurna.HistorialDiurno;
import edu.fiuba.algo3.modelo.Partida.EstadoPartida;
import edu.fiuba.algo3.modelo.Votacion.ReglaDesempates.SinEliminacionPorEmpate;

public class FaseDiurnaNula extends FaseDiurna {

    public static final FaseDiurnaNula INSTANCIA =
            new FaseDiurnaNula();

    private FaseDiurnaNula(){
        super(new SinEliminacionPorEmpate(), new HistorialDiurno());
    }

    @Override
    public void resolver(EstadoPartida estado){
    }
}