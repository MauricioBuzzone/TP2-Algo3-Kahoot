/*package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.VistaTurnoJugador;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class BotonProximoTurnoEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Kahoot kahoot;

    public BotonProximoTurnoEventHandler(Stage stage, Kahoot kahoot) {
        this.stage = stage;
        this.kahoot = kahoot;
    }

    public void handle(ActionEvent actionEvent) {

        String enunciado = kahoot.getEnunciado();
        List<String> opciones = kahoot.getOpciones();

        VistaPreguntaVF vistaPregunta = new VistaPreguntaVF(stage, kahoot, enunciado, opciones);
        vistaPregunta.mostrar();
    }
}*/