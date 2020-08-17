package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.EscenaElegirJugadores;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class BotonIngresarJugadoresEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Label labelArchivo;

    public BotonIngresarJugadoresEventHandler(Stage stage, Label labelArchivo){
        this.stage = stage;
        this.labelArchivo = labelArchivo;
    }

    public void handle(ActionEvent actionEvent){
        Scene escenaDeElegirJugadores = new EscenaElegirJugadores(stage, labelArchivo.getText(), new VBox());
        stage.setScene(escenaDeElegirJugadores);
    }
}