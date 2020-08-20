package edu.fiuba.algo3.controlador;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import java.util.List;

public class BotonReiniciarOpcionesEventHandler implements EventHandler<ActionEvent> {
    private List<Button> botones;
    private ControladorRespuesta controladorRespuesta;

    public BotonReiniciarOpcionesEventHandler(ControladorRespuesta controladorRespuesta, List<Button> botones) {
        this.controladorRespuesta = controladorRespuesta;
        this.botones = botones;
    }

    public void handle(ActionEvent actionEvent){
        controladorRespuesta.reiniciarOpciones();
        for(Button boton: botones){
            boton.setDisable(false);
        }
    }
}
