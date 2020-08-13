package edu.fiuba.algo3;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.modelo.*;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.scene.control.Button;
import javafx.event.EventHandler;


import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

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
        return new Scene(contenedorPrincipal, 300, 250);
    }

    private Scene crearEscenaElegirJugadores(){

        ListView jugadoresInscriptos = new ListView();

        TextField cuadroParaIngresarNombres = new TextField();
        cuadroParaIngresarNombres.setPromptText("Ingrese el nombre del jugador");

        Button botonSiguienteJugador = new Button();
        botonSiguienteJugador.setText("SiguienteJugador");
        botonSiguienteJugador.setOnAction(new BotonSiguienteEventHandler(cuadroParaIngresarNombres, jugadoresInscriptos));

        Button botonComenzar = new Button();
        botonComenzar.setText("Comenzar");
        botonComenzar.setOnAction(new BotonComenzarEventHandler(jugadoresInscriptos, stage));

        HBox contenedorHorizontal = new HBox(botonSiguienteJugador, botonComenzar);
        contenedorHorizontal.setSpacing(10);

        VBox contenedorPrincipal = new VBox(cuadroParaIngresarNombres, contenedorHorizontal, jugadoresInscriptos);
        contenedorPrincipal.setSpacing(10);

        return new Scene(contenedorPrincipal, 300, 250);

    }

    public static void main(String[] args) {
        launch();
    }

}