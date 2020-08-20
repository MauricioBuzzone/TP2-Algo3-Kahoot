package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonUsarBonificadorEventHandler;
import edu.fiuba.algo3.modelo.Bonificador;

import edu.fiuba.algo3.modelo.Jugador;

import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;
import javafx.scene.text.Font;


public class ContenedorBonificadores extends HBox {

    private static final int ESPACIADO_BONIFICADORES = 5;
    private static final int TAMANIO_BONIFICADORES = 20;
    private static final int ANCHO = 58;
    private static final int ALTO = 14;

    private static final String X2 = "X2";
    private static final String X3 = "X3";


    public ContenedorBonificadores(ControladorRespuesta controlador, Jugador jugadorActivo){
        Bonificador bonificadorX2 = new Bonificador();
        bonificadorX2.cambiarFactorX2();
        Bonificador bonificadorX3 = new Bonificador();
        bonificadorX3.cambiarFactorX3();

        Button botonX2 = this.crearBoton(X2);
        Button botonX3 = this.crearBoton(X3);

        botonX2.setOnAction(new BotonUsarBonificadorEventHandler(jugadorActivo, controlador, bonificadorX2, botonX2, botonX3));
        if(!jugadorActivo.puedeUtilizarx2()) {
            botonX2.setDisable(true);
        }
        botonX3.setOnAction(new BotonUsarBonificadorEventHandler(jugadorActivo, controlador, bonificadorX3, botonX3, botonX2));
        if(!jugadorActivo.puedeUtilizarx3()) {
            botonX3.setDisable(true);
        }

        this.getChildren().addAll(botonX2, botonX3);
    }

    private Button crearBoton( String bonificador){
        Button boton = new Button(bonificador);
        boton.setFont(new Font(App.FUENTE, TAMANIO_BONIFICADORES));
        boton.setPrefSize(ANCHO,ALTO);
        boton.setStyle(StyleHandler.COLOR_BOTON_BLANCO);

        return boton;
    }
}