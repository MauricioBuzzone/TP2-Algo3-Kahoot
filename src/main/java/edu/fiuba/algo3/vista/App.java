package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.vista.EscenaElegirJugadores;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;

import javafx.scene.control.Button;


import javafx.stage.FileChooser;
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
        stage.setScene(crearEscenaDeBienvenida());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Scene crearEscenaDeBienvenida() {
        Label titulo = new Label("Bienvenido al más humilde y mejor kahoot de algoritmos III");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos JSON", "*.json"));
        fileChooser.setInitialDirectory(new File("Kahoots"));

        Label labelArchivo = new Label("Kahoot default");

        Button botonElegirArchivo = new Button("Seleccione el kahoot");
        botonElegirArchivo.setOnAction(e -> {
            File archivoSeleccionado = fileChooser.showOpenDialog(stage);
            String path = archivoSeleccionado.getPath();
            labelArchivo.setText(path);
        });
        Button botonElegirJugadores = new Button();
        botonElegirJugadores.setText("Ingresar jugadores");
        botonElegirJugadores.setOnAction(new BotonIngresarJugadoresEventHandler(this.stage, labelArchivo));
        VBox contenedorPrincipal = new VBox(titulo, botonElegirArchivo, labelArchivo, botonElegirJugadores);
        contenedorPrincipal.setSpacing(30);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    @Override
    public void stop(){
        System.exit(0);
    };
}