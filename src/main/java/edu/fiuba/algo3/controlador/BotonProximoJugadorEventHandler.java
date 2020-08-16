package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Ronda;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;



public class BotonProximoJugadorEventHandler implements EventHandler<ActionEvent> {

    private Ronda rondaActiva;

    public BotonProximoJugadorEventHandler(Ronda rondaActiva) {
        this.rondaActiva = rondaActiva;
    }


    public void handle(ActionEvent actionEvent) {
        rondaActiva.proximoJugador();
    }


}