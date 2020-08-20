package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.vista.FactoryEscenas;
import edu.fiuba.algo3.vista.Reloj;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

public class BotonComenzarTurnoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene scene;
    private Ronda ronda;
    private Reloj reloj;

    public BotonComenzarTurnoEventHandler(Stage stage, Scene scene, Ronda ronda, Reloj reloj) {
        this.stage = stage;
        this.scene = scene;
        this.ronda = ronda;
        this.reloj = reloj;
    }

    public void handle(ActionEvent actionEvent) {
        RespondedorPorDefecto respondedor = new RespondedorPorDefecto(this.ronda);
        reloj.iniciarReloj();
        ronda.jugadorVaAResponder(respondedor);
        stage.setScene(scene);
    }
}
