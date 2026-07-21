package edu.fiuba.algo3.modelo.NullPattern;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.Investigacion;

public class InvestigacionNula extends Investigacion {

    public static final InvestigacionNula INSTANCIA = new InvestigacionNula();

    private InvestigacionNula() {
        super(JugadorNulo.INSTANCIA, JugadorNulo.INSTANCIA);
    }

    @Override
    public void actuar() {
    }
}