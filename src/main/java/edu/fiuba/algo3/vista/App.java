package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;



import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;

import javafx.scene.control.Button;

import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import java.io.IOException;
import java.io.FileInputStream;

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

    private ReproduccionSonido musica;
    public static Stage stage;
    private static final String RUTA_ARCHIVO_BACKGROUND = "resources/Backgrounds/Bienvenida.png";

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("AlgoHoot!");
        stage.getIcons().add(new Image("file:resources/AlgoHootIcon.png"));
        stage.setScene(crearEscenaDeBienvenida());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Scene crearEscenaDeBienvenida() {
        Label titulo = new Label("               ");
        titulo.setFont(new Font(FUENTE, TAMANIO_LETRA_TITULO));

        musica = new ReproduccionSonido("kahootInicio.mp3");
        musica.reproducir();

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos JSON", "*.json"));
        fileChooser.setInitialDirectory(new File("Kahoots"));

        Label labelArchivo = new Label("Kahoot default");
        labelArchivo.setFont(new Font(FUENTE, TAMANIO_LETRA_ARCHIVO));

        Button botonElegirArchivo = new Button("Seleccione el kahoot");
        botonElegirArchivo.setFont(Font.font(FUENTE, TAMANIO_LETRA));
        botonElegirArchivo.setStyle(TipoDePreguntaColorHandler.COLOR_BOTON_BLANCO);
        botonElegirArchivo.setOnAction(e -> {
            File archivoSeleccionado = fileChooser.showOpenDialog(stage);
            if(archivoSeleccionado != null){
                String path = archivoSeleccionado.getPath();
                int start = path.lastIndexOf("Kahoots");
                int end = path.length();
                path =  path.substring(start, end);
                labelArchivo.setText(path);
            }
        });
        VBox seleccionDeKahoot = new VBox(botonElegirArchivo, labelArchivo);
        seleccionDeKahoot.setSpacing(5);
        seleccionDeKahoot.setAlignment(Pos.CENTER);

        Button botonElegirJugadores = new Button();
        botonElegirJugadores.setText("Ingresar jugadores");
        botonElegirJugadores.setFont(Font.font(FUENTE, TAMANIO_LETRA));
        botonElegirJugadores.setStyle(TipoDePreguntaColorHandler.COLOR_BOTON_NEGRO);
        botonElegirJugadores.setOnAction(new BotonIngresarJugadoresEventHandler(this.stage, labelArchivo));
        VBox contenedorPrincipal = new VBox(titulo, seleccionDeKahoot, botonElegirJugadores);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setPadding(new Insets(25));
        try {
            FileInputStream input = new FileInputStream(RUTA_ARCHIVO_BACKGROUND);
            Image imagen = new Image(input);
            BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            contenedorPrincipal.setBackground(new Background(imagenDeFondo));
        }catch (IOException ex){
            // Comienza igual pero sin un background.
        }
        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    @Override
    public void stop(){
        System.exit(0);
    };
}