package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.ControladorRespuesta;
import edu.fiuba.algo3.modelo.opciones.OpcionOrdenada;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;


public class BotonOpcionOrdenadaEventHandler implements EventHandler<ActionEvent> {

    private ControladorRespuesta controladorRespuesta;
    private int miIndex;
    private int indexAsociado;
    private Label miLabel;
    private Label labelAsociado;

    public BotonOpcionOrdenadaEventHandler(ControladorRespuesta controlador, int miIndex, int indexAsociado,
                                            Label miLabel, Label labelAsociado) {
        this.controladorRespuesta = controlador;
        this.miIndex = miIndex;
        this.indexAsociado = indexAsociado;
        this.miLabel = miLabel;
        this.labelAsociado= labelAsociado;

    }

    public void handle(ActionEvent actionEvent) {
        this.actualizarRespuesta();
        this.permutar();
    }

    private void actualizarRespuesta(){
        controladorRespuesta.actualizarOpcionConDescripcionPor(new OpcionOrdenada(miLabel.getText(), indexAsociado));
        controladorRespuesta.actualizarOpcionConDescripcionPor(new OpcionOrdenada(labelAsociado.getText(), miIndex));
    }
    private void permutar(){
        String aux = miLabel.getText();
        miLabel.setText(labelAsociado.getText());
        labelAsociado.setText(aux);
    }
}
