package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.BotonOpcionOrdenadaEventHandler;
import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdenada;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class ContenedorDeOrderedChoice extends VBox {

    private static final String PUNTERO_ARRIBA = "▲";
    private static final String PUNTERO_ABAJO = "▼";
    private static final int ANCHO_BOTON =28;
    private static final int ALTO_BOTON =28;
    private static final int ESPACIADO_BOTONES = 15;

    public ContenedorDeOrderedChoice(ControladorRespuesta controlador, List<Opcion> opciones, String colorBoton) {
        super();
        List<HBox> contenedoresHorizontales = new ArrayList<HBox>();

        List<String> descripciones = this.descripcionesDeOpciones(opciones);
        List<Label> labels = this.labels(descripciones);
        int index = 1;
        int ultimoindex = descripciones.size();

        for(Opcion opcion : opciones){

            Button flechaArriba = this.crearBotonArriba(controlador,colorBoton,labels,index, ultimoindex);

            Button flechaAbajo  = this.crearBotonAbajo(controlador,colorBoton,labels,index, ultimoindex);

            VBox contenedorFlechaArribaAbajo = new VBox(flechaArriba, flechaAbajo);

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

    private Button crearBotonArriba(ControladorRespuesta controlador, String colorBoton, List<Label> labels,int index ,int ultimoIndex){
        Button flechaArriba = this.crearBoton(PUNTERO_ARRIBA,colorBoton);

        if(index == 1){
            Label labelActual = labels.get(0);
            Label labelUltimo = labels.get(ultimoIndex - 1);
            flechaArriba.setOnAction( new BotonOpcionOrdenadaEventHandler(controlador, index, ultimoIndex, labelActual, labelUltimo));
        }else {
            Label labelActual = labels.get(index  - 1);
            Label labelAnterior = labels.get(index  - 2);
            flechaArriba.setOnAction(new BotonOpcionOrdenadaEventHandler(controlador, index, index - 1, labelActual, labelAnterior));
        }
        return flechaArriba;
    }

    private Button crearBotonAbajo(ControladorRespuesta controlador, String colorBoton, List<Label> labels,int index, int ultimoIndex){
        Button flechaAbajo  = this.crearBoton(PUNTERO_ABAJO,colorBoton);

        if(index == ultimoIndex){
            Label labelActual = labels.get(index - 1 );
            Label labelPrimero = labels.get(0);
            flechaAbajo.setOnAction( new BotonOpcionOrdenadaEventHandler(controlador, index, 1, labelActual, labelPrimero));
        }else {
            Label labelActual = labels.get(index - 1 );
            Label labelProximo = labels.get(index);
            flechaAbajo.setOnAction(new BotonOpcionOrdenadaEventHandler(controlador, index, index + 1, labelActual, labelProximo));
        }
        return flechaAbajo;
    }

    private Button crearBoton(String descripcion, String colorBoton){
        Button boton  = new Button(descripcion);
        boton.setPrefSize(ALTO_BOTON, ANCHO_BOTON);
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


