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
    private static final String NOMBRE_IMAGENES_PRIMERA_PARTE = "IMG_BOTON_MC_";
    private static final String EXTENSION_IMAGENES = ".png";

    public ContenedorVerdaderoFalso(ControladorRespuesta controlador){
        super();
        Button botonVerdadero = new Button();
        botonVerdadero.setText(VERDADERO);
        botonVerdadero.setFont(new Font(App.FUENTE, 20));
        botonVerdadero.setOnAction(new BotonOpcionUnicaEventHandler(controlador, VERDADERO));
        FileInputStream input1 = null;
        try {
            input1 = new FileInputStream(PATH_IMAGENES_BOTONES + NOMBRE_IMAGENES_PRIMERA_PARTE + "1" + EXTENSION_IMAGENES);
        }catch(IOException ex){

        }
        Image  imagenBoton1 = new Image(input1);
        ImageView imageView1 = new ImageView(imagenBoton1);
        botonVerdadero.setGraphic(imageView1);

        Button botonFalso = new Button();
        botonFalso.setText(FALSO);
        botonFalso.setFont(new Font(App.FUENTE, 20));
        botonFalso.setOnAction(new BotonOpcionUnicaEventHandler(controlador, FALSO));
        FileInputStream input2 = null;
        try {
            input2 = new FileInputStream(PATH_IMAGENES_BOTONES + NOMBRE_IMAGENES_PRIMERA_PARTE + "2" + EXTENSION_IMAGENES);
        }catch(IOException ex){

        }
        Image imagenBoton2 = new Image(input2);
        ImageView imageView2 = new ImageView(imagenBoton2);
        botonFalso.setGraphic(imageView2);


        this.getChildren().addAll(botonVerdadero, botonFalso);
        this.setSpacing(ESPACIADO_BOTONES);
    }
}