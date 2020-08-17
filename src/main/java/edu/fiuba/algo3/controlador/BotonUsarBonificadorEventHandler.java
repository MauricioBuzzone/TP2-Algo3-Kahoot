package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bonificador;
import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.Jugador;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class BotonUsarBonificadorEventHandler implements EventHandler<ActionEvent> {

    private ControladorRespuesta controladorRespuesta;
    private Bonificador bonificadorAsociado;
    private Button botonAsociado;
    private Button botonComplemento;
    private Jugador jugadorActivo;

    public BotonUsarBonificadorEventHandler(Jugador jugadorActivo, ControladorRespuesta controladorRespuesta, Bonificador bonificadorAsociado, Button botonAsociado, Button botonComplemento){
        this.controladorRespuesta = controladorRespuesta;
        this.bonificadorAsociado = bonificadorAsociado;
        this.botonAsociado = botonAsociado;
        this.botonComplemento = botonComplemento;
        this.jugadorActivo=jugadorActivo;
    }

    public void handle(ActionEvent actionEvent) {
        if (bonificadorAsociado.getFactor() == 2) {
            jugadorActivo.activarx2();
        }
        if (bonificadorAsociado.getFactor() == 3) {
            jugadorActivo.activarx3();
        }
        controladorRespuesta.setBonificador(bonificadorAsociado);
        botonAsociado.setDisable(true);
        botonComplemento.setDisable(true);
    }



}