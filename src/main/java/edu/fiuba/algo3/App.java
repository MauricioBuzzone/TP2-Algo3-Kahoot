package edu.fiuba.algo3;

import edu.fiuba.algo3.*;


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


/*
 Interface java.util.Observer
 void update (Observable o, Object data)
 */


/*
|===================================================================================================|
|   TODO: Hacer la bienvenida al kahoot.                              [Check] Tomados de la mano    |
|===================================================================================================|
|   TODO: Asociar controlador de inicio al botón de comenzar.         [     ] Tomados de la mano    |
|===================================================================================================|
|   TODO: Crear la vistaKahoot Mockeando el Kahoot                            Tomados de la mano    |
|   TODO: Crear la vistaTabla  Mockeando la Tabla                             Lukas // Santi        |
|   TODO: Crear la vistaRonda  Mockeando la Ronda                             Lukas // Santi        |
|===================================================================================================|
|   TODO: Crear controlador del timer                                         Santi                 |
|===================================================================================================|
|   TODO: Crear escena de pregunta común.                                     Tomados de la mano    |
|   TODO: Crear escena de pregunta ordered.                                   Lukas // Santi        |
|   TODO: Crear escena de pregunta choice.                                    Lukas // Santi        |
|===================================================================================================|
|   TODO: Relax                                                               Con el duko           |
|===================================================================================================|
*/
public class App extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Kajú kajú na na na naaa...");


        Scene escenaDeElegirJugadores = crearEscenaElegirJugadores();
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
        botonComenzar.setOnAction(new BotonComenzarEventHandler());

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