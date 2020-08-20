package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.EscribirSiguienteJugadorEventHandler;
import edu.fiuba.algo3.controlador.BotonEliminarJugadoresEventHandler;
import edu.fiuba.algo3.controlador.EscribirSiguienteJugadorEventHandlerEnter;
import edu.fiuba.algo3.controlador.BotonComenzarEventHandler;


import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;


public class EscenaElegirJugadores extends Scene {

    private static final String RUTA_ARCHIVO_BACKGROUND = "resources/Backgrounds/Bienvenida.png";
    private static final String COLOR_BOTONES = "-fx-background-color: #ffffff; ";
    private static final int TAMANIO_LETRA = 18;

    public EscenaElegirJugadores(Stage stage, String rutaKahoot, VBox contenedorPrincipal) {
        super(contenedorPrincipal, App.ANCHO_ESCENA, App.LARGO_ESCENA);

        ListView jugadoresInscriptos = new ListView();
        jugadoresInscriptos.setStyle("    -fx-font-family: " + App.FUENTE + " ;\n" +
                                     "    -fx-font-size: 15pt;");

        TextField cuadroParaIngresarNombres = new TextField();
        cuadroParaIngresarNombres.setPromptText("Ingrese el nombre del jugador");
        cuadroParaIngresarNombres.setFont(new Font(App.FUENTE, TAMANIO_LETRA));
        cuadroParaIngresarNombres.setOnKeyPressed(new EscribirSiguienteJugadorEventHandlerEnter(cuadroParaIngresarNombres, jugadoresInscriptos));

        Button botonSiguienteJugador = this.crearBotonSiguienteJugador(cuadroParaIngresarNombres, jugadoresInscriptos);

        Button botonComenzar = this.crearBotonComenzar(jugadoresInscriptos, stage, rutaKahoot);

        Button botonEliminarJugadores = this.crearBotonEliminarJugadores(cuadroParaIngresarNombres, jugadoresInscriptos);

        HBox contenedorBotonesManipulacion = new HBox(botonSiguienteJugador, botonEliminarJugadores);
        contenedorBotonesManipulacion.setSpacing(5);
        contenedorBotonesManipulacion.setAlignment(Pos.CENTER_LEFT);

        HBox contenedorHorizontal = new HBox(contenedorBotonesManipulacion, botonComenzar);
        contenedorHorizontal.setSpacing(100);
        contenedorHorizontal.setAlignment(Pos.CENTER);

        contenedorPrincipal.getChildren().addAll(cuadroParaIngresarNombres, contenedorHorizontal, jugadoresInscriptos);
        contenedorPrincipal.setSpacing(10);
    }

    private Button crearBotonSiguienteJugador(TextField cuadroParaIngresarNombres, ListView jugadoresInscriptos) {

        Button botonSiguienteJugador = new Button();
        botonSiguienteJugador.setText("SiguienteJugador");
        botonSiguienteJugador.setFont(new Font(App.FUENTE, TAMANIO_LETRA));
        botonSiguienteJugador.setOnAction(new EscribirSiguienteJugadorEventHandler(cuadroParaIngresarNombres, jugadoresInscriptos));
        botonSiguienteJugador.setStyle(COLOR_BOTONES);
        return botonSiguienteJugador;
    }

    private Button crearBotonComenzar(ListView jugadoresInscriptos, Stage stage, String rutaKahoot) {

        Button botonComenzar = new Button();
        botonComenzar.setText("Comenzar");
        botonComenzar.setFont(new Font(App.FUENTE, TAMANIO_LETRA));
        botonComenzar.setOnAction(new BotonComenzarEventHandler(jugadoresInscriptos, stage, rutaKahoot));
        botonComenzar.setStyle(COLOR_BOTONES);
        return botonComenzar;
    }

    private Button crearBotonEliminarJugadores(TextField cuadroParaIngresarNombres, ListView jugadoresInscriptos){

        Button botonEliminarJugadores = new Button();
        botonEliminarJugadores.setText("Eliminar jugador");
        botonEliminarJugadores.setFont(new Font(App.FUENTE, TAMANIO_LETRA));
        botonEliminarJugadores.setOnAction(new BotonEliminarJugadoresEventHandler(cuadroParaIngresarNombres, jugadoresInscriptos));
        botonEliminarJugadores.setStyle(COLOR_BOTONES);
        return botonEliminarJugadores;
    }

}