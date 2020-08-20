package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonExclusividadEventHandler implements EventHandler<ActionEvent> {

    private ControladorRespuesta controlador;
    private Jugador jugadorActivo;
    private Button botonExclusividad;
    public BotonExclusividadEventHandler(ControladorRespuesta controlador, Jugador jugadorActivo , Button botonExclusividad) {
        this.botonExclusividad = botonExclusividad;
        this.jugadorActivo = jugadorActivo;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        jugadorActivo.activarExclusividad();
        botonExclusividad.setDisable(true);
        controlador.activarExclusividad();
    }
}
