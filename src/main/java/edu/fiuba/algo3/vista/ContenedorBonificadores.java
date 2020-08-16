package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonUsarBonificadorEventHandler;
import edu.fiuba.algo3.modelo.Bonificador;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;


public class ContenedorBonificadores extends VBox {

    private static final int ESPACIADO_BONIFICADORES = 15;
    private static final String X2 = "X2";
    private static final String X3 = "X3";


    public ContenedorBonificadores(ControladorRespuesta controlador){
        Bonificador bonificadorX2 = new Bonificador();
        bonificadorX2.cambiarFactorX2();
        Bonificador bonificadorX3 = new Bonificador();
        bonificadorX3.cambiarFactorX3();

        Button botonX2 = new Button();
        botonX2.setText(X2);
        Button botonX3 = new Button();
        botonX3.setText(X3);


        botonX2.setOnAction(new BotonUsarBonificadorEventHandler(controlador, bonificadorX2, botonX2, botonX3));
        botonX3.setOnAction(new BotonUsarBonificadorEventHandler(controlador, bonificadorX3, botonX3, botonX2));

        this.getChildren().addAll(botonX2, botonX3);
        this.setSpacing(ESPACIADO_BONIFICADORES);
    }
}