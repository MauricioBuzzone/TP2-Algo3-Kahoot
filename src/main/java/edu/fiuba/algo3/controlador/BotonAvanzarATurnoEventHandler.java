package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.*;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

public class BotonAvanzarATurnoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;
    private Ronda ronda;


    public BotonAvanzarATurnoEventHandler(Stage stage, Scene scene, Ronda ronda) {
        this.stage = stage;
        this.scene = scene;
        this.ronda = ronda;
    }

    public void handle(ActionEvent actionEvent) {
        RespondedorPorDefecto respondedor = new RespondedorPorDefecto(this.ronda);
        ronda.jugadorVaAResponder(respondedor);
        stage.setScene(scene);
    }
}
