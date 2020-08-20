package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.BotonOpcionOrdenadaEventHandler;
import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdenada;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContenedorDeOrderedChoice extends VBox {

    private static final String RUTA_FLECHA_ARRIBA = "file:resources/BotonesOrderedChoice/flechaArriba.png";
    private static final String RUTA_FLECHA_ABAJO = "file:resources/BotonesOrderedChoice/flechaAbajo.png";

    private static final int ANCHO_BOTON =15;
    private static final int ALTO_BOTON =15;
    private static final int ESPACIADO_BOTONES = 15;

    public ContenedorDeOrderedChoice(ControladorRespuesta controlador, List<Opcion> opciones, String colorBoton) {
        super();
        List<HBox> contenedoresHorizontales = new ArrayList<HBox>();

        List<String> descripciones = this.descripcionesDeOpciones(opciones);
        List<Label> labels = this.labels(descripciones);
        int index = 1;
        int ultimoindex = descripciones.size();

        for(Opcion opcion : opciones){

            Button botonArriba = this.crearBoton(RUTA_FLECHA_ARRIBA, colorBoton);
            this.setControladorBotonArriba(controlador, botonArriba, labels, index, ultimoindex);

            Button botonAbajo = this.crearBoton(RUTA_FLECHA_ABAJO, colorBoton);
            this.setControladorBotonAbajo(controlador, botonAbajo, labels, index, ultimoindex);

            VBox contenedorFlechaArribaAbajo = new VBox(botonArriba, botonAbajo);

            HBox contenedorOpcion = new HBox(labels.get(index -1), contenedorFlechaArribaAbajo);
            contenedorOpcion.setSpacing(15);
            contenedorOpcion.setAlignment(Pos.CENTER_RIGHT);
            contenedoresHorizontales.add(contenedorOpcion);

            OpcionOrdenada opcionDefault= new OpcionOrdenada(opcion.getDescripcion(), index );
            index++;
            controlador.agregarOpcion(opcionDefault);
        }

        this.getChildren().addAll(contenedoresHorizontales);
        this.setSpacing(ESPACIADO_BOTONES);
    }

    private void setControladorBotonArriba(ControladorRespuesta controlador, Button botonArriba, List<Label> labels,int index ,int ultimoIndex){

        if(index == 1){
            Label labelActual = labels.get(0);
            Label labelUltimo = labels.get(ultimoIndex - 1);
            botonArriba.setOnAction( new BotonOpcionOrdenadaEventHandler(controlador, index, ultimoIndex, labelActual, labelUltimo));
        }else {
            Label labelActual = labels.get(index  - 1);
            Label labelAnterior = labels.get(index  - 2);
            botonArriba.setOnAction(new BotonOpcionOrdenadaEventHandler(controlador, index, index - 1, labelActual, labelAnterior));
        }
    }


    private void setControladorBotonAbajo(ControladorRespuesta controlador, Button botonAbajo, List<Label> labels,int index ,int ultimoIndex){

        if(index == ultimoIndex){
            Label labelActual = labels.get(index - 1 );
            Label labelPrimero = labels.get(0);
            botonAbajo.setOnAction( new BotonOpcionOrdenadaEventHandler(controlador, index, 1, labelActual, labelPrimero));
        }else {
            Label labelActual = labels.get(index - 1 );
            Label labelProximo = labels.get(index);
            botonAbajo.setOnAction(new BotonOpcionOrdenadaEventHandler(controlador, index, index + 1, labelActual, labelProximo));
        }
    }


    private Button crearBoton(String rutaImagenBoton, String colorBoton){
        Button boton  = new Button();
        Image imagen = new Image(rutaImagenBoton);
        ImageView vistaBoton = new ImageView(imagen);
        vistaBoton.setFitWidth(this.ANCHO_BOTON);
        vistaBoton.setFitHeight(this.ALTO_BOTON);
        boton.setGraphic(vistaBoton);

        boton.setStyle(colorBoton);
        return boton;
    }

    private List<Label> labels(List<String> descripciones){
        List<Label> labels = new ArrayList<Label>();
        for (String descripcion : descripciones) {
            Label labelDescripcion = new Label(descripcion);
            labelDescripcion.setFont(new Font(App.FUENTE, 20));
            labels.add(labelDescripcion);
        }
        return labels;
    }

    private List<String> descripcionesDeOpciones(List<Opcion> opciones) {
        List<String> descripciones = new ArrayList<String>();
        for (Opcion opcion : opciones) {
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }
}


