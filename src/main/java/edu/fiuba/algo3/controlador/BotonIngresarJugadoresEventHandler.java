package edu.fiuba.algo3;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class BotonIngresarJugadoresEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene siguienteEscena;

    public BotonIngresarJugadoresEventHandler(Stage stage, Scene siguienteEscena){
        this.stage = stage;
        this.siguienteEscena = siguienteEscena;
    }

    public void handle(ActionEvent actionEvent){
        stage.setScene(siguienteEscena);
    }
}