package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class BotonProximaRondaEventHandler implements EventHandler<ActionEvent> {

    private Kahoot kahoot;

    public BotonProximaRondaEventHandler(Kahoot kahoot) {
        this.kahoot = kahoot;
    }

    public void handle(ActionEvent actionEvent) {
        kahoot.proximaRonda();
    }
}