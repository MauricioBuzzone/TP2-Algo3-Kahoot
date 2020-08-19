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

    public ContenedorVerdaderoFalso(ControladorRespuesta controlador, String colorBoton){
        super();
        Button botonVerdadero = new Button();
        botonVerdadero.setText(VERDADERO);
        botonVerdadero.setPrefSize(ANCHO_BOTON_OPCION, ALTO_BOTON_OPCION);
        botonVerdadero.setFont(new Font(App.FUENTE, 20));
        botonVerdadero.setOnAction(new BotonOpcionUnicaEventHandler(controlador, VERDADERO));
        botonVerdadero.setStyle(colorBoton);

        Button botonFalso = new Button();
        botonFalso.setText(FALSO);
        botonFalso.setPrefSize(ANCHO_BOTON_OPCION, ALTO_BOTON_OPCION);
        botonFalso.setFont(new Font(App.FUENTE, 20));
        botonFalso.setOnAction(new BotonOpcionUnicaEventHandler(controlador, FALSO));
        botonFalso.setStyle(colorBoton);

        this.getChildren().addAll(botonVerdadero, botonFalso);
        this.setSpacing(ESPACIADO_BOTONES);
    }
}