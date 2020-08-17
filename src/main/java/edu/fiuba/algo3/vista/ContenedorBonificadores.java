package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonUsarBonificadorEventHandler;
import edu.fiuba.algo3.modelo.Bonificador;

import edu.fiuba.algo3.modelo.Jugador;

import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;


public class ContenedorBonificadores extends HBox {

    private static final int ESPACIADO_BONIFICADORES = 15;
    private static final String X2 = "X2";
    private static final String X3 = "X3";


    public ContenedorBonificadores(ControladorRespuesta controlador, Jugador jugadorActivo){
        Bonificador bonificadorX2 = new Bonificador();
        bonificadorX2.cambiarFactorX2();
        Bonificador bonificadorX3 = new Bonificador();
        bonificadorX3.cambiarFactorX3();

        Button botonX2 = new Button();
        botonX2.setText(X2);
        Button botonX3 = new Button();
        botonX3.setText(X3);


        botonX2.setOnAction(new BotonUsarBonificadorEventHandler(jugadorActivo, controlador, bonificadorX2, botonX2, botonX3));
        if(!jugadorActivo.puedeUtilizarx2()) {
            botonX2.setDisable(true);
        }
        botonX3.setOnAction(new BotonUsarBonificadorEventHandler(jugadorActivo, controlador, bonificadorX3, botonX3, botonX2));
        if(!jugadorActivo.puedeUtilizarx3()) {
            botonX3.setDisable(true);
        }

        this.getChildren().addAll(botonX2, botonX3);
        this.setSpacing(ESPACIADO_BONIFICADORES);
    }
}