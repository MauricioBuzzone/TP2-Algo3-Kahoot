package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonOpcionUnicaEventHandler;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;


public class ContenedorVerdaderoFalso extends VBox{

    private static final int ESPACIADO_BOTONES = 15;
    private static final String VERDADERO = "Verdadero";
    private static final String FALSO = "Falso";

    public ContenedorVerdaderoFalso(ControladorRespuesta controlador){
        super();
        Button botonVerdadero = new Button();
        botonVerdadero.setText(VERDADERO);
        botonVerdadero.setOnAction(new BotonOpcionUnicaEventHandler(controlador, VERDADERO));

        Button botonFalso = new Button();
        botonFalso.setText(FALSO);
        botonFalso.setOnAction(new BotonOpcionUnicaEventHandler(controlador, FALSO));

        this.getChildren().addAll(botonVerdadero, botonFalso);
        this.setSpacing(ESPACIADO_BOTONES);
    }
}