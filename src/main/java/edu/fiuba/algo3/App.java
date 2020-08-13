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


/*
 Interface java.util.Observer
 void update (Observable o, Object data)
 */


/*
|===================================================================================================|
|   TODO: Hacer la bienvenida al kahoot.                              [Check] Tomados de la mano    |
|===================================================================================================|
|   TODO: Asociar controlador de inicio al botón de comenzar.         [Check] Tomados de la mano    |
|===================================================================================================|
|   TODO: Crear la vistaKahoot Mockeando el Kahoot                    [Check] Tomados de la mano    |
|   TODO: Crear la vistaTabla  Mockeando la Tabla                     [Check] Lukas // Santi        |
|   TODO: Crear la vistaRonda  Mockeando la Ronda                     [Check] Lukas // Santi        |
|===================================================================================================|
|   TODO: Crear controlador del timer                                 [Check] Santi                 |
|===================================================================================================|
|   TODO: Crear escena de pregunta común.                             [Check] Tomados de la mano    |
|   TODO: Crear escena de pregunta ordered.                           [Check] Lukas // Santi        |
|   TODO: Crear escena de pregunta choice.                            [Check] Lukas // Santi        |
|===================================================================================================|
|   TODO: Relax                                                       [Check] Con el duko           |
|===================================================================================================|
*/
public class App extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Kajú kajú na na na naaa...");


        String enunciado = "Situar cronologicamente";

        Opcion opcion1 = new OpcionOrdenada("Gallina", 2);
        Opcion opcion2 = new OpcionOrdenada("Huevo", 1);
        Opcion opcion3 = new OpcionOrdenada("El Trex papá", 3);

        List<Opcion> opciones = new ArrayList<Opcion>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        VistaPreguntaOrderedChoice vistaOC = new VistaPreguntaOrderedChoice(enunciado, opciones);
        stage.setScene(vistaOC.crearEscena());
        //Scene escenaDeElegirJugadores = crearEscenaElegirJugadores(escenaDePreguntaOrderedChoice);
        //stage.setScene(crearEscenaDeBienvenida(escenaDeElegirJugadores));
        //stage.setScene(escenaDePreguntaOrderedChoice);
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