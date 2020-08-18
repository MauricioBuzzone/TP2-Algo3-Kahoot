package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.EscribirSiguienteJugadorEventHandler;
import edu.fiuba.algo3.controlador.BotonEliminarJugadoresEventHandler;
import edu.fiuba.algo3.controlador.EscribirSiguienteJugadorEventHandlerEnter;
import edu.fiuba.algo3.controlador.BotonComenzarEventHandler;


import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;


public class EscenaElegirJugadores extends Scene {

    private static final int TAMANIO_LETRA = 18;

    public EscenaElegirJugadores(Stage stage, String rutaKahoot, VBox contenedorPrincipal) {
        super(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);

        ListView jugadoresInscriptos = new ListView();

        TextField cuadroParaIngresarNombres = new TextField();
        cuadroParaIngresarNombres.setPromptText("Ingrese el nombre del jugador");
        cuadroParaIngresarNombres.setFont(new Font(App.FUENTE, TAMANIO_LETRA));
        cuadroParaIngresarNombres.setOnKeyPressed(new EscribirSiguienteJugadorEventHandlerEnter(cuadroParaIngresarNombres, jugadoresInscriptos));

        Button botonSiguienteJugador = new Button();
        botonSiguienteJugador.setText("SiguienteJugador");
        botonSiguienteJugador.setFont(new Font(App.FUENTE, TAMANIO_LETRA));
        botonSiguienteJugador.setOnAction(new EscribirSiguienteJugadorEventHandler(cuadroParaIngresarNombres, jugadoresInscriptos));

        Button botonComenzar = new Button();
        botonComenzar.setText("Comenzar");
        botonComenzar.setFont(new Font(App.FUENTE, TAMANIO_LETRA));
        botonComenzar.setOnAction(new BotonComenzarEventHandler(jugadoresInscriptos, stage, rutaKahoot));

        Button botonEliminarJugadores = new Button();
        botonEliminarJugadores.setText("Eliminar jugador");
        botonEliminarJugadores.setFont(new Font(App.FUENTE, TAMANIO_LETRA));
        botonEliminarJugadores.setOnAction(new BotonEliminarJugadoresEventHandler(cuadroParaIngresarNombres, jugadoresInscriptos));

        HBox contenedorBotonesManipulacion = new HBox(botonSiguienteJugador, botonEliminarJugadores);
        contenedorBotonesManipulacion.setSpacing(5);
        contenedorBotonesManipulacion.setAlignment(Pos.CENTER_LEFT);

        HBox contenedorHorizontal = new HBox(contenedorBotonesManipulacion, botonComenzar);
        contenedorHorizontal.setSpacing(100);
        contenedorHorizontal.setAlignment(Pos.CENTER);

        contenedorPrincipal.getChildren().addAll(cuadroParaIngresarNombres, contenedorHorizontal, jugadoresInscriptos);
        contenedorPrincipal.setSpacing(10);
    }
}