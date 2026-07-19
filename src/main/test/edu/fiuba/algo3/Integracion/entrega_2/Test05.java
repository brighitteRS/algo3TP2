package edu.fiuba.algo3.Integracion.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.JugadorMuertoNoPuedeSerObjetivoException;
import edu.fiuba.algo3.modelo.FaseDiurna.FaseDiurna;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Roles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test05 {

    @Test
    public void verificarQueLasNominacionesEnFaseDiurnaSoloIncluyanJugadoresVivos() {

        Jugador vivo = new Jugador(1,new Ciudadano());

        Jugador muerto = new Jugador(2,new Mafioso());

        muerto.eliminar();

        FaseDiurna fase = new FaseDiurna();

        assertThrows(JugadorMuertoNoPuedeSerObjetivoException.class, () -> fase.nominar(vivo,muerto));
    }

}
