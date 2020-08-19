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

    private static final int ESPACIADO_BOTONES = 15;

    public ContenedorDeOrderedChoice(ControladorRespuesta controlador, List<Opcion> opciones) {
        super();
        List<HBox> contenedoresHorizontales = new ArrayList<HBox>();

        List<String> descripciones = this.descripcionesDeOpciones(opciones);
        List<Label> labels = this.labels(descripciones);
        int index = 1;
        int ultimo = descripciones.size();

        for(Opcion opcion : opciones){

            Button flechaArriba = new Button("▲");
            flechaArriba.setPrefSize(28, 28);
            if(index == 1){
                flechaArriba.setOnAction( new BotonOpcionOrdenadaEventHandler(controlador, index, ultimo,
                                                labels.get(0), labels.get(ultimo - 1)));
            }else {
                flechaArriba.setOnAction(new BotonOpcionOrdenadaEventHandler(controlador, index, index - 1,
                                                labels.get(index  - 1 ), labels.get(index - 2)));
            }

            Button flechaAbajo  = new Button("▼");
            flechaAbajo.setPrefSize(28, 28);
            if(index == ultimo){
                flechaAbajo.setOnAction( new BotonOpcionOrdenadaEventHandler(controlador, index, 1,
                                                labels.get(index - 1 ), labels.get(0)));
            }else {
                flechaAbajo.setOnAction(new BotonOpcionOrdenadaEventHandler(controlador, index, index + 1,
                                                labels.get(index -1), labels.get(index)));
            }

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


