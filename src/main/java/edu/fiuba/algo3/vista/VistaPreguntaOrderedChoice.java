package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.App;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.*;

import java.util.ArrayList;
import java.util.List;

public class VistaPreguntaOrderedChoice {

    private Stage stage;
    private Kahoot kahoot;
    private List<TextField> textFields;
    private Scene escena;


    public VistaPreguntaOrderedChoice(Stage stage, Kahoot kahoot, String enunciado, List<String> opciones){
        this.stage = stage;
        this.kahoot = kahoot;
        this.textFields = new ArrayList<TextField>();
        this.escena = this.crearEscena(enunciado, opciones);
    }

    public Scene crearEscena(String enunciado, List<String> opciones){
        String titulo = "¡Ordene las siguientes opciones!";
        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado));

        ControladorRespuesta controladorRespuesta = new ControladorRespuesta(stage, kahoot);

        disponerHboxes(opciones, contenedorPrincipal, controladorRespuesta);


        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controladorRespuesta);
        contenedorPrincipal.getChildren().add(botonEnviar);

        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, 500, 300);
    }

    public void disponerHboxes(List<String> opciones, VBox contenedorPrincipal, ControladorRespuesta controladorRespuesta){
        Integer contador = 1;
        for(String opcion : opciones){

            Label labelOpcion = new Label(opcion);
            Label labelNumero = new Label(contador.toString() + ".");

            TextField textField = new TextField();
            textField.setPromptText("Ingrese una opción");

            Button botonOpcion = new Button();
            botonOpcion.setText("✓");
            botonOpcion.setOnAction(new BotonOpcionOrdenadaEventHandler(controladorRespuesta, textField, contador, botonOpcion));

            HBox contenedorSecundario = new HBox(labelOpcion, labelNumero, textField, botonOpcion);
            contenedorSecundario.setSpacing(40);
            contenedorSecundario.setAlignment(Pos.BASELINE_CENTER);

            contenedorPrincipal.getChildren().add(contenedorSecundario);
            contador = contador + 1;

            textFields.add(textField);
        }
    }

    public void mostrar(){
        this.stage.setScene(escena);
    }


}