package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.BotonOpcionOrdenadaEventHandler;
import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.util.ArrayList;
import java.util.List;

public class ContenedorDeOrderedChoice extends VBox {

    private static final int ESPACIADO_BOTONES = 15;

    public ContenedorDeOrderedChoice(ControladorRespuesta controlador, List<Opcion> opciones) {
        super();
        List<HBox> contenedoresOpciones = new ArrayList<HBox>();
        List<String> descripciones = this.descripcionesDeOpciones(opciones);
        List<String> indices = this.indicesDeOpciones(opciones.size());


        for (String descripcion : descripciones) {
            HBox opcion = new HBox();
            Label labelDescripcion = new Label(descripcion);
            SplitMenuButton menuDeIndices = this.crearMenuDeOpciones(controlador, indices, descripcion);
            opcion.getChildren().addAll(labelDescripcion, menuDeIndices);
            contenedoresOpciones.add(opcion);
            opcion.setSpacing(5);
        }
        this.getChildren().addAll(contenedoresOpciones);
        this.setSpacing(40);
    }

    private SplitMenuButton crearMenuDeOpciones(ControladorRespuesta controlador, List<String> indices, String descripcion){
        SplitMenuButton menuDeIndices = new SplitMenuButton();
        menuDeIndices.setText("Orden");

        for(String indice: indices){

            MenuItem opcionIndice = new MenuItem(indice);

            opcionIndice.setOnAction(new BotonOpcionOrdenadaEventHandler(controlador, menuDeIndices, opcionIndice, descripcion));
            menuDeIndices.getItems().add(opcionIndice);
        }
        return menuDeIndices;
    }

    private List<String> descripcionesDeOpciones(List<Opcion> opciones) {
        List<String> descripciones = new ArrayList<String>();
        for (Opcion opcion : opciones) {
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }

    private List<String> indicesDeOpciones(int cantidadDeOpciones) {
        List<String> indices = new ArrayList<String>();
        for (Integer i = 1; i <= cantidadDeOpciones; i++) {
            indices.add(i.toString());
        }
        return indices;
    }

}


