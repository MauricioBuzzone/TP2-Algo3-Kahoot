package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionComun;

import edu.fiuba.algo3.controlador.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class BotonOpcionComunEventHandler implements EventHandler<ActionEvent> {

    private Opcion opcionAsociada;
    private ControladorRespuesta controladorRespuesta;

    public BotonOpcionComunEventHandler(ControladorRespuesta controladorRespuesta,  String opcionAsociada) {
        this.controladorRespuesta = controladorRespuesta;
        this.opcionAsociada = new OpcionComun(opcionAsociada);

    }

    public void handle(ActionEvent actionEvent) {
        controladorRespuesta.agregarOpcion(opcionAsociada);
    }
}