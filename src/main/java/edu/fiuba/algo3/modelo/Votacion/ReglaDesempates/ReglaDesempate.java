package edu.fiuba.algo3.modelo.Votacion.ReglaDesempates;

import edu.fiuba.algo3.modelo.Votacion.*;

public interface ReglaDesempate {

    ResultadoVotacion resolver(Votacion votacion);
}
