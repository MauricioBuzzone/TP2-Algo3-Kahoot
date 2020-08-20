package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonOpcionUnicaEventHandler;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;
import javafx.scene.text.Font;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class ContenedorVerdaderoFalso extends VBox{

    private static final int ESPACIADO_BOTONES = 15;
    private static final String VERDADERO = "Verdadero";
    private static final String FALSO = "Falso";
    private static final String PATH_IMAGENES_BOTONES = "resources/BotonVerdaderoFalso/";
    private static final String NOMBRE_IMAGENES_PRIMERA_PARTE = "IMG_BOTON_VF_";
    private static final String EXTENSION_IMAGENES = ".png";
    private static final int ANCHO_BOTON_OPCION = 270;
    private static final int ALTO_BOTON_OPCION = 40;
    private static final int TAMANIO_FONT_BOTON = 20;

    public ContenedorVerdaderoFalso(ControladorRespuesta controlador, String colorBoton){
        super();

        Button botonVerdadero = this.crearBoton(VERDADERO, colorBoton, controlador);
        Button botonFalso = this.crearBoton(FALSO, colorBoton, controlador);

        this.getChildren().addAll(botonVerdadero, botonFalso);
        this.setSpacing(ESPACIADO_BOTONES);
    }

    private Button crearBoton(String descripcion, String colorBoton, ControladorRespuesta controlador ){
        Button boton = new Button(descripcion);
        boton.setPrefSize(ANCHO_BOTON_OPCION, ALTO_BOTON_OPCION);
        boton.setFont(new Font(App.FUENTE, TAMANIO_FONT_BOTON));
        boton.setOnAction(new BotonOpcionUnicaEventHandler(controlador, descripcion));
        boton.setStyle(colorBoton);

        return boton;
    }
}