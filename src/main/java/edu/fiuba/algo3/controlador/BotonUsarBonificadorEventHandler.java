package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.opciones.OpcionComun;
import edu.fiuba.algo3.modelo.Bonificador;
import javafx.scene.control.Button;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class BotonUsarBonificadorEventHandler implements EventHandler<ActionEvent> {

    private ControladorRespuesta controladorRespuesta;
    private Bonificador bonificadorAsociado;
    private Button botonAsociado;
    private Button botonComplemento;

    public BotonUsarBonificadorEventHandler(ControladorRespuesta controladorRespuesta, Bonificador bonificadorAsociado, Button botonAsociado, Button botonComplemento){
        this.controladorRespuesta = controladorRespuesta;
        this.bonificadorAsociado = bonificadorAsociado;
        this.botonAsociado = botonAsociado;
        this.botonComplemento = botonComplemento;
    }

    public void handle(ActionEvent actionEvent) {
        controladorRespuesta.setBonificador(bonificadorAsociado);
        botonAsociado.setDisable(true);
        botonComplemento.setDisable(true);
    }



}