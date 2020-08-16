package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


import javafx.scene.control.Button;


import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.control.ListView;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final int ANCHO_ESCENA = 400;
    private static final int LARGO_ESCENA = 350;

    public static Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("AlgoHoot - DEMO");
        Scene escenaDeElegirJugadores = this.crearEscenaElegirJugadores();
        stage.setScene(crearEscenaDeBienvenida(escenaDeElegirJugadores));
        stage.show();
    }

    private Scene crearEscenaDeBienvenida(Scene escenaDeElegirJugadores) {
        Label titulo = new Label("Bienvenido al más humilde y mejor kahoot de algoritmos III");
        Button botonElegirJugadores = new Button();
        botonElegirJugadores.setText("Ingresar jugadores");
        botonElegirJugadores.setOnAction(new BotonIngresarJugadoresEventHandler(this.stage, escenaDeElegirJugadores));
        VBox contenedorPrincipal = new VBox(titulo, botonElegirJugadores);
        contenedorPrincipal.setSpacing(30);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private Scene crearEscenaElegirJugadores(){

        ListView jugadoresInscriptos = new ListView();

        TextField cuadroParaIngresarNombres = new TextField();
        cuadroParaIngresarNombres.setPromptText("Ingrese el nombre del jugador");
        cuadroParaIngresarNombres.setOnKeyPressed(new EscribirSiguienteJugadorEventHandlerEnter(cuadroParaIngresarNombres,jugadoresInscriptos));


        Button botonSiguienteJugador = new Button();
        botonSiguienteJugador.setText("SiguienteJugador");
        botonSiguienteJugador.setOnAction(new EscribirSiguienteJugadorEventHandler(cuadroParaIngresarNombres, jugadoresInscriptos));

        Button botonComenzar = new Button();
        botonComenzar.setText("Comenzar");
        botonComenzar.setOnAction(new BotonComenzarEventHandler(jugadoresInscriptos, stage));

        HBox contenedorHorizontal = new HBox(botonSiguienteJugador, botonComenzar);
        contenedorHorizontal.setSpacing(10);

        VBox contenedorPrincipal = new VBox(cuadroParaIngresarNombres, contenedorHorizontal, jugadoresInscriptos);
        contenedorPrincipal.setSpacing(10);

        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);

    }

    public static void main(String[] args) {
        launch();
    }

}