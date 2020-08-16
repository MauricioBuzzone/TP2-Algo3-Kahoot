package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Ronda;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

public class BotonAvanzarATurnoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;


    public BotonAvanzarATurnoEventHandler(Stage stage, Scene scene) {
        this.stage = stage;
        this.scene = scene;
    }

    public void handle(ActionEvent actionEvent) {
        stage.setScene(scene);
    }
}
