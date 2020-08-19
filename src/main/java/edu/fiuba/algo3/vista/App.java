package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;

import javafx.scene.control.Button;


import javafx.stage.FileChooser;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import javafx.geometry.Pos;

/**
 * JavaFX App
 */
public class App extends Application {

    public static final int ANCHO_ESCENA = 650;
    public static final int LARGO_ESCENA = 500;
    public static final String FUENTE = "Candara";
    private static final int TAMANIO_LETRA = 18;
    private static final int TAMANIO_LETRA_ARCHIVO = 12;
    private static final int TAMANIO_LETRA_TITULO = 28;

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
        Label titulo = new Label("ALGOHOOT III");
        titulo.setFont(new Font(FUENTE, TAMANIO_LETRA_TITULO));

        ReproduccionSonido musica = new ReproduccionSonido("kahootInicio.mp3");//a borrar
        musica.reproducir(); // a borrar

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos JSON", "*.json"));
        fileChooser.setInitialDirectory(new File("Kahoots"));

        Label labelArchivo = new Label("Kahoot default");
        labelArchivo.setFont(new Font(FUENTE, TAMANIO_LETRA_ARCHIVO));

        Button botonElegirArchivo = new Button("Seleccione el kahoot");
        botonElegirArchivo.setFont(new Font(FUENTE, TAMANIO_LETRA));
        botonElegirArchivo.setOnAction(e -> {
            File archivoSeleccionado = fileChooser.showOpenDialog(stage);
            if(archivoSeleccionado != null){
                String path = archivoSeleccionado.getPath();
                labelArchivo.setText(path);
            }
        });
        VBox seleccionDeKahoot = new VBox(botonElegirArchivo, labelArchivo);
        seleccionDeKahoot.setSpacing(5);
        seleccionDeKahoot.setAlignment(Pos.CENTER);

        Button botonElegirJugadores = new Button();
        botonElegirJugadores.setText("Ingresar jugadores");
        botonElegirJugadores.setFont(new Font(FUENTE, TAMANIO_LETRA));
        botonElegirJugadores.setOnAction(new BotonIngresarJugadoresEventHandler(this.stage, labelArchivo));
        VBox contenedorPrincipal = new VBox(titulo, seleccionDeKahoot, botonElegirJugadores);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    @Override
    public void stop(){
        System.exit(0);
    };
}