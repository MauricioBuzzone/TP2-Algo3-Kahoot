package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.ControladorRespuesta;
import edu.fiuba.algo3.BotonOpcionComunEventHandler;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


import java.util.List;


public class VistaPreguntaVF {

    private Kahoot kahoot;
    private Scene escena;
    private Stage stage;

    public VistaPreguntaVF(Stage stage, Kahoot kahoot, String enunciado, List<String> opciones) {
        this.kahoot = kahoot;
        this.stage  = stage;
        this.escena = this.crearEscena(enunciado, opciones);
    }

    private Scene crearEscena(String enunciado, List<String> opciones) {

        String titulo = "Verdadero Falso";

        ControladorRespuesta controlador = new ControladorRespuesta(stage, kahoot);

        Button botonVerdadero = new Button();
        botonVerdadero.setText(opciones.get(0));
        botonVerdadero.setOnAction(new BotonOpcionComunEventHandler(controlador, opciones.get(0)));

        Button botonFalso = new Button();
        botonFalso.setText(opciones.get(1));
        botonFalso.setOnAction(new BotonOpcionComunEventHandler(controlador, opciones.get(1)));

        Button botonEnviar = new Button();
        botonEnviar.setText("E n v i a r");
        botonEnviar.setOnAction(controlador);

        HBox contenedorBotones = new HBox(botonVerdadero, botonFalso);
        contenedorBotones.setSpacing(20);
        VBox contenedorPrincipal = new VBox(new Label(titulo), new Label(enunciado), contenedorBotones, botonEnviar);
        contenedorPrincipal.setSpacing(10);
        return new Scene(contenedorPrincipal, 350, 300);
    }

    public void mostrar(){
        this.stage.setScene(escena);
    }
}