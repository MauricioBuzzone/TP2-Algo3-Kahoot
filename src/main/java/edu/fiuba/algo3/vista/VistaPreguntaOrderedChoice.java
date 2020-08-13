package edu.fiuba.algo3;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.App;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.geometry.*;

import java.util.ArrayList;
import java.util.List;

public class VistaPreguntaOrderedChoice {

    private String enunciado;
    private List<Opcion> opciones;

    public VistaPreguntaOrderedChoice(String enunciado, List<Opcion> opciones){
        this.enunciado = enunciado;
        this.opciones = opciones;
    }

    public Scene crearEscena(){
        List<String> descripciones = obtenerDescripciones();
        String titulo = "¡Ordene las siguientes opciones!";
        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado));
        disponerHboxes(descripciones, contenedorPrincipal);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, 350, 300);
    }
    private List<String> obtenerDescripciones(){
        List<String> descripciones = new ArrayList<String>();
        for(Opcion opcion : opciones){
            descripciones.add(opcion.getDescripcion());
        }
        return descripciones;
    }

    public void disponerHboxes(List<String> descripciones, VBox contenedorPrincipal){
        Integer contador = 1;
        for(String descripcion : descripciones){
            Label labelDescripcion = new Label(descripcion);
            Label labelNumero = new Label(contador.toString() + ".");
            TextField textField = new TextField();
            textField.setPromptText("Ingrese una opción");
            HBox contenedorSecundario = new HBox(labelDescripcion, labelNumero, textField);
            contenedorSecundario.setSpacing(40);
            contenedorSecundario.setAlignment(Pos.BASELINE_CENTER);
            contenedorPrincipal.getChildren().add(contenedorSecundario);
            contador = contador + 1;
        }
    }


}