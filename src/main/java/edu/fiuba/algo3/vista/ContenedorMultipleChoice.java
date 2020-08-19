package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.controlador.BotonOpcionComunEventHandler;
import edu.fiuba.algo3.controlador.BotonReiniciarOpcionesEventHandler;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import java.io.FileInputStream;
import javafx.scene.text.Font;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;



import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class ContenedorMultipleChoice extends VBox{
    private static final int ESPACIADO_BOTONES = 15;
    private static final String REINICIAR = "Reiniciar";
    private static final String PATH_IMAGENES_BOTONES = "resources/BotonMultipleChoice/";
    private static final String NOMBRE_IMAGENES_PRIMERA_PARTE = "IMG_BOTON_MC_";
    private static final String EXTENSION_IMAGENES = ".png";
    private static final int ESPACIO_ENTRE_BOTONES_Y_REINICIAR = 40;
    private static final int ANCHO_BOTON_REINICIAR = 150;
    private static final int ALTO_BOTON_REINICIAR = 30;
    private static final int ANCHO_BOTON_OPCION = 270;
    private static final int ALTO_BOTON_OPCION = 35;

    public ContenedorMultipleChoice(ControladorRespuesta controlador, List<Opcion> opciones, String colorBoton){
        super();
        List<Button> botones = new ArrayList<Button>();
        List<String> descripciones = this.descripcionesDeOpciones(opciones);


        Integer contadorDescripciones = 0;
        for(String descripcion : descripciones){
            contadorDescripciones = contadorDescripciones + 1;
            Button boton = new Button(descripcion);
            boton.setOnAction(new BotonOpcionComunEventHandler(controlador, descripcion, boton));
            boton.setPrefSize(ANCHO_BOTON_OPCION, ALTO_BOTON_OPCION);
            boton.setFont(new Font(App.FUENTE, 20));
            boton.setStyle(colorBoton);
            botones.add(boton);

          /* FileInputStream input = null;
            try {
                FileInputStream input = new FileInputStream(PATH_IMAGENES_BOTONES + NOMBRE_IMAGENES_PRIMERA_PARTE + contadorDescripciones.toString() + EXTENSION_IMAGENES);
                Image  imagenBoton = new Image(input);
                ImageView imageView = new ImageView(imagenBoton);
                boton.setGraphic(imageView);
            }catch(IOException ex){
            }
            Image  imagenBoton = new Image(input);
            ImageView imageView = new ImageView(imagenBoton);
            boton.setGraphic(imageView);*/

        }

        VBox contenedorDeBotonesOpcion = new VBox();
        contenedorDeBotonesOpcion.getChildren().addAll(botones);
        contenedorDeBotonesOpcion.setSpacing(ESPACIADO_BOTONES);

        Button botonReiniciar = new Button();
        botonReiniciar.setText(REINICIAR);
        botonReiniciar.setPrefSize(ANCHO_BOTON_REINICIAR, ALTO_BOTON_REINICIAR);
        botonReiniciar.setFont(new Font(App.FUENTE, 20));
        botonReiniciar.setOnAction(new BotonReiniciarOpcionesEventHandler(controlador, botones));
        botonReiniciar.setStyle(colorBoton);

        this.getChildren().addAll(contenedorDeBotonesOpcion, botonReiniciar);
        this.setSpacing(ESPACIO_ENTRE_BOTONES_Y_REINICIAR);
        this.setAlignment(Pos.CENTER);
    }

    private List<String> descripcionesDeOpciones(List<Opcion> opciones){
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }
}
