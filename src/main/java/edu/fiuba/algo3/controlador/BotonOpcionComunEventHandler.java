package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;


public class BotonOpcionComunEventHandler implements EventHandler<ActionEvent> {

    private Opcion opcionAsociada;
    private ControladorRespuesta controladorRespuesta;
    private Button boton;

    public BotonOpcionComunEventHandler(ControladorRespuesta controladorRespuesta,  String opcionAsociada, Button boton) {
        this.controladorRespuesta = controladorRespuesta;
        this.opcionAsociada = new OpcionComun(opcionAsociada);
        this.boton = boton;
    }

    public void handle(ActionEvent actionEvent) {
        controladorRespuesta.agregarOpcion(opcionAsociada);
        boton.setDisable(true);
    }
}