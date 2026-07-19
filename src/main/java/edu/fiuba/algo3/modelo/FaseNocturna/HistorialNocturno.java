package edu.fiuba.algo3.modelo.FaseNocturna;

import edu.fiuba.algo3.modelo.FaseNocturna.AccionesNocturnas.*;
import edu.fiuba.algo3.modelo.NullPattern.*;

public class HistorialNocturno {

    private Ataque ataque = AtaqueNulo.INSTANCIA;
    private Proteccion proteccion = ProteccionNula.INSTANCIA;
    private Investigacion investigacion = InvestigacionNula.INSTANCIA;

    public void registrarAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public void registrarProteccion(Proteccion proteccion) {
        this.proteccion = proteccion;
    }

    public void registrarInvestigacion(Investigacion investigacion) {
        this.investigacion = investigacion;
    }

    public Ataque ataque() {
        return ataque;
    }

    public Proteccion proteccion() {
        return proteccion;
    }

    public void limpiar() {
        ataque = AtaqueNulo.INSTANCIA;
        proteccion = ProteccionNula.INSTANCIA;
        investigacion = InvestigacionNula.INSTANCIA;
    }
}