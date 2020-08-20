package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;



import javafx.application.Application;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;

import javafx.scene.control.Button;

import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
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
    public static Stage stage;

    private static final int TAMANIO_LETRA = 18;
    private static final int TAMANIO_LETRA_ARCHIVO = 12;
    private static final String RUTA_ARCHIVO_BACKGROUND = "resources/Backgrounds/Bienvenida.png";
    private static final String RUTA_ARCHIVO_ICONO = "resources/AlgoHootIcon.png";
    private static final String RUTA_ARCHIVO_LOGO = "resources/logo.png";

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("AlgoHoot!");
        stage.getIcons().add(new Image("file:" + RUTA_ARCHIVO_ICONO));
        stage.setResizable(false);
        stage.setScene(crearEscenaDeBienvenida());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop(){
        System.exit(0);
    }



    private Scene crearEscenaDeBienvenida() {

        Image logo = new Image("file:" + RUTA_ARCHIVO_LOGO, this.LARGO_ESCENA, this.ANCHO_ESCENA, true, true);
        ImageView imagenVista = new ImageView(logo);

        Label labelArchivo = new Label("Kahoot default");
        labelArchivo.setFont(new Font(FUENTE, TAMANIO_LETRA_ARCHIVO));

        Button botonElegirArchivo = this.crearBotonElegirArchivoCon(labelArchivo);

        VBox seleccionDeKahoot = new VBox(botonElegirArchivo, labelArchivo);
        seleccionDeKahoot.setSpacing(5);
        seleccionDeKahoot.setAlignment(Pos.CENTER);

        Button botonElegirJugadores = this.crearBotonElegirJugadores(labelArchivo);

        VBox contenedorPrincipal = this.crearContenedorPrincipal(imagenVista, seleccionDeKahoot, botonElegirJugadores);

        return new Scene(contenedorPrincipal, ANCHO_ESCENA, LARGO_ESCENA);
    }

    private VBox crearContenedorPrincipal(ImageView imagenVista,VBox seleccionDeKahoot,Button botonElegirJugadores){

        VBox contenedorPrincipal = new VBox(imagenVista, seleccionDeKahoot, botonElegirJugadores);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setPadding(new Insets(25));
        try {
            FileInputStream input = new FileInputStream(RUTA_ARCHIVO_BACKGROUND);
            Image imagen = new Image(input);
            BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            contenedorPrincipal.setBackground(new Background(imagenDeFondo));
        }catch (IOException ex) {
            // Comienza igual pero sin un background.
        }
        return contenedorPrincipal;
    }

    private Button crearBotonElegirArchivoCon(Label labelArchivo) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos JSON", "*.json"));
        fileChooser.setInitialDirectory(new File("Kahoots"));

        Button botonElegirArchivo = new Button("Seleccione el kahoot");
        botonElegirArchivo.setFont(Font.font(FUENTE, TAMANIO_LETRA));
        botonElegirArchivo.setStyle(StyleHandler.COLOR_BOTON_BLANCO);
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

        return botonElegirArchivo;
    }

    private Button crearBotonElegirJugadores(Label labelArchivo){

        Button botonElegirJugadores = new Button();
        botonElegirJugadores.setText("Ingresar jugadores");
        botonElegirJugadores.setFont(Font.font(FUENTE, TAMANIO_LETRA));
        botonElegirJugadores.setStyle(StyleHandler.COLOR_BOTON_NEGRO);
        botonElegirJugadores.setOnAction(new BotonIngresarJugadoresEventHandler(this.stage, labelArchivo));
        return botonElegirJugadores;
    }
}