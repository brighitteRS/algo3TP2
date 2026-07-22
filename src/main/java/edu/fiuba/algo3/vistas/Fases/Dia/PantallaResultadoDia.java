package edu.fiuba.algo3.vistas.Fases.Dia;

import edu.fiuba.algo3.controllers.FaseDiurna.ControladorResultadoDia;
import edu.fiuba.algo3.vistas.Pantalla;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class PantallaResultadoDia extends Pantalla {

    public PantallaResultadoDia(ControladorResultadoDia controlador){

        Button continuar = new Button("Continuar");
        estiloBoton(continuar);

        continuar.setOnAction(e ->
                controlador.continuar()
        );

        setSpacing(20);
        setAlignment(Pos.CENTER);

        getChildren().addAll(
                controlador.resultadoVista(),
                continuar
        );
    }
}