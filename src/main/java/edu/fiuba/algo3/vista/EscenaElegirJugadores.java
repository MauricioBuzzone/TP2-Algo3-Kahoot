package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.EscribirSiguienteJugadorEventHandler;
import edu.fiuba.algo3.controlador.EscribirSiguienteJugadorEventHandlerEnter;
import edu.fiuba.algo3.controlador.BotonComenzarEventHandler;


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class EscenaElegirJugadores extends Scene {

    private static final int ANCHO_ESCENA = 400;
    private static final int LARGO_ESCENA = 400;

    public EscenaElegirJugadores(Stage stage, String rutaKahoot, VBox contenedorPrincipal) {
        super(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);

        ListView jugadoresInscriptos = new ListView();

        TextField cuadroParaIngresarNombres = new TextField();
        cuadroParaIngresarNombres.setPromptText("Ingrese el nombre del jugador");
        cuadroParaIngresarNombres.setOnKeyPressed(new EscribirSiguienteJugadorEventHandlerEnter(cuadroParaIngresarNombres, jugadoresInscriptos));

        Button botonSiguienteJugador = new Button();
        botonSiguienteJugador.setText("SiguienteJugador");
        botonSiguienteJugador.setOnAction(new EscribirSiguienteJugadorEventHandler(cuadroParaIngresarNombres, jugadoresInscriptos));

        Button botonComenzar = new Button();
        botonComenzar.setText("Comenzar");
        botonComenzar.setOnAction(new BotonComenzarEventHandler(jugadoresInscriptos, stage, rutaKahoot));

        HBox contenedorHorizontal = new HBox(botonSiguienteJugador, botonComenzar);
        contenedorHorizontal.setSpacing(10);

        contenedorPrincipal.getChildren().addAll(cuadroParaIngresarNombres, contenedorHorizontal, jugadoresInscriptos);
        contenedorPrincipal.setSpacing(10);
    }
}